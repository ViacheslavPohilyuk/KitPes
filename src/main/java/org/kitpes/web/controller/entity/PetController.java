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
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 14.04.17.
 */
@Controller
@RequestMapping("/pet")
public class PetController {

    private PetRepository petRepository;

    private OrganizationRepository organizationRepository;

    private CloudService cloudService;

    @Autowired
    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Autowired
    public void setCloudService(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    @Autowired
    public void setOrganizationRepository(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    /**
     * Getting all pets
     *
     * @param model adding a pet to the model
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public String pets(ServletRequest request, Model model) {

        /** A purpose of the local {@code class PetFilter} is a filtering data by
         *  five fields of the {@code Pet class}: species, sex, status, organizationID and age
         */
        class PetFilter {
            private List<Pet> petFiltered;

            private PetFilter(List<Pet> pets) {
                this.petFiltered = pets;
            }


            /**
             * Filtering a list of Pet objects by five characteristics:
             * species, sex, status of health, id of pet's organization and age
             *
             * @return a filtered list
             */
            private List<Pet> filtering() {
                String species = request.getParameter("species");
                ParameterFiltering(species, "species", p -> p.getAnimal().equals(species));

                String sex = request.getParameter("sex");
                ParameterFiltering(sex, "sex", p -> p.getSex().equals(sex));

                String status = request.getParameter("status");
                ParameterFiltering(status, "status", p -> p.getStatus().equals(status));

                String org = request.getParameter("org");
                ParameterFiltering(org, "org", p -> p.getOrganizationID().equals(Long.parseLong(org)));

                String age = request.getParameter("age");
                if (!age.equals("age")) {
                    int numAge = Integer.parseInt(age);
                    ParameterFiltering(age, "age",
                            p -> (p.getAge() > 5) || (p.getAge() >= numAge && p.getAge() <= (numAge + 1)));
                }
                return petFiltered;
            }

            /**
             * Retrieving a list elements of one are matched specific criteria
             * from the list {@code petFiltered}
             *
             * @param parameter parameter from the html-tag <select>
             * @param paramName a name of this parameter
             * @param criteria a criteria for retrieving elements from the list
             */
            private void ParameterFiltering(String parameter, String paramName, Predicate<Pet> criteria) {
                if (!parameter.equals(paramName))
                    this.petFiltered = petFiltered.stream()
                            .filter(criteria)
                            .collect(Collectors.toList());
            }
        }

        List<Pet> pets = petRepository.readAll();

        /* Pets filtering */
        if (request.getParameter("species") != null) {
            pets = (new PetFilter(pets).filtering());
        }

        /* Getting all the organizations, which names and ids
         * will be putted to html-tag <select>
         */
        List<Organization> orgs = organizationRepository.readAll();
        model.addAttribute("orgs", orgs);

        model.addAttribute("petList", pets);
        return "pet/all";
    }

    /**
     * Getting a profile of a pet by id
     *
     * @param id    an id of a pet
     * @param model adding a pet to the model
     * @return web-page with data of an one pet
     */
    @RequestMapping(value = "/{id}", method = GET)
    public String pet(@PathVariable long id,
                      Model model,
                      @RequestParam(value = "userID", required = false) Long userID,
                      @RequestParam(value = "organizationID", required = false) Long organizationID,
                      @RequestParam(value = "userOrgID", required = false) Long userOrgID) {
        model = addIDsToModel(model, userID, organizationID, userOrgID);

        Pet pet = petRepository.readOne(id);
        model.addAttribute(pet);

        return "pet/pet";
    }

    /**
     * Getting web-form with data of a pet that will be updated
     *
     * @param id    an id of a pet
     * @param model model that will contain a Pet instance
     * @return web-form with fields which contain data of a pet
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
    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteID(@PathVariable long id,
                           @RequestParam(value = "userID", required = false) Long userID,
                           @RequestParam(value = "organizationID", required = false) Long organizationID) {
        petRepository.deleteOne(id);

        /* If pet have been deleted from a user's/org's profile,
         * it will redirect to a user's/org's one
         */
        if (userID != null)
            return "redirect:/user/" + userID;
        if (organizationID != null)
            return "redirect:/organization/" + organizationID;

        return "redirect:/pet";
    }

    /**
     * Get web-form with fields for put data of a new pet
     *
     * @return jsp for create a new pet
     */
    @RequestMapping(value = "/new", method = GET)
    public String petForm(Model model,
                          @RequestParam(value = "userID", required = false) Long userID,
                          @RequestParam(value = "organizationID", required = false) Long organizationID,
                          @RequestParam(value = "userOrgID", required = false) Long userOrgID) {

        model = addIDsToModel(model, userID, organizationID, userOrgID);
        return "pet/new";
    }

    /**
     * Creating new pet and adding one to the db
     *
     * @param pet pet instance that was created from the web-form fields data
     * @return jsp with data of a new pet
     */
    @RequestMapping(value = "/new", method = POST)
    public String create(ServletRequest request, Pet pet) {
        Long userID = pet.getUserID();
        Long organizationID = pet.getOrganizationID();

        System.out.println(pet.toString());
        long key = petRepository.save(pet);

        /* Getting data about pet's health status and
         * its sex from <select> html-tag */
        String status = request.getParameter("status");
        if (!status.equals("status"))
            pet.setStatus(status);
        String sex = request.getParameter("sex");
        if (!status.equals("sex"))
            pet.setSex(sex);
        System.out.println(pet.toString());

        /* Redirection to an user's or organization's page */
        if (userID != null) {
            return "redirect:/user/" + userID;
        } else if (organizationID != null) {
            return "redirect:/organization/" + organizationID;
        }

        return "redirect:/pet/" + key;
    }

    private Model addIDsToModel(Model model, Long userID, Long organizationID, Long userOrgID) {
        if (userID != null)
            model.addAttribute("userID", userID);
        else if (organizationID != null) {
            model.addAttribute("organizationID", organizationID);
            model.addAttribute("userOrgID", userOrgID);
        }
        return model;
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
        System.out.println("profileImage: " + profileImage + "\npetID: " + petID);
        petRepository.updateProfileImage(profileImage, petID);
        return "redirect:/pet/" + petID;
    }
}
