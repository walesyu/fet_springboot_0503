package com.uuu.demo1.controllers;

import com.uuu.demo1.services.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers= RootController.class)
public class SpringTest3 {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void isNotNull() {
        assertThat(mockMvc).isNotNull();
    }
    @Test
    public void testRootDirectory() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("FET")));
    }
    @Test
    public void testHomeDirectory() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isNotFound());
    }
    @MockBean
    private GreetingService service;
    @Test
    public void serviceAndController() throws Exception {
        when(service.greet()).thenReturn("Hello FET in test script");
        mockMvc.perform(get("/greeting")).andDo(print())
                .andExpect(content().string(containsString("in test script")));
    }
}
