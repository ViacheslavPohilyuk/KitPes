package org.kitpes.web.rest.api.pet;

import org.kitpes.model.pet.HomelessPet;
import org.kitpes.data.repo.pet.HomelessPetRepository;
import org.kitpes.security.AuthenticatedUserIdRetriever;
import org.kitpes.image.ImageHandler;

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
 * Created by mac on 03.07.17.
 */
@RestController
@RequestMapping("api/homeless_pet")
public class HomelessPetController {

    @Autowired
    private HomelessPetRepository repository;

    @Autowired
    private AuthenticatedUserIdRetriever retriever;

    @Autowired
    private ImageHandler imageHandler;

    /* @RequestMapping(value = "limited", method = GET)
    public List<HomelessPet> petsLimited(@RequestParam(value = "type") int type,
                                 @RequestParam(value = "bunch") int bunch) {
        int bunchSize = 16;
        return repository.readLimited(type, (bunch * bunchSize), bunchSize);
    } */

    @RequestMapping(method = GET)
    public Collection<HomelessPet> pets() {
        return repository.getAll();
    }

    @RequestMapping(value = "{id}", method = GET)
    public HomelessPet pet(@PathVariable long id) {
        return repository.get(id);
    }

    @RequestMapping(method = PUT)
    @PreAuthorize("pet.user.id == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateID(HomelessPet pet) {
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
                                 HomelessPet pet) throws IOException {
        /* Bind new pet to the current authentificated user */
        pet.getUser().setId(retriever.getId());

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
