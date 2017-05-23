package org.kitpes.web.controller.entity;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.data.organization.OrganizationRepository;
import org.kitpes.data.pet.PetRepository;
import org.kitpes.data.user.UserRepository;
import org.kitpes.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
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
@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    private PetRepository petRepository;

    private OrganizationRepository organizationRepository;

    private Cloudinary cloudinary;

    @Autowired
    public UserController(UserRepository userRepository) {
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
    public void setCloudService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    /**
     * Getting all users
     *
     * @param model adding a user to the model
     * @return list of user objects
     */
    @RequestMapping(method = GET)
    public String users(Model model) {
        List<User> users =  userRepository.readAll();

        model.addAttribute("userList", users);
        return "user/all";
    }

    /**
     * Getting a profile of a user by id
     *
     * @param id    an id of a user
     * @param model adding a user to the model
     * @return web-page with data of an one user
     */
    @RequestMapping(value = "/{id}", method = GET)
    public String user(@PathVariable long id,
                      Model model) {
        User user = userRepository.readOne(id);
        /* Reading all pets from the db with an id of this user */
        user.setPets(petRepository.readByUserID(id));
        /* Reading all organizations from the db with an id of this user */
        user.setOrganizations(organizationRepository.readbyUserID(id));

        model.addAttribute(user);
        return "user/userProfile";
    }

    /**
     * Getting web-form with data of a user that will be updated
     *
     * @param id    an id of a user
     * @param model model that will contain a user instance
     * @return web-form with fields which contain data of a user
     * will be updated
     */
    @RequestMapping(value = "/edit/{id}", method = GET)
    public String updatedGet(@PathVariable long id,
                             Model model) {
        User user =  userRepository.readOne(id);
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
     * Get web-form with fields for put data of a new user
     *
     * @return jsp for create a new user
     */
    @RequestMapping(value = "/register", method = GET)
    public String registerForm(Model model) {
        model.addAttribute(new User());
        return "user/register";
    }

    /**
     * Creating new user and adding one to the db
     *
     * @param user user instance that was created from the web-form fields data
     * @return jsp with data of a new user
     */
    @RequestMapping(value = "/register", method = POST)
    public String create(@Valid User user, Errors errors) {
        /* Validation */
        if (errors.hasErrors()) {
            return "user/register";
        }

        long key = userRepository.save(user);
        return "redirect:/user/" + key;
    }

    /**
     * This method returns the authorization form
     */
    @RequestMapping(value = "/auth", method = GET)
    public String authForm(Model model) {
        model.addAttribute(new User());
        return "user/auth";
    }

    /**
     * Authorization process
     *
     * @param user object of a {@code User} class
     * @return jsp with html form of a user's profile with required id
     */
    @RequestMapping(value = "/auth", method = POST)
    public String enter(@Valid User user, Errors errors) {
        /* Validation */
        if (errors.hasErrors()) {
            return "user/auth";
        }

        /* Getting an user with required email and password from the db*/
        user = userRepository.readByEmailAndPass(user.getEmail(), user.getPassword());

        /* If user with such email and password exists in the db, program will redirect to the
         * profile of this user.
         * Otherwise, program will redirect to the authorization page
         * */
        return (user.getId() != null)? "redirect:/user/" + user.getId() : "redirect:/auth/";
    }

    /**
     *
     * @param file
     * @param userID
     * @return
     * @throws IOException
     */
    @RequestMapping(value= "/fileupload", method = RequestMethod.POST)
    public String processUpload(@RequestPart("profilePicture") MultipartFile file,
                                Long userID) throws IOException {

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        String profileImage = (String)uploadResult.get("url");
        userRepository.updateProfileImage(profileImage, userID);
        return "redirect:/user/" + userID;
    }
}
