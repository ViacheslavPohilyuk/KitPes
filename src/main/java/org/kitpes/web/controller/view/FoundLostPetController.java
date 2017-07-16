package org.kitpes.web.controller.view;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.config.cloud.CloudService;
import org.kitpes.config.security.UserPrincipal;
import org.kitpes.data.contract.FoundLostPetRepository;
import org.kitpes.model.FoundLostPet;
import org.kitpes.model.form.DatePetLostFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 12.07.17.
 */
@Controller
@RequestMapping("/foundLostPet")
public class FoundLostPetController {
    @Autowired
    private CloudService cloudService;

    @Autowired
    private FoundLostPetRepository foundLostPetRepository;

    @RequestMapping(value = "found/{page}", method = GET)
    public String foundPets(@PathVariable int page, Model model) {
        model.addAttribute("page", page);
        return "pet/found_pet";
    }

    @RequestMapping(value = "lost", method = GET)
    public String lostPets() {
        return "pet/lost_pet";
    }

    @RequestMapping(value = "/lost/create", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String createLost() {
        return "pet/registration_lost";
    }

    @RequestMapping(value = "/found/create", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String createFound() {
        return "pet/registration_found";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/create", method = POST)
    public String create(@RequestPart(required = false, value = "profilePicture") MultipartFile file,
                         @RequestParam Boolean type,
                         FoundLostPet foundLostPet,
                         DatePetLostFound date) throws IOException {
        /* Set type (Found pet) */
        foundLostPet.setType(type);

        /* Get date of day, month and year when pet was found
         * and unite them in one string */
        foundLostPet.setDateLostFound(date.dateConstruct());

        /* Bind new pet to the current authentificated user */
        long userId = ((UserPrincipal) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()).getUser().getId();
        foundLostPet.setUserId(userId);

        /* Set profile image of a new pet */
        if (file != null) {
            Map uploadResult = ((Cloudinary) cloudService
                    .getConnection())
                    .uploader()
                    .upload(file.getBytes(), ObjectUtils.emptyMap());
            foundLostPet.setProfileImgURL((String) uploadResult.get("url"));
        }

        foundLostPetRepository.save(foundLostPet);
        return "redirect:/user/" + userId;
    }
}