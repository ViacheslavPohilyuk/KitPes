package org.kitpes.web.controller.json.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.kitpes.config.cloud.CloudService;
import org.kitpes.data.contract.OrganizationRepository;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.model.User;
import org.kitpes.model.filter.FilterOrg;
import org.kitpes.model.Message;
import org.kitpes.model.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    //@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateID(Organization organization, String username) {
        organizationRepository.updateOne(organization);
        return new ResponseEntity<>("Organization have been successfully changed", HttpStatus.OK);
    }

    /**
     * Delete a org by its id
     *
     * @param id an id of a org
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    //@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteID(@PathVariable long id, String username) {
        organizationRepository.deleteOne(id);
        return new ResponseEntity<>("Organization have been successfully changed", HttpStatus.OK);
    }

    /**
     * Creating new org and adding one to the db
     *
     * @param organization org instance that was created from the web-filter fields data
     * @return jsp with data of a new org
     */
    @RequestMapping(value = "/new", method = POST)
    //@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public ResponseEntity create(Organization organization, String username) {
        organizationRepository.save(organization);
        return new ResponseEntity<>("Organization have been successfully changed", HttpStatus.OK);
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
    //@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public ResponseEntity processUpload(@RequestPart("profilePicture") MultipartFile file,
                                 String username, Long organizationID) throws IOException {
        Map uploadResult = ((Cloudinary) cloudService
                .getConnection())
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());
        String profileImage = (String) uploadResult.get("url");
        organizationRepository.updateProfileImage(profileImage, organizationID);

        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}