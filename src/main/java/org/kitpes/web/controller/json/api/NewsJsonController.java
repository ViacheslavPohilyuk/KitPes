package org.kitpes.web.controller.json.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.config.cloud.CloudService;
import org.kitpes.data.contract.NewsRepository;
import org.kitpes.model.Message;
import org.kitpes.model.News;
import org.kitpes.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 02.07.17.
 */
@RestController
@RequestMapping("api/news")
public class NewsJsonController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private CloudService cloudService;

    /**
     * Getting all news
     *
     * @return list of News objects
     */
    @RequestMapping(method = GET)
    public List<News> allNews() {
        return newsRepository.readAll();
    }

    /**
     * Getting an one news
     *
     * @return list of news objects
     */
    @RequestMapping(value = "{id}", method = GET)
    public News News(@PathVariable long id) {
        return newsRepository.readOne(id);
    }

    /**
     * Update data of a required News
     *
     * @param news news that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Message updateID(News news) {
        return new Message((newsRepository.updateOne(news) != 0) ? 1 : 0);
    }

    /**
     * Delete a News by its id
     *
     * @param id an id of a News
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Message deleteID(@PathVariable long id) {
        return new Message((newsRepository.deleteOne(id) != 0) ? 1 : 0);
    }

    /**
     * Creating new News and adding one to the db
     *
     * @param news News instance that was created from the web-filter fields data
     * @return jsp with data of a new News
     */
    @RequestMapping(value = "/new", method = POST)
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Message create(@RequestPart(required = false, value = "profilePicture") MultipartFile file,
                          News news) throws IOException {

        /* Set profile image of a new pet */
        if(file != null) {
            Map uploadResult = ((Cloudinary) cloudService
                    .getConnection())
                    .uploader()
                    .upload(file.getBytes(), ObjectUtils.emptyMap());
            news.setImage((String) uploadResult.get("url"));
        }

        return new Message((newsRepository.save(news) != 0) ? 1 : 0);
    }

    /**
     * Processing image files those user uploads on an News's
     * profile page
     *
     * @param file   image that is an avatar of an News
     * @param newsID id of an News
     * @return redirection to an News's profile page
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Message processUpload(@RequestPart("profilePicture") MultipartFile file,
                                 Long newsID) throws IOException {
        Map uploadResult = ((Cloudinary) cloudService
                .getConnection())
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        return new Message((newsRepository.updateProfileImage(profileImage, newsID) != 0) ? 1 : 0);
    }
}
