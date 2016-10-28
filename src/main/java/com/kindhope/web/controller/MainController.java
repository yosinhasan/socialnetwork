package com.kindhope.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main controller.
 * 
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 *
 * @version 0.0.1
 *
 */
@Controller
public class MainController {
    //private static final Logger log = Logger.getLogger(MainController.class);
    @RequestMapping("/welcome.html")
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("welcome");

        return view;
    }
}
