package com.kindhope.web.controller;

import com.kindhope.dao.UserDAO;
import com.kindhope.dao.impl.HibernateUserDAO;
import com.kindhope.entity.UsersEntity;
import com.kindhope.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.ArrayList;

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
    @Autowired
    UserService userService;
    //private static final Logger log = Logger.getLogger(MainController.class);
    @RequestMapping("/welcome.html")
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("welcome");
        UsersEntity user = userService.read(BigInteger.ONE);
        view.addObject("user", user);
        return view;
    }
}
