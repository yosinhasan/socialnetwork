package com.kindhope.web.controller;

import com.kindhope.service.GroupService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.security.acl.Group;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
@RequestMapping("/group")
@Controller
public class GroupController {
    private static final Logger LOG = Logger.getLogger(GroupController.class);

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("");

        return view;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String store(@ModelAttribute("form") Group form) {
        return "";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("");

        return view;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("");

        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("form") Group form) {
        return "";
    }

    @RequestMapping(value = "/delete/{id}")
    public String destroy(@PathVariable BigInteger id) {
        return "";
    }
}