package com.example.springfirstapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/rest")
public class CustomRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity getApiExample(@PathVariable String id) {
        String result = "Hi " + id;

        LOGGER.debug("result: " + result);

        return new ResponseEntity("Hi " + id, HttpStatus.OK);
    }

    @PostMapping(value = "/{pathvar}", produces = "application/json")
    public ResponseEntity postApiExample(@RequestParam String name) {
        String result = "Hello " + name;

        LOGGER.debug("result: " + result);

        return new ResponseEntity("Hello " + name, HttpStatus.OK);
    }

    @PutMapping(value = "/{pathvar}", produces = "application/json")
    public ResponseEntity putApiExample(@RequestParam String name) {
        String result = "Hello " + name;

        LOGGER.debug("result: " + result);

        return new ResponseEntity("Hello " + name, HttpStatus.OK);
    }
}
