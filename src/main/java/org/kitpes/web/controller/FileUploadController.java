package org.kitpes.web.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.data.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    private Cloudinary cloudinary;
    private UserRepository userRepository;

    @Autowired
    public FileUploadController(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processUpload(@RequestPart("profilePicture") MultipartFile file,
                                Long userID) throws IOException {

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        String profileImage = (String)uploadResult.get("url");
        System.out.println("ID: " + userID + ", URL: " + profileImage);
        userRepository.updateProfileImage(profileImage, userID);
        return "redirect:/user/" + userID;
    }
}
