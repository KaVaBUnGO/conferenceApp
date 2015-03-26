package com.conference.web.rest;

import com.conference.ConferenceApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = ConferenceApplication.class)
public class ScheduleControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void testGetSchedule() throws Exception {

        this.mockMvc.perform(get("/rest/schedule")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].presentationName", is("Presentation 1")))
                .andExpect(jsonPath("$[0].roomName", is("Yellow room")))
                .andExpect(jsonPath("$[0].authors[0]", is("user")))
                .andExpect(jsonPath("$[1].presentationName", is("Presentation 2")))
                .andExpect(jsonPath("$[1].roomName", is("Yellow room")))
                .andExpect(jsonPath("$[1].authors[0]", is("user")))
                .andExpect(jsonPath("$[1].authors[1]", is("presenter")))
                .andExpect(jsonPath("$[2].presentationName", is("Presentation 3")))
                .andExpect(jsonPath("$[2].roomName", is("Red room")))
                .andExpect(jsonPath("$[2].authors[0]", is("user")));
    }
}