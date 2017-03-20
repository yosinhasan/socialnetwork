package com.kindhope.web.controller;

import com.kindhope.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User controller.
 *
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@RequestMapping("user")
@Controller
public class UserController {
    private static final Logger LOG = Logger.getLogger(MainController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"index.html"}, method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("user/welcome");
    }

}
