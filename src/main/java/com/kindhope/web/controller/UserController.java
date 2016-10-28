package com.kindhope.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User controller.
 *
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 *
 * @version 0.0.1
 *
 */
@Controller
public class UserController {
    @RequestMapping({"/user/welcome.html", "/user/index.html"})
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("user/welcome");
    }

}
