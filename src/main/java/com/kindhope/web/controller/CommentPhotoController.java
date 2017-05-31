package com.kindhope.web.controller;

import com.kindhope.entity.Comment;
import com.kindhope.service.CommentPhotoService;
import com.kindhope.service.CommentService;
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
@RequestMapping("/comment-photo")
@Controller
public class CommentPhotoController {
    private static final Logger LOG = Logger.getLogger(CommentPhotoController.class);

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentPhotoService commentPhotoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("comment/index");
        return view;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String store(@ModelAttribute("form") Comment form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "";
        }
        return "";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("comment/show");
        view.addObject("item", commentService.read(id));
        return view;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("comment/edit");
        view.addObject("item", commentService.read(id));
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("form") Comment form, BindingResult bindingResult) {
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
