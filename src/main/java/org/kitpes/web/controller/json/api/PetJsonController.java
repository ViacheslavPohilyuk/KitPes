package org.kitpes.web.controller.json.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.config.cloud.CloudService;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.model.FoundLostPet;
import org.kitpes.model.Message;
import org.kitpes.model.Pet;

import org.kitpes.model.filter.FilterPet;
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

/**
 * Created by mac on 14.04.17.
 */
@RestController
@RequestMapping("api/pet")
public class PetJsonController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CloudService cloudService;

    @RequestMapping(value = "/count", method = GET)
    public int count() {
        return petRepository.totalPets();
    }

    @RequestMapping(value = "limited", method = GET)
    public List<Pet> petsLimited(@RequestParam(value = "bunch") int bunch) {
        int bunchSize = 8;
        return petRepository.readLimited((bunch * bunchSize), bunchSize);
    }
    /**
     * Getting all pets
     *
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public List<Pet> pets() {
        return petRepository.readAll();
    }

    /**
     * A purpose of this method is a filtering data by
     * five fields of the {@code Pet class}: species, sex, status, organizationID and age
     *
     * @return list of Pet objects
     */
    @RequestMapping(value = "/filter", method = GET)
    public List<Pet> filter(FilterPet filterForm) {
        return filterForm.filtering(petRepository.readAll());
    }

    /**
     * Getting an one pet
     *
     * @return list of Pet objects
     */
    @RequestMapping(value = "{id}", method = GET)
    public Pet pet(@PathVariable long id) {
        return petRepository.readOne(id);
    }

    /**
     * Update data of a required pet
     *
     * @param pet pet that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    @PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateID(Pet pet, long userId) {
        petRepository.updateOne(pet);
        return new ResponseEntity<>("Pet have been successfully changed", HttpStatus.OK);

    }

    /**
     * Delete a pet by its id
     *
     * @param id an id of a pet
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    @PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteID(@PathVariable long id, @RequestParam(required = false) long userId) {
        petRepository.deleteOne(id);
        return new ResponseEntity<>("Pet have been successfully changed", HttpStatus.OK);

    }

    /**
     * Creating new pet and adding one to the db
     *
     * @param pet pet instance
     * @return jsp with data of a new pet
     */
    @RequestMapping(value = "/new", method = POST)
    @PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity create(@RequestPart(required = false, value = "profilePicture") MultipartFile file,
                          Pet pet, long userId) throws IOException {

        /* Set profile image of a new pet */
        if(file != null) {
            Map uploadResult = ((Cloudinary) cloudService
                    .getConnection())
                    .uploader()
                    .upload(file.getBytes(), ObjectUtils.emptyMap());
            pet.setProfileImgURL((String) uploadResult.get("url"));
        }

        petRepository.save(pet);
        return new ResponseEntity<>("Pet have been successfully changed", HttpStatus.OK);

    }

    /**
     * Processing image files those user uploads on an pet's
     * profile page
     *
     * @param file  image that is an avatar of an pet
     * @param petID id of an pet
     * @return redirection to an pet's profile page
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @PreAuthorize("#userId == authentication.principal.user.id  or hasRole('ROLE_ADMIN')")
    public ResponseEntity processUpload(@RequestPart("profilePicture") MultipartFile file,
                                 long userId, Long petID) throws IOException {
        Map uploadResult = ((Cloudinary) cloudService
                .getConnection())
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        petRepository.updateProfileImage(profileImage, petID);
        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}
