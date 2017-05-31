package com.kindhope.mockmvc;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class GroupPostTest extends AbstractTest {

    @Test
    public void redirectToLogin() throws Exception {
        mvc.perform(get("/index.fy"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/auth/login.fy"));
    }

    @WithMockUser(username = "email@email.ru", password = "123456")
    @Test
    public void index() throws Exception {
        MockHttpServletRequestBuilder createMessage = get("/index.fy");
        mvc.perform(createMessage)
                .andExpect(view().name("main/index"));

    }


}
