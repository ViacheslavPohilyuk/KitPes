package org.kitpes.web.controller.entity;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.config.cloud.CloudService;
import org.kitpes.data.organization.OrganizationRepository;
import org.kitpes.data.pet.PetRepository;
import org.kitpes.entity.Organization;
import org.kitpes.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by blizardinka on 14.05.17.
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {

    private OrganizationRepository organizationRepository;

    private PetRepository petRepository;

    private CloudService cloudService;

    @Autowired
    public OrganizationController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Autowired
    public void setCloudService(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    /**
     * Getting all organizations
     *
     * @param model adding a pet to the model
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public String organizations(ServletRequest request, Model model) {
        class OrgFilter {
            private List<Organization> orgFiltered;

            private OrgFilter(List<Organization> orgs) {
                this.orgFiltered = orgs;
            }

            private List<Organization> filtering() {
                String type = request.getParameter("type");
                if (!type.equals("type")) {
                    int numType = Integer.parseInt(type);
                    orgFiltered = orgFiltered.stream().filter(o -> o.getType() == numType)
                            .collect(Collectors.toList());
                }
                return orgFiltered;
            }
        }

        List<Organization> organizations = organizationRepository.readAll();

        /* Organizations filtering by their types */
        if (request.getParameter("type") != null) {
            organizations = (new OrgFilter(organizations).filtering());
        }

        model.addAttribute("organizationList", organizations);
        return "organization/all";
    }

    /**
     * Searching organizations by their names
     *
     * @param model adding a pet to the model
     * @return list of Pet objects
     */
    @RequestMapping(method = POST)
    public String organizationsSearch(ServletRequest request, Model model) {
        String searchOrg = request.getParameter("search");
        List<Organization> organizations = organizationRepository.readAll()
                .stream()
                .filter(o -> o.getName().equals(searchOrg))
                .collect(Collectors.toList());
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

        /* Reading all pets from the db with an id of this organization */
        organization.setPets(petRepository.readByOrganizationID(id));

        /* Resolving a name of an organization's type */
        String[] orgTypes = {"Ветклиника", "Приют"};
        model.addAttribute("type", orgTypes[organization.getType()]);

        model.addAttribute("organization", organization);
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
    public String updateID(Organization organization, Model model) {
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
     * Get web-form with fields for put data of a new organization
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
     * @param organization org instance that was created from the web-form fields data
     * @return jsp with data of a new org
     */
    @RequestMapping(value = "/new", method = POST)
    public String create(ServletRequest request, Organization organization) {
        Long userID = organization.getUserID();

        /* Setting the type of an organization */
        String type = request.getParameter("type");
        System.out.println(type);
        if (!type.equals("type"))
            organization.setType(Integer.parseInt(type));

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
        Map uploadResult = ((Cloudinary) cloudService
                .getConnection())
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        System.out.println("profileImage: " + profileImage + "\norganizationID: " + organizationID);
        organizationRepository.updateProfileImage(profileImage, organizationID);
        return "redirect:/organization/" + organizationID;
    }
}