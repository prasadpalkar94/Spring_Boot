package com.example.springfirstapp.dao;

import com.example.springfirstapp.model.AccountInfo;
import java.util.List;


public class UserDetails {
    public List getDetails(){
        
        AccountInfo acc = new AccountInfo();
        acc.setFirstname("Prasad");
        acc.setLastname("Palkar");
        acc.setEmail("explorehorizon15@gmail.com");
        return (List) acc;
    
    }
    
}
