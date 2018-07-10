package com.project.Controllers;

import com.project.POJOClasses.User;
import com.project.Services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@WebMvcTest(UserController.class)
public class UserControllerTest {

    public static final String FIRST_NAME = "michal";
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Before
    public void setup() throws Exception{
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesUserController(){
        ServletContext servletContext = webApplicationContext.getServletContext();
        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(webApplicationContext.getBean("userController"));
    }

    @Test
    public void shouldFindOneUser() throws Exception{
        User user = new User(FIRST_NAME, "zyga");

        given(userService.findByFirstName(FIRST_NAME)).willReturn(user);

        mockMvc.perform(get("/users/show/{firstName}", "michal"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    public void shouldFindAllUser() throws Exception{
        User user = new User("michal" ,"zyga");

        List<User> userList = Collections.singletonList(user);

        given(userService.findAllUsers()).willReturn(userList);

        mockMvc.perform(get("/users/show/allUsers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$[0].firstName").isString())
                .andExpect(jsonPath("$[0].birthDate").isEmpty());
        }

//        @Test
//    public void sh
//
}