package com.kindhope.mockmvc;

import com.kindhope.entity.User;
import com.kindhope.service.UserService;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Transactional
public class AuthenticationTest extends AbstractTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        User user = getUser();
        userService.create(user);
    }

    @Override
    public IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Authentication.xml"));
        return dataSet;
    }

    @Test
    public void requiresAuthentication() throws Exception {
        MockHttpServletRequestBuilder createMessage = get("/index.fy");
        mvc.perform(createMessage)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/auth/login.fy"));
    }

    @Test
    public void httpBasicAuthenticationSuccess() throws Exception {
        mvc
                .perform(get("auth/login.fy").with(httpBasic("test@test.com", "password")))
                .andExpect(authenticated().withUsername("test@test.com"));
    }

    @Test
    public void authenticationSuccess() throws Exception {
        mvc
                .perform(formLogin("/auth/login.fy").user("email", "test@test.com").password("password", "password"))
                .andExpect(redirectedUrl("/index.fy"))
                .andExpect(authenticated().withUsername("test@test.com"));
    }

    @Test
    public void authenticationFailed() throws Exception {
        MockHttpServletRequestBuilder loginForm = post("/auth/login.fy")
                .param("email", "user")
                .param("password", "invalid")
                .with(csrf());
        mvc
                .perform(loginForm)
                .andExpect(redirectedUrl("/auth/login.fy?error=true"))
                .andExpect(unauthenticated());
    }

    @Test
    public void signout() throws Exception {
        mvc
                .perform(logout("/auth/logout.fy"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/auth/login.fy?logout=true"));
    }

    @Test
    public void signup() throws Exception {
        MockHttpServletRequestBuilder userForm = post("/auth/signup.fy")
                .param("email", "user@user.com")
                .param("password", "password")
                .param("passwordConfirm", "password")
                .with(csrf());
        mvc.perform(userForm)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index.fy"));
    }

    @Test
    public void signupWithoutCSRF() throws Exception {
        MockHttpServletRequestBuilder userForm = post("/auth/signup.fy")
                .param("email", "user@user.com")
                .param("password", "password")
                .param("passwordConfirm", "password");
        mvc.perform(userForm)
                .andExpect(status().is4xxClientError())
                .andExpect(status().is(403));
    }

    @Test
    public void signupWithFormError() throws Exception {
        MockHttpServletRequestBuilder userForm = post("/auth/signup.fy")
                .param("email", "user.com")
                .param("password", "pdd")
                .param("passwordConfirm", "pssword")
                .with(csrf());
        mvc.perform(userForm)
                .andExpect(view().name("auth/signup"));
    }

    private User getUser() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("password");
        return user;
    }
}