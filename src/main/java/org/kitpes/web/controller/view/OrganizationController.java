package org.kitpes.web.controller.view;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.kitpes.data.contract.OrganizationRepository;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.image.ImageHandler;
import org.kitpes.model.Organization;
import org.kitpes.model.filter.FilterOrg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 14.05.17.
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {

    private OrganizationRepository organizationRepository;

    private PetRepository petRepository;

    @Autowired
    private ImageHandler imageHandler;


    @Autowired
    public OrganizationController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * Getting all organizations
     *
     * @param model adding a pet to the model
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public String organizations(Model model) {
        model.addAttribute("organizationList", organizationRepository.readAll());
        return "organization/all";
    }

    /**
     * Organizations filter by type parameter
     *
     * @param model adding a pet to the model
     * @return list of Pet objects
     */
    @RequestMapping(value = "/filter", method = GET)
    public String organizations(Model model, FilterOrg filter) {
        model.addAttribute("organizationList", filter.filtering(organizationRepository.readAll()));
        return "organization/all";
    }

    /**
     * Getting a profile of a org by id
     *
     * @param id    an id of a org
     * @param model adding a org to the model
     * @return web-page with data of an one org
     */
    @RequestMapping(value = "/{id}", method = GET)
    public String organization(@PathVariable long id,
                               Model model) {
        Organization organization = organizationRepository.readOne(id);

        /* Reading all pets from the db with an id of this organization */
        organization.setPets(petRepository.readByOrganizationID(id));

        model.addAttribute("organization", organization);
        return "organization/organization";
    }

    /**
     * Getting web-filter with data of a org that will be updated
     *
     * @param id    an id of a org
     * @param model model that will contain a Org instance
     * @return web-filter with fields which contain data of a org
     * will be updated
     */
    @RequestMapping(value = "/edit/{id}", method = GET)
    public String updatedGet(@PathVariable long id,
                             Model model) {
        Organization organization = organizationRepository.readOne(id);
        model.addAttribute(organization);
        return "organization/edit";
    }

    /**
     * Update data of a required org
     *
     * @param organization org that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    public String updateID(Organization organization) {
        organizationRepository.updateOne(organization);
        return "redirect:/organization/" + organization.getId();
    }

    /**
     * Delete a org by its id
     *
     * @param id an id of a org
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteID(@PathVariable long id,
                           @RequestParam(value = "userID", required = false) Long userID) {
        organizationRepository.deleteOne(id);

        /* If organization have been deleted from a user's profile,
         * it will redirect to a user's one
         */
        if (userID != null)
            return "redirect:/user/" + userID;

        return "redirect:/organization";
    }

    /**
     * Get web-filter with fields for put data of a new organization
     *
     * @return jsp for create a new organization
     */
    @RequestMapping(value = "/new", method = GET)
    public String registerOrganizationForm(Model model,
                                           @RequestParam(value = "userID", required = false) Long userID) {
        if (userID != null)
            model.addAttribute("userID", userID);

        return "organization/new";
    }

    /**
     * Creating new org and adding one to the db
     *
     * @param organization org instance that was created from the web-filter fields data
     * @return jsp with data of a new org
     */
    @RequestMapping(value = "/new", method = POST)
    public String create(Organization organization) {
        Long userID = organization.getUserID();

        long key = organizationRepository.save(organization);

        /* Redirection to the user's page */
        if (userID != null) {
            return "redirect:/user/" + userID;
        }

        return "redirect:/organization/" + key;
    }

    /**
     * Processing image files those user uploads on an organization's
     * profile page
     *
     * @param file           image that is an avatar of an organization
     * @param organizationID id of an organization
     * @return redirection to an organization's profile page
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public String processUpload(@RequestPart("profilePicture") MultipartFile file,
                                Long organizationID) throws IOException {
        organizationRepository.updateProfileImage(imageHandler.process(file), organizationID);
        return "redirect:/organization/" + organizationID;
    }
}