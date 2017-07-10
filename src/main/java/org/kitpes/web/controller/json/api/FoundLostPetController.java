package org.kitpes.web.controller.json.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import io.swagger.annotations.Api;
import org.kitpes.config.cloud.CloudService;
import org.kitpes.data.contract.FoundLostPetRepository;
import org.kitpes.model.FoundLostPet;
import org.kitpes.model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 03.07.17.
 */
@RestController
@RequestMapping("api/foundlostpets")
public class FoundLostPetController {

    @Autowired
    private FoundLostPetRepository foundLostPetRepository;

    @Autowired
    private CloudService cloudService;

    /**
     * Getting all pets
     *
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public List<FoundLostPet> pets(@RequestParam(required = false) Integer type) {
        return foundLostPetRepository.readAll(type);
    }

    /**
     * Getting an one pet
     *
     * @return list of Pet objects
     */
    @RequestMapping(value = "{id}", method = GET)
    public FoundLostPet pet(@PathVariable long id) {
        return foundLostPetRepository.readOne(id);
    }

    /**
     * Update data of a required pet
     *
     * @param foundLostPet pet that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    public Message updateID(FoundLostPet foundLostPet) {
        return new Message((foundLostPetRepository.updateOne(foundLostPet) != 0) ? 1 : 0);
    }

    /**
     * Delete a pet by its id
     *
     * @param id an id of a pet
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    public Message deleteID(@PathVariable long id) {
        return new Message((foundLostPetRepository.deleteOne(id) != 0) ? 1 : 0);
    }

    /**
     * Creating new pet and adding one to the db
     *
     * @param foundLostPet pet instance that was created from the web-filter fields data
     * @return jsp with data of a new pet
     */
    @RequestMapping(value = "/new", method = POST)
    public Message create(@RequestPart(required = false, value = "profilePicture") MultipartFile file,
                          FoundLostPet foundLostPet) throws IOException {

        /* Set profile image of a new pet */
        if(file != null) {
            Map uploadResult = ((Cloudinary) cloudService
                    .getConnection())
                    .uploader()
                    .upload(file.getBytes(), ObjectUtils.emptyMap());
            foundLostPet.setProfileImgURL((String) uploadResult.get("url"));
        }

        return new Message((foundLostPetRepository.save(foundLostPet) != 0) ? 1 : 0);
    }

    /**
     * Processing image files those user uploads on an pet's
     * profile page
     *
     * @param file           image that is an avatar of an pet
     * @param foundLostPetID id of an pet
     * @return redirection to an pet's profile page
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public Message processUpload(@RequestPart("profilePicture") MultipartFile file,
                                 Long foundLostPetID) throws IOException {
        Map uploadResult = ((Cloudinary) cloudService
                .getConnection())
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        return new Message((foundLostPetRepository.updateProfileImage(profileImage, foundLostPetID) != 0) ? 1 : 0);
    }
}
