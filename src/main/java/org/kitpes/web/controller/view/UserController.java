package org.kitpes.web.controller.view;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.kitpes.config.cloud.CloudService;
import org.kitpes.config.security.UserPrincipal;
import org.kitpes.data.contract.OrganizationRepository;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.data.contract.UserRepository;
import org.kitpes.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 13.05.17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    private OrganizationRepository organizationRepository;

    private PetRepository petRepository;

    private CloudService cloudService;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Autowired
    public void setOrganizationRepository(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Autowired
    public void setCloudService(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    /**
     * Getting a profile of a user by id
     *
     * @param id    an id of a user
     * @param model adding a user to the model
     * @return web-page with data of an one user
     */
    @RequestMapping(value = "/{id}", method = GET)
    @PreAuthorize("#id == authentication.principal.user.id or hasRole('ROLE_USER')")
    public String user(@PathVariable long id,
                       Model model) {
        User user = userRepository.readOne(id);

        /* Reading all pets from the db with an id of this user */
        //user.setPets(petRepository.readByUserID(id));
        /* Reading all organizations from the db with an id of this user */
        //user.setOrganizations(organizationRepository.readByUserID(id));

        model.addAttribute(user);
        return "user_profile";
    }

    /**
     * Method that redirects to the user's profile when
     * one successfully signed in
     *
     * @return view with user's profile
     */
    @RequestMapping(value = "/afterLogin", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String redirectUserProfile() {
        long id = ((UserPrincipal) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()).getUser().getId();
        return "redirect:/user/" + id;
    }

    /**
     * Getting all users
     *
     * @param model adding a user to the model
     * @return list of user objects
     */
    @RequestMapping(method = GET)
    public String users(Model model) {
        List<User> users = userRepository.readAll();

        model.addAttribute("userList", users);
        return "user/all";
    }

    /**
     * Getting web-filter with data of a user that will be updated
     *
     * @param id    an id of a user
     * @param model model that will contain a user instance
     * @return web-filter with fields which contain data of a user
     * will be updated
     */
    @RequestMapping(value = "/edit/{id}", method = GET)
    public String updatedGet(@PathVariable long id,
                             Model model) {
        User user = userRepository.readOne(id);
        model.addAttribute(user);
        return "user/edit";
    }

    /**
     * Update data of a required user
     *
     * @param user user that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    public String updateID(User user) {
        userRepository.updateOne(user);
        return "redirect:/user/" + user.getId();
    }

    /**
     * Delete a user by its id
     *
     * @param id an id of a user
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteID(@PathVariable long id) {
        userRepository.deleteOne(id);
        return "redirect:/user";
    }

    /**
     * Processing image files those user uploads on an user's
     * profile page
     *
     * @param file   image that is an avatar of an user
     * @param userID id of an user
     * @return redirection to an user's profile page
     */
    /* @RequestMapping(value = "/fileupload", method = POST)
    public String processUpload(@RequestPart("profilePicture") MultipartFile file,
                                Long userID) throws IOException {
        Map uploadResult = ((Cloudinary) cloudService
                .getConnection())
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        userRepository.updateProfileImage(profileImage, userID);
        return "redirect:/user/" + userID;
    } */
}
