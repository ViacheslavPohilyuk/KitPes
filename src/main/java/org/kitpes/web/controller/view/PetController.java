package org.kitpes.web.controller.view;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.config.cloud.CloudService;
import org.kitpes.config.security.UserPrincipal;
import org.kitpes.data.contract.OrganizationRepository;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.model.Pet;

import org.kitpes.model.filter.FilterPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 14.04.17.
 */
@Controller
@RequestMapping("/pet")
public class PetController {
    private OrganizationRepository organizationRepository;

    private PetRepository petRepository;

    private CloudService cloudService;

    @Autowired
    public PetController(PetRepository petRepository) {
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
     * A purpose of this method is a filtering data by
     * five fields of the {@code Pet class}: species, sex, status, organizationID and age
     *
     * @return list of Pet objects
     */
    @RequestMapping(value = "/filter", method = GET)
    public String filter(FilterPet filterForm, Model model) {
        List<Pet> pets = filterForm.filtering(petRepository.readAll());
        model.addAttribute("petList", pets);
        return "pet/all";
    }

    /**
     * Getting all pets
     *
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public String pets(Model model) {
        List<Pet> pets = petRepository.readAll();
        model.addAttribute("petList", pets);
        model.addAttribute("orgs", organizationRepository.readAll());
        return "pet/all";
    }

    /**
     * Getting a profile of a pet by id
     *
     * @param id an id of a pet
     * @return web-page with data of an one pet
     */
    @RequestMapping(value = "/{id}", method = GET)
    public String pet(@PathVariable long id, Model model) {
        Pet pet = petRepository.readOne(id);
        model.addAttribute(pet);
        return "pet/pet_profile";
    }

    /**
     * Getting web-filter with data of a pet that will be updated
     *
     * @param id    an id of a pet
     * @param model model that will contain a Pet instance
     * @return web-filter with fields which contain data of a pet
     * will be updated
     */
    @RequestMapping(value = "/edit/{id}", method = GET)
    public String updatedGet(@PathVariable long id,
                             Model model) {
        Pet pet = petRepository.readOne(id);
        model.addAttribute(pet);
        return "pet/edit";
    }

    /**
     * Update data of a required pet
     *
     * @param pet pet that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    public String updateID(ServletRequest request, Pet pet) {
        String status = request.getParameter("status");
        if (!status.equals("status"))
            pet.setStatus(status);

        System.out.println(pet.toString());

        petRepository.updateOne(pet);
        return "redirect:/pet/" + pet.getId();
    }

    /**
     * Delete a pet by its id
     *
     * @param id an id of a pet
     */
    /* @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteID(@PathVariable long id,
                           @RequestParam(value = "userID", required = false) Long userID,
                           @RequestParam(value = "organizationID", required = false) Long organizationID) {
        petRepository.deleteOne(id);

        /* If pet have been deleted from a user's/org's profile,
         * it will redirect to a user's/org's one
         */
        /*if (userID != null)
            return "redirect:/user/" + userID;
        if (organizationID != null)
            return "redirect:/organization/" + organizationID;

        return "redirect:/pet";
    } */

    /**
     * Form for pet registration
     *
     * @return jsp for create a new pet
     */
    @RequestMapping(value = "/new", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String createForm() {
        return "pet/registration_adopt_pet";
    }

    /**
     * Creating new pet and adding one to the db
     *
     * @param pet pet instance that was created from the web-filter fields data
     * @return jsp with data of a new pet
     */
    @RequestMapping(value = "/new", method = POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String create(@RequestPart(required = false, value = "profilePicture") MultipartFile file,
                         Pet pet) throws IOException {

        /* Bind new pet to the current authentificated user */
        long userId = ((UserPrincipal) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()).getUser().getId();
        pet.setUserID(userId);

        /* Set profile image of a new pet */
        if (file != null) {
            Map uploadResult = ((Cloudinary) cloudService
                    .getConnection())
                    .uploader()
                    .upload(file.getBytes(), ObjectUtils.emptyMap());
            pet.setProfileImgURL((String) uploadResult.get("url"));
        }

        petRepository.save(pet);
        return "redirect:/user/" + userId;
    }

    /**
     * Processing image files those user uploads on an pet's
     * profile page
     *
     * @param file  image that is an avatar of an pet
     * @param petID id of an pet
     * @return redirection to an pet's profile page
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public String processUpload(@RequestPart("profilePicture") MultipartFile file,
                              Long petID) throws IOException {
        Map uploadResult = ((Cloudinary) cloudService
                .getConnection())
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        petRepository.updateProfileImage(profileImage, petID);
        return "redirect:/pet/" + petID;
    }
}
