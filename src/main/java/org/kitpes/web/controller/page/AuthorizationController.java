package org.kitpes.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AuthorizationController {
    @RequestMapping(value = "/auth", method = GET)
    public String showRegistrationForm() {
        return "authorizationForm";
    }
}
