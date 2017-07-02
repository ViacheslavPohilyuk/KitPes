package org.kitpes.web.controller;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mac on 11.04.17.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = GET)
    public String home() {
        LocalDateTime localDateTime = new LocalDateTime();

        String dateAdded;
        String ldt = new LocalDateTime().toString();
        int indexT = ldt.indexOf('T');
        dateAdded = ldt.substring(0, indexT) + " " + ldt.substring(indexT + 1, ldt.lastIndexOf(':'));
        System.out.println("dateAdded: " + dateAdded);
        System.out.println("localDateTime: " + localDateTime.toString());
        return "home";
    }
}
