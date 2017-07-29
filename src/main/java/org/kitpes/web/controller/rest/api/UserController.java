package org.kitpes.web.controller.rest.api;

import org.kitpes.data.contract.OrganizationRepository;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.data.contract.UserRepository;
import org.kitpes.image.ImageHandler;
import org.kitpes.model.User;

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
 * Created by mac on 13.05.17.
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private ImageHandler imageHandler;

    /**
     * Getting a profile of a user by id
     *
     * @param id an id of a user
     * @return web-page with data of an one user
     */
    @RequestMapping(value = "/{id}", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public User user(@PathVariable long id) {
        User user = userRepository.readOne(id);
        user.setPets(petRepository.readByUserID(user.getId()));
        user.setOrganizations(organizationRepository.readByUserID(user.getId()));
        return user;
    }

    /**
     * Getting all users
     *
     * @return list of user objects
     */
    @RequestMapping(method = GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> users() {
        List<User> users = userRepository.readAll();
        for (User user : users) {
            user.setPets(petRepository.readByUserID(user.getId()));
            user.setOrganizations(organizationRepository.readByUserID(user.getId()));
        }
        return users;
    }

    /**
     * Update data of a required user
     *
     * @param user user that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    @PreAuthorize("#user.id == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateID(User user) {
        userRepository.updateOne(user);
        return new ResponseEntity<>("User have been successfully changed", HttpStatus.OK);

    }

    /**
     * Delete a user by its id
     *
     * @param id an id of a user
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteID(@PathVariable long id) {
        userRepository.deleteOne(id);
        return new ResponseEntity<>("User have been successfully deleted", HttpStatus.OK);

    }

    /**
     * Processing image files those user uploads on an user's
     * profile page
     *
     * @param file   image that is an avatar of an user
     * @param userId of an user
     * @return redirection to an user's profile page
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    //@PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity processUpload(@RequestPart("profilePicture") MultipartFile file,
                                        long userId) throws IOException {

        userRepository.updateProfileImage(imageHandler.process(file), userId);
        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}
