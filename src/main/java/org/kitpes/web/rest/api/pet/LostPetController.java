package org.kitpes.web.rest.api.pet;

import org.kitpes.image.ImageHandler;
import org.kitpes.model.form.DatePetLostFound;
import org.kitpes.model.pet.LostPet;
import org.kitpes.data.repo.pet.LostPetRepository;
import org.kitpes.security.AuthenticatedUserIdRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by mac on 28.07.17.
 */
@RestController
@RequestMapping("api/lost_pet")
public class LostPetController {

    @Autowired
    private LostPetRepository repository;

    @Autowired
    private AuthenticatedUserIdRetriever retriever;

    @Autowired
    private ImageHandler imageHandler;

    /* @RequestMapping(value = "limited", method = GET)
    public List<Pet> petsLimited(@RequestParam(value = "type") int type,
                                 @RequestParam(value = "bunch") int bunch) {
        int bunchSize = 16;
        return repository.readLimited(type, (bunch * bunchSize), bunchSize);
    } */

    @RequestMapping(method = GET)
    public Collection<LostPet> pets() {
        return repository.getAll();
    }

    @RequestMapping(value = "{id}", method = GET)
    public LostPet pet(@PathVariable long id) {
        return repository.get(id);
    }

    @RequestMapping(method = PUT)
    @PreAuthorize("pet.userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateID(LostPet pet) {
        repository.update(pet);
        return new ResponseEntity<>("Pet have been successfully changed", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteID(@PathVariable long id, long userId) {
        repository.delete(id);
        return new ResponseEntity<>("Pet have been successfully deleted", HttpStatus.OK);
    }

    @RequestMapping(method = POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity create(@RequestPart(required = false, value = "profilePicture") MultipartFile file,
                                 LostPet pet,
                                 DatePetLostFound date) throws IOException {
        /* Get date of day, month and year when pet was found
         * and unite them in one string */
        String dateLostFound = date.dateConstruct();
        if (dateLostFound != null) {
            pet.setDateLost(dateLostFound);
        }

        /* Bind new pet to the current authentificated user */
        pet.setUserId(retriever.getId());

        /* Set profile image of a new pet */
        if (file != null) {
            pet.setProfileImgURL(imageHandler.process(file));
        }

        repository.save(pet);
        return new ResponseEntity<>("Pet have been successfully added", HttpStatus.OK);
    }

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity processUpload(@RequestPart("profilePicture") MultipartFile file,
                                        long userId, Long foundLostPetID) throws IOException {
        repository.updateImage(imageHandler.process(file), foundLostPetID);
        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}
