package org.kitpes.web.rest.api;

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