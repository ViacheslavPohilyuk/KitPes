package org.kitpes.web.controller.entity;

import org.kitpes.data.PetRepository;
import org.kitpes.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 14.04.17.
 */
@Controller
@RequestMapping("/pet")
public class PetController {

    private PetRepository petRepository;

    @Autowired
    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * Getting all pets
     *
     * @param model adding a pet to the model
     * @return list of Pet objects
     */
    @RequestMapping(method = GET)
    public String pets(Model model) {
        List<Pet> pets = petRepository.readAll();
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
                      Model model) {
        Pet pet = petRepository.readOne(id);

        // If can't find a pet with required id
        if(pet.getId() == null)
            return "pet/noID";

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

        // If can't find a pet with required id
        if(pet.getId() == null)
            return "pet/noID";

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
    public String updateID(Pet pet) {
        int countUpdated = petRepository.updateOne(pet);
        if (countUpdated == 0)
            return "pet/noID";
        return "redirect:/pet/" + pet.getId();
    }

    /**
     * Delete a pet by its id
     *
     * @param id an id of a pet
     */
    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteID(@PathVariable long id) {
        int countDeleted = petRepository.deleteOne(id);
        if (countDeleted == 0)
            return "pet/noID";
        return "redirect:/pet";
    }

    /**
     * Get web-form with fields for put data of a new pet
     *
     * @return jsp for create a new pet
     */
    @RequestMapping(value = "/new", method = GET)
    public String petForm() {
        return "pet/new";
    }

    /**
     * Creating new pet and adding one to the db
     *
     * @param pet pet instance that was created from the web-form fields data
     * @return jsp with data of a new pet
     */
    @RequestMapping(value = "/new", method = POST)
    public String create(Pet pet) {
        long key = petRepository.save(pet);
        return "redirect:/pet/" + key;
    }
}
