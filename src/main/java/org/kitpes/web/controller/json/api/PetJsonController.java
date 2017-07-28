package org.kitpes.web.controller.json.api;

import org.kitpes.data.contract.PetRepository;
import org.kitpes.model.Pet;
import org.kitpes.model.filter.FilterPet;
import org.kitpes.security.AuthenticatedUserIdRetriever;
import org.kitpes.image.ImageHandler;

import org.kitpes.model.form.DatePetLostFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 03.07.17.
 */
@RestController
@RequestMapping("api/pet")
public class PetJsonController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AuthenticatedUserIdRetriever retriever;

    @Autowired
    private ImageHandler imageHandler;

    @RequestMapping(value = "limited", method = GET)
    public List<Pet> petsLimited(@RequestParam(value = "type") int type,
                                 @RequestParam(value = "bunch") int bunch) {
        int bunchSize = 16;
        return petRepository.readLimited(type, (bunch * bunchSize), bunchSize);
    }

    /**
     * Getting all pets
     *
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public List<Pet> pets(@RequestParam(required = false) Boolean type,
                          @RequestParam(required = false) Long userId) {
        return petRepository.readAll(type, userId);
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
     * @return ResponseEntity about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    @PreAuthorize("pet.userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateID(Pet pet) {
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
    public ResponseEntity deleteID(@PathVariable long id, long userId) {
        petRepository.deleteOne(id);
        return new ResponseEntity<>("Pet have been successfully deleted", HttpStatus.OK);
    }

    /**
     * A purpose of this method is a filtering data by
     * five fields of the {@code Pet class}: species, sex, status, organizationID and age
     *
     * @return list of Pet objects
     */
    /*@RequestMapping(value = "/filter", method = GET)
    public List<Pet> filter(FilterPet filterForm) {
        return filterForm.filtering(petRepository.readAll());
    }*/

    /**
     * Creating new pet and adding one to the db
     *
     * @param pet pet instance that was created from the web-filter fields data
     * @return jsp with data of a new pet
     */
    @RequestMapping(value = "/new", method = POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity create(@RequestPart(required = false, value = "profilePicture") MultipartFile file,
                                 @RequestParam Integer type,
                                 Pet pet,
                                 DatePetLostFound date) throws IOException {
        /* Set type (Found pet) */
        pet.setType(type);

        /* Get date of day, month and year when pet was found
         * and unite them in one string */
        String dateLostFound = date.dateConstruct();
        if (dateLostFound != null) {
            pet.setDateLostFound(dateLostFound);
        }

        /* Bind new pet to the current authentificated user */
        pet.setUserId(retriever.getId());

        /* Set profile image of a new pet */
        if (file != null) {
            pet.setProfileImgURL(imageHandler.process(file));
        }

        petRepository.save(pet);
        return new ResponseEntity<>("Pet have been successfully added", HttpStatus.OK);
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
    @PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity processUpload(@RequestPart("profilePicture") MultipartFile file,
                                        long userId, Long foundLostPetID) throws IOException {
        petRepository.updateProfileImage(imageHandler.process(file), foundLostPetID);
        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}
