package org.kitpes.web.rest.api;

import org.kitpes.data.repo.UserRepository;
import org.kitpes.image.ImageHandler;
import org.kitpes.model.Role;
import org.kitpes.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by mac on 13.05.17.
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageHandler imageHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Collection<User> users() {
        return userRepository.getAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public User user(@PathVariable long id) {
        return userRepository.get(id);
    }

    @RequestMapping(method = POST)
    public ResponseEntity register(@Valid User user, @RequestParam("second_password") String secondPassword) {
        String emailRegisteredUser = user.getUsername();
        /* List<String> usernames = userRepository.readUsernames();
        boolean isEmailDuplicated = false;
        for (String username : usernames) {
            if (emailRegisteredUser.equals(username)) {
                isEmailDuplicated = true;
            }
        } */

        //if (!isEmailDuplicated) {
        if (user.getPassword().equals(secondPassword)) {
                /* Encode password */
            //user.setPassword(passwordEncoder.encode(user.getPassword()));

                /* Set role USER to new registered user */
            user.getAuthorities().add(new Role(Role.ROLE_USER));

            userRepository.save(user);
        } else {
            return new ResponseEntity<>("Wrong password!", HttpStatus.BAD_REQUEST);
        }
        //else {
        //  return new ResponseEntity<>("User with this email already registered!", HttpStatus.NOT_ACCEPTABLE);
        //}
        return new ResponseEntity<>("New User have been successfully registered!", HttpStatus.OK);
    }

    @RequestMapping(method = PUT)
    @PreAuthorize("#user.id == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateId(User user) {
        userRepository.update(user);
        return new ResponseEntity<>("User have been successfully changed", HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteId(@PathVariable long id) {
        userRepository.delete(id);
        return new ResponseEntity<>("User have been successfully deleted", HttpStatus.OK);

    }

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @PreAuthorize("#userId == authentication.principal.user.id or hasRole('ROLE_ADMIN')")
    public ResponseEntity processUpload(@RequestPart("profilePicture") MultipartFile file,
                                        long userId) throws IOException {

        userRepository.updateImage(imageHandler.process(file), userId);
        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}
