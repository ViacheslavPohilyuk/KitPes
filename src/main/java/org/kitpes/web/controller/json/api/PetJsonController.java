package org.kitpes.web.controller.json.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.kitpes.config.cloud.CloudService;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.model.Message;
import org.kitpes.model.Pet;

import org.kitpes.model.filter.FilterPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 14.04.17.
 */
@RestController
@RequestMapping("api/pet")
public class PetJsonController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CloudService cloudService;


    /**
     * Getting all pets
     *
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public List<Pet> pets() {
        return petRepository.readAll();
    }

    /**
     * A purpose of this method is a filtering data by
     * five fields of the {@code Pet class}: species, sex, status, organizationID and age
     *
     * @return list of Pet objects
     */
    @RequestMapping(value = "/filter", method = GET)
    public List<Pet> filter(FilterPet filterForm) {
        return filterForm.filtering(petRepository.readAll());
    }

    /**
     * Getting an one pet
     *
     * @return list of Pet objects
     */
    @RequestMapping(value = "{id}", method = GET)
    public Pet pet(@PathVariable long id) {
        return petRepository.readOne(id);
    }

    /**
     * Update data of a required pet
     *
     * @param pet pet that will be updated
     * @return message about an operation
     */
    @RequestMapping(value = "/edit", method = POST)
    //@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public Message updateID(Pet pet, String username) {
        return new Message((petRepository.updateOne(pet) != 0) ? 1 : 0);
    }

    /**
     * Delete a pet by its id
     *
     * @param id an id of a pet
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    //@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public Message deleteID(@PathVariable long id, @RequestParam(required = false) String username) {
        petRepository.deleteOne(id);
        //return new ResponseEntity<>("Информация о питомце была успешно удалена", HttpStatus.OK);
        return new Message((petRepository.deleteOne(id) != 0) ? 1 : 0);
    }

    /**
     * Creating new pet and adding one to the db
     *
     * @param pet pet instance that was created from the web-filter fields data
     * @return jsp with data of a new pet
     */
    @RequestMapping(value = "/new", method = POST)
    //@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public Message create(Pet pet, String username) {
        return new Message((petRepository.save(pet) != 0) ? 1 : 0);
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
    //@PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
    public Message processUpload(@RequestPart("profilePicture") MultipartFile file,
                                 String username, Long petID) throws IOException {
        Map uploadResult = ((Cloudinary) cloudService
                .getConnection())
                .uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap());

        String profileImage = (String) uploadResult.get("url");
        return new Message((petRepository.updateProfileImage(profileImage, petID) != 0) ? 1 : 0);
    }
}
