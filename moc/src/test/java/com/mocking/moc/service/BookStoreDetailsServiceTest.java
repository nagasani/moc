package com.mocking.moc.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mocking.moc.util.BookStoreDetails;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookStoreDetailsServiceTest {

    @InjectMocks
    private BookStoreDetailsService bookStoreDetailsService;

    @Mock
    private BookStoreDetails bookStoreDetails;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPrintLines() throws IOException {
        // Mock the getFileLocation method
        when(bookStoreDetails.getFileLocation()).thenReturn("mock-file-location");

        // Mock the getFis method to return a ByteArrayInputStream
        String mockFileContent = "Line 1\nLine 2\nLine 3";
        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(mockFileContent.getBytes());
        when(bookStoreDetails.getFis()).thenReturn(mockInputStream);

        // Capture the output
        bookStoreDetailsService.printLines();

        // Verify that getFileLocation and getFis were called
        verify(bookStoreDetails, times(1)).getFileLocation();
        verify(bookStoreDetails, times(1)).getFis();
    }
}