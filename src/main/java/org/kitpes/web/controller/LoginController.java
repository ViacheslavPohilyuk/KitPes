package org.kitpes.web.controller;

import org.kitpes.data.contract.UserRepository;
import org.kitpes.model.Message;
import org.kitpes.model.Role;
import org.kitpes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 27.05.17.
 */
@Controller
public class LoginController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * This method returns the authorization filter
     */
    @RequestMapping(value = "/login", method = GET)
    public ModelAndView authForm(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }
        model.setViewName("/login");
        return model;
    }

    /**
     * Creating new user and adding one to the db
     */
    @RequestMapping(value = "/register", method = POST)
    public @ResponseBody
    ResponseEntity register(@Valid User user) {
        /* Encode password */
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        /* Set role USER to new registered user */
        user.getAuthorities().add(new Role(Role.ROLE_USER));

        userRepository.save(user);
        return new ResponseEntity<>("User have been successfully registered", HttpStatus.OK);
    }
}
