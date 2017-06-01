package com.kindhope.web.controller;

import com.kindhope.entity.User;
import com.kindhope.service.SecurityService;
import com.kindhope.service.UserService;
import com.kindhope.web.validator.UserValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */

public class AuthControllerTest {

    @Mock
    UserService userService;

    @Mock
    SecurityService securityService;

    @Mock
    UserValidator userValidator;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Spy
    User object;

    @InjectMocks
    AuthController authController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        object = getObject();
    }

    @Test
    public void loginHasError() throws Exception {
        ModelAndView view = authController.login("error", null);
        assertNotNull(view.getModel().get("error"));
        assertNull(view.getModel().get("message"));
    }

    @Test
    public void loginHasMessage() throws Exception {
        ModelAndView view = authController.login(null, "message");
        assertNotNull(view.getModel().get("message"));
        assertNull(view.getModel().get("error"));
    }

    @Test
    public void signup() throws Exception {
        ModelAndView view = authController.signup();
        assertNotNull(view.getModel().get("userForm"));
        assertEquals(view.getViewName(), "auth/signup");
    }

    @Test
    public void registerNewUser() throws Exception {
        boolean hasError = false;
        when(bindingResult.hasErrors()).thenReturn(hasError);
        doNothing().when(userValidator).validate(object, bindingResult);
        when(userService.create(object)).thenReturn(BigInteger.ONE);
        doNothing().when(securityService).autologin(object.getEmail(), object.getPassword());
        String actual = authController.registerNewUser(object, bindingResult, model);
        verify(userValidator, atLeastOnce()).validate(object, bindingResult);
        verify(securityService, atLeastOnce()).autologin(object.getEmail(), object.getPassword());
        assertEquals("redirect:/index.fy", actual);
    }

    @Test
    public void registerNewUserHasError() throws Exception {
        boolean hasError = true;
        when(bindingResult.hasErrors()).thenReturn(hasError);
        doNothing().when(userValidator).validate(object, bindingResult);
        String actual = authController.registerNewUser(object, bindingResult, model);
        verify(userValidator, atLeastOnce()).validate(object, bindingResult);
        assertEquals("auth/signup", actual);
    }

    @Test
    public void logout() throws Exception {

    }

    public User getObject() {
        User object = new User();
        object.setName("Test");
        object.setEmail("test@test.com");
        object.setPassword("12345678");
        object.setPasswordConfirm("12345678");
        return object;
    }
}