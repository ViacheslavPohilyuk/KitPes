package org.kitpes.web.controller.json.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.kitpes.security.AuthenticatedUserIdRetriever;
import org.kitpes.security.UserPrincipal;
import org.kitpes.data.contract.FoundLostPetRepository;
import org.kitpes.image.ImageHandler;
import org.kitpes.model.FoundLostPet;

import org.kitpes.model.form.DatePetLostFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class FoundLostPetJsonController {

    @Autowired
    private FoundLostPetRepository foundLostPetRepository;

    @Autowired
    private AuthenticatedUserIdRetriever retriever;

    @Autowired
    private ImageHandler imageHandler;

    @RequestMapping(value = "limited", method = GET)
    public List<FoundLostPet> petsLimited(@RequestParam(value = "type") int type,
                                          @RequestParam(value = "bunch") int bunch) {
        int bunchSize = 16;
        return foundLostPetRepository.readLimited(type, (bunch * bunchSize), bunchSize);
    }

    /**
     * Getting all pets
     *
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public List<FoundLostPet> pets(@RequestParam(required = false) Boolean type,
                                   @RequestParam(required = false) Long userId) {
        return foundLostPetRepository.readAll(type, userId);
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
     * @return ResponseEntity about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    @PreAuthorize("foundLostPet.userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateID(FoundLostPet foundLostPet) {
        foundLostPetRepository.updateOne(foundLostPet);
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
        foundLostPetRepository.deleteOne(id);
        return new ResponseEntity<>("Pet have been successfully deleted", HttpStatus.OK);
    }

    /**
     * Creating new pet and adding one to the db
     *
     * @param foundLostPet pet instance that was created from the web-filter fields data
     * @return jsp with data of a new pet
     */
    @RequestMapping(value = "/new", method = POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity create(@RequestPart(required = false, value = "profilePicture") MultipartFile file,
                                 @RequestParam Boolean type,
                                 FoundLostPet foundLostPet,
                                 DatePetLostFound date) throws IOException {
        /* Set type (Found pet) */
        foundLostPet.setType(type);

        /* Get date of day, month and year when pet was found
         * and unite them in one string */
        foundLostPet.setDateLostFound(date.dateConstruct());

        /* Bind new pet to the current authentificated user */
        foundLostPet.setUserId(retriever.getId(););

        /* Set profile image of a new pet */
        if (file != null) {
            foundLostPet.setProfileImgURL(imageHandler.process(file));
        }

        foundLostPetRepository.save(foundLostPet);
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
        foundLostPetRepository.updateProfileImage(imageHandler.process(file), foundLostPetID);
        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}
