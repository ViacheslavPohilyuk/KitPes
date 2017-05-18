package org.kitpes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.POST)
    public String processUpload(@RequestPart("profilePicture") MultipartFile file,
                                Long userID) throws IOException {

        System.out.println("---->  " + file.getName() + "  ::  " + file.getSize() + " " + file.getOriginalFilename() + " " + file.getContentType());

        file.transferTo(new File(userID + ".png"));
        return "redirect:/user/" + userID;
    }
}
