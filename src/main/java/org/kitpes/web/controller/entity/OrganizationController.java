package org.kitpes.web.controller.entity;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.config.cloud.CloudService;
import org.kitpes.data.organization.OrganizationRepository;
import org.kitpes.data.pet.PetRepository;
import org.kitpes.model.Message;
import org.kitpes.model.Organization;
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
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private CloudService cloudService;

    /* @RequestMapping(method = GET)
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
                    orgFiltered =
                            orgFiltered.stream()
                            .filter(o -> o.getType() == numType)
                            .collect(Collectors.toList());
                }
                return orgFiltered;
            }
        }

        List<Organization> organizations = organizationRepository.readAll(); */

        /* Organizations filtering by their types */
        /*if (request.getParameter("type") != null) {
            organizations = (new OrgFilter(organizations).filtering());
        }

        model.addAttribute("organizationList", organizations);
        return "organization/all";
    }*/

    /**
     * Searching organizations by their names
     *
     * @param model adding a pet to the model
     * @return list of Pet objects
     */
    /* @RequestMapping(method = POST)
    public String organizationsSearch(ServletRequest request, Model model) {
        String searchOrg = request.getParameter("search");
        List<Organization> organizations = organizationRepository.readAll()
                .stream()
                .filter(o -> o.getName().equals(searchOrg))
                .collect(Collectors.toList());
        model.addAttribute("organizationList", organizations);
        return "organization/all";
    } */

    /**
     * Getting all organizations
     *
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public List<Organization> organizations() {
        return organizationRepository.readAll();
    }

    /**
     * Getting a profile of a org by id
     *
     * @param id an id of a org
     * @return web-page with data of an one org
     */
    @RequestMapping(value = "/{id}", method = GET)
    public Organization organization(@PathVariable long id) {
        return organizationRepository.readOne(id);
    }

    /**
     * Update data of a required org
     *
     * @param organization org that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    public int updateID(Organization organization) {
        return organizationRepository.updateOne(organization);
    }

    /**
     * Delete a org by its id
     *
     * @param id an id of a org
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    public Message deleteID(@PathVariable long id) {
        return new Message(organizationRepository.deleteOne(id));
    }

    /**
     * Creating new org and adding one to the db
     *
     * @param organization org instance that was created from the web-form fields data
     * @return jsp with data of a new org
     */
    @RequestMapping(value = "/new", method = POST)
    public Message create(Organization organization) {
        return new Message((organizationRepository.save(organization) != 0) ? 1 : 0);
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
    public Message processUpload(@RequestPart("profilePicture") MultipartFile file,
                                 Long organizationID) throws IOException {
        Map uploadResult = ((Cloudinary) cloudService
                .getConnection())
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        System.out.println("profileImage: " + profileImage + "\norganizationID: " + organizationID);
        return new Message((organizationRepository.updateProfileImage(profileImage, organizationID) != 0) ? 1 : 0);
    }
}