package org.kitpes.web.rest.api;

import org.kitpes.image.ImageHandler;
import org.kitpes.model.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by mac on 14.05.17.
 */
/*
@RestController
@RequestMapping("api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private ImageHandler imageHandler;

    /* @RequestMapping(value = "filter", method = GET)
    public List<Organization> organizations(FilterOrg filter) {
        return filter.filtering(organizationRepository.readAll());
    } */
    /*

    @RequestMapping(method = GET)
    public List<Organization> organizations() {
        return organizationRepository.readAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Organization organization(@PathVariable long id) {
        return organizationRepository.readOne(id);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteId(@PathVariable long id, String username) {
        organizationRepository.deleteOne(id);
        return new ResponseEntity<>("Organization have been successfully changed", HttpStatus.OK);
    }

    @RequestMapping(method = PUT)
    @PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateId(Organization organization, String username) {
        organizationRepository.updateOne(organization);
        return new ResponseEntity<>("Organization have been successfully changed", HttpStatus.OK);
    }

    @RequestMapping(method = POST)
    @PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public ResponseEntity create(Organization organization, String username) {
        organizationRepository.save(organization);
        return new ResponseEntity<>("Organization have been successfully changed", HttpStatus.OK);
    }

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public ResponseEntity processUpload(@RequestPart("profilePicture") MultipartFile file,
                                        String username, Long organizationID) throws IOException {
        organizationRepository.updateProfileImage(imageHandler.process(file), organizationID);
        return new ResponseEntity<>("Image have been successfully added", HttpStatus.OK);
    }
}*/