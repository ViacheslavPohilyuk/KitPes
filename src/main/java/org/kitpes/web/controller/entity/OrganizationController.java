package org.kitpes.web.controller.entity;

import org.kitpes.data.organization.OrganizationRepository;
import org.kitpes.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by blizardinka on 14.05.17.
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    /**
     * Getting all organizations
     *
     * @param model adding a pet to the model
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public String organzations(Model model) {
        List<Organization> organizations = organizationRepository.readAll();
        model.addAttribute("organizationList", organizations);
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
        model.addAttribute(organization);
        return "organization/organization";
    }

    /**
     * Getting web-form with data of a org that will be updated
     *
     * @param id    an id of a org
     * @param model model that will contain a Org instance
     * @return web-form with fields which contain data of a org
     * will be updated
     */
    @RequestMapping(value = "/edit/{id}", method = GET)
    public String updatedGet(@PathVariable long id,
                             Model model) {
        Organization organization= organizationRepository.readOne(id);
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
    public String updateID(Organization organization, Model model) {
        organizationRepository.updateOne(organization);
        System.out.println(organization.toString());
        return "redirect:/organization/" + organization.getId();
    }

    /**
     * Delete a org by its id
     *
     * @param id an id of a org
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteID(@PathVariable long id) {
        organizationRepository.deleteOne(id);
        return "redirect:/organization";
    }

    /**
     * Get web-form with fields for put data of a new organization
     *
     * @return jsp for create a new organization
     */
    @RequestMapping(value = "/new", method = GET)
    public String registerOrganizationForm(Model model) {
        model.addAttribute(new Organization());
        return "organization/new";
    }

    /**
     * Creating new org and adding one to the db
     *
     * @param organization org instance that was created from the web-form fields data
     * @return jsp with data of a new org
     */
    @RequestMapping(value = "/new", method = POST)
    public String create(@Valid Organization organization, Errors errors) {
        /* Validation */
        if (errors.hasErrors()) {
            return "organization/new";
        }
        long key = organizationRepository.save(organization);
        return "redirect:/organization/";
    }
}