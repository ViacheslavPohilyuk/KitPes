package org.kitpes.web.controller;

import org.kitpes.data.contract.UserRepository;
import org.kitpes.model.Message;
import org.kitpes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 27.05.17.
 */
@Controller
public class LoginController {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method returns the authorization filter
     */
    @RequestMapping(value = "/login", method = GET)
    public ModelAndView authForm(@RequestParam(value = "error", required = false) String error,
                                 HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");

            //login filter for update, if login error, get the targetUrl from session again.
            String targetUrl = getRememberMeTargetUrlFromSession(request);
            System.out.println(targetUrl);
            if (StringUtils.hasText(targetUrl)) {
                model.addObject("targetUrl", targetUrl);
                model.addObject("loginUpdate", true);
            }
        }

        model.setViewName("/login");
        return model;
    }

    /**
     * get targetURL from session
     */
    private String getRememberMeTargetUrlFromSession(HttpServletRequest request) {
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if (session != null) {
            System.out.println("session null!!");
            targetUrl = session.getAttribute("targetUrl") == null ? ""
                    : session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }

    /**
     * Creating new user and adding one to the db
     *
     * @param user user instance that was created from the web-filter fields data
     * @return jsp with data of a new user
     */
    @RequestMapping(value = "/register", method = POST)
    public @ResponseBody Message register(@Valid User user) {
        return new Message((userRepository.save(user) != 0) ? 1 : 0);
    }
}
