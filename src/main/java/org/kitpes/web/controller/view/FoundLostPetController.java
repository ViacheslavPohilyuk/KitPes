package org.kitpes.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mac on 12.07.17.
 */
@Controller
@RequestMapping("/foundLostPet")
public class FoundLostPetController {
    @RequestMapping(value = "found", method = GET)
    public String foundPets() {
        return "pet/found_pet";
    }

    @RequestMapping(value = "lost", method = GET)
    public String lostPets() {
        return "pet/lost_pet";
    }

    @RequestMapping(value = "/lost/create", method = GET)
    public String createLost() {
        return "pet/registration_lost";
    }

    @RequestMapping(value = "/found/create", method = GET)
    public String createFound() {
        return "pet/registration_found";
    }
}