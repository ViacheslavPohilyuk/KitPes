package org.kitpes.web.controller.page;

import org.kitpes.data.user.UserRepository;
import org.kitpes.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 27.05.17.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method returns the authorization form
     */
    @RequestMapping(method = GET)
    public String authForm(Model model, HttpServletRequest request) {
        String targetUrl = getRememberMeTargetUrlFromSession(request);
        System.out.println(targetUrl);
        model.addAttribute(new User());
        return "page/login";
    }

    /**
     * Authorization process
     *
     * @param user object of a {@code User} class
     * @return jsp with html form of a user's profile with required id
     */
    @RequestMapping(method = POST)
    public String enter(@Valid User user, Errors errors) {
        /* Validation */
        if (errors.hasErrors()) {
            return "page/login";
        }

        /* Getting an user with required email and password from the db*/
        user = userRepository.readByEmailAndPass(user.getEmail(), user.getPassword());

        /* If user with such email and password exists in the db, program will redirect to the
         * profile of this user.
         * Otherwise, program will redirect to the authorization page
         * */
        return (user.getId() != null)? "redirect:/user/" + user.getId() : "redirect:/auth/";
    }

    /**
     * Check if user is login by remember me cookie, refer
     * org.springframework.security.authentication.AuthenticationTrustResolverImpl
     */
    private boolean isRememberMeAuthenticated() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }

        return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
    }

    /**
     * save targetURL in session
     */
    private void setRememberMeTargetUrlToSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.setAttribute("targetUrl", "/admin/update");
        }
    }

    /**
     * get targetURL from session
     */
    private String getRememberMeTargetUrlFromSession(HttpServletRequest request){
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if(session!=null){
            targetUrl = session.getAttribute("targetUrl")==null?""
                    :session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }
}
