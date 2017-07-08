package org.kitpes.web.controller.json.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.kitpes.config.cloud.CloudService;
import org.kitpes.config.security.UserPrincipal;
import org.kitpes.data.contract.OrganizationRepository;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.data.contract.UserRepository;
import org.kitpes.model.Message;
import org.kitpes.model.Pet;
import org.kitpes.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 13.05.17.
 */
@RestController
@RequestMapping("api/user")
public class UserJsonController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private CloudService cloudService;

    // User userAuth = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();

    /**
     * Getting all users
     *
     * @return list of user objects
     */
    @RequestMapping(method = GET)
    public List<User> users() {
        System.out.println("Auth NAME: " + SecurityContextHolder.getContext().getAuthentication().getName());
        List<User> users = userRepository.readAll();
        for (User user : users) {
            user.setPets(petRepository.readByUserID(user.getId()));
            user.setOrganizations(organizationRepository.readByUserID(user.getId()));
        }
        return users;
    }

    /**
     * Getting a profile of a user by id
     *
     * @param id an id of a user
     * @return web-page with data of an one user
     */
    @RequestMapping(value = "/{id}", method = GET)
    public User user(@PathVariable long id) {
        User user =  userRepository.readOne(id);
        user.setPets(petRepository.readByUserID(user.getId()));
        user.setOrganizations(organizationRepository.readByUserID(user.getId()));
        return user;
    }

    /**
     * Creating new user and adding one to the db
     *
     * @param user user instance that was created from the web-filter fields data
     * @return jsp with data of a new user
     */
    @RequestMapping(value = "/register", method = POST)
    public Message register(@Valid User user) {
        return new Message((userRepository.save(user) != 0) ? 1 : 0);
    }

    /**
     * Update data of a required user
     *
     * @param user user that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    public Message updateID(User user) {
        return new Message((userRepository.updateOne(user) != 0) ? 1 : 0);
    }

    /**
     * Delete a user by its id
     *
     * @param id an id of a user
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    public Message deleteID(@PathVariable long id) {
        return new Message((userRepository.deleteOne(id) != 0) ? 1 : 0);
    }

    /**
     * Processing image files those user uploads on an user's
     * profile page
     *
     * @param file   image that is an avatar of an user
     * @param userID id of an user
     * @return redirection to an user's profile page
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public Message processUpload(@RequestPart("profilePicture") MultipartFile file,
                                 Long userID) throws IOException {
        Cloudinary cloud = cloudService.getConnection();
        Map uploadResult = cloud
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        return new Message((userRepository.updateProfileImage(profileImage, userID) != 0) ? 1 : 0);
    }
}
