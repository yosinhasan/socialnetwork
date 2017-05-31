package com.kindhope.web.controller;

import com.kindhope.entity.Conversation;
import com.kindhope.service.ConversationService;
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
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
@RequestMapping("/conversation")
@Controller
public class ConversationController {
    private static final Logger LOG = Logger.getLogger(ConversationController.class);

    @Autowired
    private ConversationService conversationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("conversation/index");
        return view;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String store(@ModelAttribute("form") Conversation form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "";
        }
        return "";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("conversation/show");
        view.addObject("item", conversationService.read(id));
        return view;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("conversation/edit");
        view.addObject("item", conversationService.read(id));
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("form") Conversation form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "";
        }
        return "";
    }

    @RequestMapping(value = "/delete/{id}")
    public String destroy(@PathVariable BigInteger id) {
        return "";
    }
}
