package com.kindhope.web.controller;

import com.kindhope.entity.User;
import com.kindhope.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

/**
 * Main controller.
 *
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Controller
public class MainController {
    private static final Logger LOG = Logger.getLogger(MainController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/index.fy")
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
        LOG.debug("ACTION: INDEX, STATUS: START");
        ModelAndView view = new ModelAndView("main/index");
        User user = userService.read(BigInteger.valueOf(2L));
        LOG.info("=========================USER INFO BEFORE UPDATE:" + user.getName());
        user.setName("name 1");
        userService.update(user);
        User user2 = userService.read(BigInteger.valueOf(2L));
        LOG.info("=========================USER INFO AFTER UPDATE:" + user2.getName());
//        view.addObject("user", user2); ${user.getName()};
        LOG.debug("ACTION: INDEX, STATUS: END");
        return view;
    }
}