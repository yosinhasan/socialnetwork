package com.kindhope.web.controller;

import com.kindhope.entity.User;
import com.kindhope.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;

/**
 * User controller.
 *
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@RequestMapping("user")
@Controller
public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("user/index");

        return view;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("user/show");
        view.addObject("item", userService.read(id));
        return view;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("user/edit");
        view.addObject("item", userService.read(id));
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("form") User form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/update/" + form.getId();
        }
        userService.update(form);
        return "redirect:/user";
    }

    @RequestMapping(value = "/delete/{id}")
    public String destroy(@PathVariable BigInteger id) {
        return "redirect:/user";

    }
}
