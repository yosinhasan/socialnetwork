package com.kindhope.web.controller;

import com.kindhope.entity.Blacklist;
import com.kindhope.entity.User;
import com.kindhope.service.BlacklistService;
import com.kindhope.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.Collection;


/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
@RequestMapping("/blacklist")
@Controller
public class BlacklistController {
    private static final Logger LOG = Logger.getLogger(BlacklistController.class);

    @Autowired
    private BlacklistService blacklistService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("blacklist/index");
        BigInteger userId = BigInteger.ONE;
//        Iterable<User> s = userService.findBlacklistUsersByUserId(userId);
//        Collection<Blacklist> list = blacklistService.readAll();
        return view;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String store(@ModelAttribute("form") Blacklist form) {
        return "";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("");
        view.addObject("item", blacklistService.read(id));
        return view;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("form") Blacklist form) {
        return "";
    }

    @RequestMapping(value = "/delete/{id}")
    public String destroy(@PathVariable BigInteger id) {
        return "";
    }
}
