package org.kitpes.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mac on 11.04.17.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = GET)
    public String home() {
        return "page/home";
    }
}
