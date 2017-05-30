package com.kindhope.web.controller;

import com.kindhope.entity.Blacklist;
import com.kindhope.service.BlacklistService;
import com.kindhope.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;


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
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addNew() {
        return "blacklist/new";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String store(@ModelAttribute("form") Blacklist form, BindingResult bindingResult) {
        LOG.trace("FORM: " + form);
        //validator
        if (bindingResult.hasErrors()) {
            LOG.error("FORM VALIDATION FAILED");
            LOG.error("REDIRECT TO BLACKLIST EDIT PAGE");
            return "blacklist/new";
        }
        blacklistService.create(form);
        return "redirect:/blacklist";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("blacklist/show");
        view.addObject("item", blacklistService.read(id));
        return view;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.addObject("item", blacklistService.read(id));
        view.setViewName("blacklist/edit");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("form") Blacklist form, BindingResult bindingResult) {
        LOG.trace("FORM: " + form);
        //validator
        if (bindingResult.hasErrors()) {
            LOG.error("FORM VALIDATION FAILED");
            LOG.error("REDIRECT TO BLACKLIST EDIT PAGE");
            return "blacklist/edit";
        }
        blacklistService.create(form);
        return "redirect:/blacklist";
    }

    @RequestMapping(value = "/delete/{id}")
    public String destroy(@PathVariable BigInteger id) {

        return "";
    }
}
