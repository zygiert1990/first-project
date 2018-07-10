package com.project.Controllers;

import com.project.POJOClasses.Address;
import com.project.Services.AddressService;
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private AddressService addressService;

    @Before
    public void setup() throws Exception{
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void test(){
        ServletContext servletContext = webApplicationContext.getServletContext();
        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(webApplicationContext.getBean("addressController"));
    }

    @Test
    public void shouldSaveAddress() throws Exception{
        Address address = new Address("lublin");

        given(addressService.addAddress(address)).willReturn(address);

        mockMvc.perform(put("/addresses/add/{city}", "lublin"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFindAddressByCity() throws Exception{
        final String city = "Lublin";

        Address address = new Address(city);

        given(addressService.findByCity(city)).willReturn(address);

        mockMvc.perform(get("/addresses/show/{city}", city))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.city").value(city))
                .andExpect(jsonPath("$").value(address))
                .andReturn();
    }

/*    @Test
    public void shouldSaveWholeAddress() throws Exception{
        Address address = new Address(
                AddressType.HOME,
                "Lublin",
                "21-100",
                "Wilenska",
                "25a"
        );
        String body = (new ObjectMapper().valueToTree(address)).toString();

        given(addressService.addAddress(address)).willReturn(address);

        mockMvc.perform(post("/addresses/save"))
                .
    }*/

}