package com.harryseong.templatemicroservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ApiV1Tests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnMemoryStats() throws Exception {
        this.mockMvc.perform(get("/api/v1/memory")).andExpect(status().isOk());
    }
}
