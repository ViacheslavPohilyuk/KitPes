package org.kitpes.web.controller.rest.api.pet;

import org.kitpes.data.contract.PetRepository;
import org.kitpes.model.Pet;
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

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by mac on 03.07.17.
 */
@RestController
@RequestMapping("api/pet")
public class HomelessPetController {

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

    @RequestMapping(method = GET)
    public List<Pet> pets(@RequestParam(required = false) Boolean type,
                          @RequestParam(required = false) Long userId) {
        return petRepository.readAll(type, userId);
    }

    @RequestMapping(value = "{id}", method = GET)
    public Pet pet(@PathVariable long id) {
        return petRepository.readOne(id);
    }

    @RequestMapping(method = PUT)
    @PreAuthorize("pet.userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateID(Pet pet) {
        petRepository.updateOne(pet);
        return new ResponseEntity<>("Pet have been successfully changed", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteID(@PathVariable long id, long userId) {
        petRepository.deleteOne(id);
        return new ResponseEntity<>("Pet have been successfully deleted", HttpStatus.OK);
    }

    @RequestMapping(method = POST)
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

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity processUpload(@RequestPart("profilePicture") MultipartFile file,
                                        long userId, Long foundLostPetID) throws IOException {
        petRepository.updateProfileImage(imageHandler.process(file), foundLostPetID);
        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}
