package org.kitpes.web.controller.json.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.kitpes.config.cloud.CloudService;
import org.kitpes.data.contract.OrganizationRepository;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.data.contract.UserRepository;
import org.kitpes.model.Message;
import org.kitpes.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * Getting a profile of a user by id
     *
     * @param id an id of a user
     * @return web-page with data of an one user
     */
    @RequestMapping(value = "/{id}", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public User user(@PathVariable long id) {
        for (GrantedAuthority role : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            System.out.println(role.toString());
        }

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
    @PreAuthorize("#user.username == authentication.name or hasRole('ROLE_ADMIN')")
    public Message updateID(User user) {
        return new Message((userRepository.updateOne(user) != 0) ? 1 : 0);
    }

    /**
     * Delete a user by its id
     *
     * @param id an id of a user
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Message deleteID(@PathVariable long id) {
        return new Message((userRepository.deleteOne(id) != 0) ? 1 : 0);
    }

    /**
     * Processing image files those user uploads on an user's
     * profile page
     *
     * @param file     image that is an avatar of an user
     * @param username id of an user
     * @return redirection to an user's profile page
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public Message processUpload(@RequestPart("profilePicture") MultipartFile file,
                                 String username) throws IOException {
        Cloudinary cloud = cloudService.getConnection();
        Map uploadResult = cloud
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        return new Message((userRepository.updateProfileImage(profileImage, username) != 0) ? 1 : 0);
    }
}
