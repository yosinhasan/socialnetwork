package com.kindhope.web.controller;

import com.kindhope.entity.User;
import com.kindhope.service.SecurityService;
import com.kindhope.service.UserService;
import com.kindhope.web.validator.UserValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */

@RequestMapping("/auth")
@Controller
public class AuthController {
    private static final Logger LOG = Logger.getLogger(AuthController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/login.fy", method = RequestMethod.GET)
    public ModelAndView login(String error, String logout) {
        ModelAndView view = new ModelAndView("auth/login");
        if (error != null) {
            LOG.error("ERROR OCCURED");
            view.addObject("error", "Your username and password is invalid.");
        }
        if (logout != null) {
            LOG.trace("USER LOGGED OUT");
            view.addObject("message", "You have been logged out successfully.");
        }
        return view;
    }

    @RequestMapping(value = "/signup.fy", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView view = new ModelAndView("auth/signup");
        view.addObject("userForm", new User());
        return view;
    }

    @RequestMapping(value = "/signup.fy", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) throws IOException {
        LOG.trace("User to register => " + user);
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            LOG.error("USER FORM FAILED VALIDATION");
            LOG.error("REDIRECT TO SIGN UP FORM");
            return "auth/signup";
        }
        String password = user.getPassword();
        userService.create(user);
        securityService.autologin(user.getEmail(), password);
        return "redirect:/index.fy";
    }

    @RequestMapping(value = "/logout.fy", method = {RequestMethod.POST})
    public void logout() {
    }


}
