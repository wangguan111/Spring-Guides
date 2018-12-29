package com.example.validating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ValidatingApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkPersonInfoWhenNameMissingNameThenFailure() throws Exception {
        MockHttpServletRequestBuilder createPerson = post("/")
                .param("age", "20");

        mockMvc.perform(createPerson)
                .andExpect(model().hasErrors());
    }

    @Test
    public void checkPersonInfoWhenNameTooShortThenFailure() throws Exception {
        MockHttpServletRequestBuilder createPerson = post("/")
                .param("name", "R")
                .param("age", "20");

        mockMvc.perform(createPerson)
                .andExpect(model().hasErrors());
    }

    @Test
    public void checkPersonInfoWhenAgeMissingThenFailure() throws Exception {
        MockHttpServletRequestBuilder createPerson = post("/")
                .param("name", "Rob");

        mockMvc.perform(createPerson)
                .andExpect(model().hasErrors());
    }

    @Test
    public void checkPersonInfoWhenAgeTooYoungThenFailure() throws Exception {
        MockHttpServletRequestBuilder createPerson = post("/")
                .param("age", "1")
                .param("name", "Rob");

        mockMvc.perform(createPerson)
                .andExpect(model().hasErrors());
    }

    @Test
    public void checkPersonInfoWhenValidRequestThenSuccess() throws Exception {
        MockHttpServletRequestBuilder createPerson = post("/")
                .param("name", "Rob")
                .param("age", "20");

        mockMvc.perform(createPerson)
                .andExpect(model().hasNoErrors());
    }

}
