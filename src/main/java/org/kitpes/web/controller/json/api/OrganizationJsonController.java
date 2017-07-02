package org.kitpes.web.controller.json.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.config.cloud.CloudService;
import org.kitpes.data.contract.OrganizationRepository;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.model.filter.FilterOrg;
import org.kitpes.model.Message;
import org.kitpes.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 14.05.17.
 */
@RestController
@RequestMapping("api/organization")
public class OrganizationJsonController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CloudService cloudService;


    @RequestMapping(value = "filter", method = GET)
    public List<Organization> organizations(FilterOrg filter) {
        return filter.filtering(organizationRepository.readAll());
    }

    /**
     * Getting all organizations
     *
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public List<Organization> organizations() {
        List<Organization> orgs = organizationRepository.readAll();
        for (Organization org : orgs)
            org.setPets(petRepository.readByOrganizationID(org.getId()));
        return orgs;
    }

    /**
     * Getting a profile of a org by id
     *
     * @param id an id of a org
     * @return web-page with data of an one org
     */
    @RequestMapping(value = "/{id}", method = GET)
    public Organization organization(@PathVariable long id) {
        Organization org = organizationRepository.readOne(id);
        org.setPets(petRepository.readByOrganizationID(id));
        return org;
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
     * @param organization org instance that was created from the web-filter fields data
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