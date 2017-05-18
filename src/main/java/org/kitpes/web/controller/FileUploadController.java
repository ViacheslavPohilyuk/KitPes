package org.kitpes.web.controller;

import org.kitpes.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
  
  @RequestMapping(method=RequestMethod.POST)
  public String processUpload(@RequestPart("profilePicture") MultipartFile file, Long userID) {

    System.out.println("---->  " + file.getName() + "  ::  "  + file.getSize());
    
    return "redirect:/user/" + userID;
  }
  
}
