package com.kindhope.web.controller;

import com.kindhope.entity.Post;
import com.kindhope.service.PostService;
import com.kindhope.web.validator.PostValidator;
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
@RequestMapping("/post")
@Controller
public class PostController {
    private static final Logger LOG = Logger.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private PostValidator postValidator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("post/index");
        return view;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String store(@ModelAttribute("form") Post form, BindingResult bindingResult) {
        postValidator.validate(form, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/post";
        }
        postService.create(form);
        return "redirect:/post";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("post/show");
        postService.read(id);
        return view;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable BigInteger id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("post/edit");
        view.addObject("item", postService.read(id));
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("form") Post form, BindingResult bindingResult) {
        postValidator.validate(form, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/post";
        }
        return "redirect:/post";
    }

    @RequestMapping(value = "/delete/{id}")
    public String destroy(@PathVariable BigInteger id) {
        return "redirect:/post";
    }
}
