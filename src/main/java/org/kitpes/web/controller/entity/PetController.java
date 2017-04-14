package org.kitpes.web.controller.entity;

import org.kitpes.entity.Pet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mac on 14.04.17.
 */
@RestController
public class PetController {
    @RequestMapping(name = "/pet/get", method = GET)
    public List<Pet> getAll() {
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(
                1L,
                "Katy",
                "cat",
                "health",
                "cute white cat",
                "CatsDogs",
                3,
                "w",
                true,
                false));

        pets.add(new Pet(
                2L,
                "Sharik",
                "dog",
                "health",
                "it's a dog!",
                "CatsDogs",
                11,
                "m",
                true,
                true));

        pets.add(new Pet(
                3L,
                "Pushistik",
                "cat",
                "health",
                "it's a cat!",
                "CatsDogs",
                2,
                "m",
                true,
                false));
        return pets;
    }
}
