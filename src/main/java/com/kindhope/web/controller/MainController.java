package com.kindhope.web.controller;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.dao.UserDAO;
import com.kindhope.entity.Comment;
import com.kindhope.entity.User;
import com.kindhope.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.List;

/**
 * Main controller.
 *
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@RequestMapping("/")
@Controller
public class MainController {
    private static final Logger LOG = Logger.getLogger(MainController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CommentPhotoDAO commentPhotoDAO;

    @RequestMapping("/index.fy")
    public ModelAndView index() {
        LOG.debug("ACTION: INDEX, STATUS: START");
        ModelAndView view = new ModelAndView("main/index");
        User user = userDAO.findUserWithBlacklistUsersByUserId(BigInteger.valueOf(1));
        LOG.trace("FOUND USER: " + user.getEmail());
        LOG.trace("FOUND USER BLACKLIST: " + user.getBlacklistsById());
        List<Comment> comment = commentPhotoDAO.findComments(BigInteger.ONE);
        LOG.trace("comment" + comment.get(0).getUserByUserId().getEmail());
        LOG.debug("ACTION: INDEX, STATUS: END");
        return view;
    }
}