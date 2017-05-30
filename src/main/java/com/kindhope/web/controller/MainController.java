package com.kindhope.web.controller;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.dao.UserDAO;
import com.kindhope.entity.Comment;
import com.kindhope.entity.User;
import com.kindhope.service.SecurityService;
import com.kindhope.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.List;

/**
 * Main controller.
 *
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@RequestMapping("/")
@Controller
public class MainController {
    private static final Logger LOG = Logger.getLogger(MainController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;

    @RequestMapping("/index.fy")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("main/index");
        String email = securityService.findLoggedInUserEmail();
        LOG.trace("EMAIL : " + email);
        return view;
    }
}