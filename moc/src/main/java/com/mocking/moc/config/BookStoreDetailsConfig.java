package com.mocking.moc.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mocking.moc.util.BookStoreDetails;

@Configuration
public class BookStoreDetailsConfig {

    @Value("${location.path}")
    private String location;

    @Bean
    public BookStoreDetails getBookStoreDetails() throws Exception {
        // Load the file from the classpath
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(location);
        if (inputStream == null) {
            throw new RuntimeException("File not found: " + location);
        }

        // Convert InputStream to a temporary file path if BookStoreDetails needs a file path
        String tempFilePath = createTempFileFromInputStream(inputStream, "hello.txt");       
        return BookStoreDetails.getInstance(tempFilePath);
    }

    private String createTempFileFromInputStream(InputStream inputStream, String fileName) throws IOException {
        File tempFile = File.createTempFile(fileName, null);
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        return tempFile.getAbsolutePath();
    }
}
