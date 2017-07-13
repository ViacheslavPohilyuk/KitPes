package org.kitpes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mac on 27.05.17.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    /**
     * This method returns the authorization filter
     */
    @RequestMapping(method = GET)
    public ModelAndView authForm(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }
        model.setViewName("entrance/login");
        return model;
    }
}
