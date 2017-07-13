package org.kitpes.web.controller;

import org.kitpes.data.contract.UserRepository;
import org.kitpes.model.Role;
import org.kitpes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 13.07.17.
 */
@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = GET)
    String registerForm() {
        return "/entrance/registration";
    }

    /**
     * Creating new user and adding one to the db
     */
    @RequestMapping(value = "/register", method = POST)
    public @ResponseBody ResponseEntity register(@Valid User user) {
        /* Encode password */
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        /* Set role USER to new registered user */
        user.getAuthorities().add(new Role(Role.ROLE_USER));

        userRepository.save(user);
        return new ResponseEntity<>("User have been successfully registered", HttpStatus.OK);
    }
}
