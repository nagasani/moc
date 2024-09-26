package com.mocking.moc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mocking.moc.service.BookStoreDetailsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bookstore")
@RequiredArgsConstructor
public class BookStoreDetailsController {

    private BookStoreDetailsService bookStoreDetailsService;

    @GetMapping("/print-lines")
    public void printLines() {
        bookStoreDetailsService.printLines();
    }
}