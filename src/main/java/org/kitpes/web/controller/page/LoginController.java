package org.kitpes.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mac on 27.05.17.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    /**
     * This method returns the authorization form
     */
    @RequestMapping(method = GET)
    public ModelAndView authForm(@RequestParam(value = "error", required = false) String error,
                                 HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");

            //login form for update, if login error, get the targetUrl from session again.
            String targetUrl = getRememberMeTargetUrlFromSession(request);
            System.out.println(targetUrl);
            if (StringUtils.hasText(targetUrl)) {
                model.addObject("targetUrl", targetUrl);
                model.addObject("loginUpdate", true);
            }
        }

        model.setViewName("page/login");

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
}
