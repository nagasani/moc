package com.mocking.moc.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.mocking.moc.service.BookStoreDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class BookStoreDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookStoreDetailsService bookStoreDetailsService;

    @Test
    public void testPrintLines() throws Exception {
        // Mock the printLines method to do nothing
        doNothing().when(bookStoreDetailsService).printLines();

        // Perform the GET request and expect a 200 OK status
        mockMvc.perform(get("/bookstore/print-lines"))
               .andExpect(status().isOk());
    }
}