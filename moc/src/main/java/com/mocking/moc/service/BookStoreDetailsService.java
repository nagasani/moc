package com.mocking.moc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mocking.moc.util.BookStoreDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookStoreDetailsService {

    private BookStoreDetails bookStoreDetails;

    public void printLines() {
    	System.out.println(bookStoreDetails.getFileLocation());
    	try (InputStreamReader isr = new InputStreamReader(bookStoreDetails.getFis());
                BufferedReader br = new BufferedReader(isr)) {

               String line;
               while ((line = br.readLine()) != null) {
                   System.out.println(line);
               }

           } catch (IOException e) {
               e.printStackTrace();
           }
    }

}