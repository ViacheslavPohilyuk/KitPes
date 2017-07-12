package org.kitpes.web.controller;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.kitpes.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mac on 11.04.17.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = GET)
    public String home() {
        return "main";
    }
}
