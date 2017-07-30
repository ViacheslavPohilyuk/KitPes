/*package org.kitpes.web.rest.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.data.contract.NewsRepository;
import org.kitpes.image.ImageHandler;
import org.kitpes.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
*/
/**
 * Created by mac on 02.07.17.
 */
/*
@RestController
@RequestMapping("api/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private ImageHandler imageHandler;

    @RequestMapping(method = GET)
    public List<News> allNews() {
        return newsRepository.readAll();
    }

    @RequestMapping(value = "{id}", method = GET)
    public News news(@PathVariable long id) {
        return newsRepository.readOne(id);
    }

    @RequestMapping(value = "/edit", method = POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity updateID(News news) {
        newsRepository.updateOne(news);
        return new ResponseEntity<>("News have been successfully changed", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteID(@PathVariable long id) {
        newsRepository.deleteOne(id);
        return new ResponseEntity<>("News have been successfully deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/new", method = POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity create(@RequestPart(required = false, value = "profilePicture") MultipartFile file,
                                 News news) throws IOException {
        news.setImage(imageHandler.process(file));

        newsRepository.save(news);
        return new ResponseEntity<>("News have been successfully saved", HttpStatus.OK);

    }

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity processUpload(@RequestPart("profilePicture") MultipartFile file,
                                        Long newsID) throws IOException {
        newsRepository.updateProfileImage(imageHandler.process(file), newsID);
        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}*/
