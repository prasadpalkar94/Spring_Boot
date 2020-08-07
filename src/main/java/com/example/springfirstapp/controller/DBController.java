package com.example.springfirstapp.controller;

import com.example.springfirstapp.dao.AccountDAO;
import com.example.springfirstapp.model.AccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pooja
 */
@RestController
@RequestMapping("/db")
public class DBController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBController.class);

    @Autowired
    AccountDAO dao;

    @PostMapping(produces = "application/json")
    public ResponseEntity postApiExample(@RequestParam String name) {
        String result = "Hello " + name;

        LOGGER.debug("result: " + result);

        AccountInfo info = new AccountInfo("fname", "lname", "abc@gmail.com");
        dao.create(info);
        //dao.delete(info);

        return new ResponseEntity("Hello " + name, HttpStatus.OK);
    }
}
