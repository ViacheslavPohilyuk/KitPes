package org.kitpes.web.controller;

import org.kitpes.data.contract.UserRepository;
import org.kitpes.model.Role;
import org.kitpes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import java.util.List;

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
    public String register(@Valid User user, @RequestParam("second_password") String secondPassword) {
        String emailRegisteredUser = user.getUsername();
        List<String> usernames = userRepository.readUsernames();
        boolean isEmailDuplicated = false;
        for (String username : usernames) {
            if(emailRegisteredUser.equals(username)) {
                isEmailDuplicated = true;
            }
        }

        if(!isEmailDuplicated) {
            if (user.getPassword().equals(secondPassword)) {
                /* Encode password */
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                /* Set role USER to new registered user */
                user.getAuthorities().add(new Role(Role.ROLE_USER));

                userRepository.save(user);
            } else {
                return "redirect:/register?passwordError";
            }
        }
        else {
            return "redirect:/register?emailDuplicateError";
        }

        return "/entrance/login";
    }
}
