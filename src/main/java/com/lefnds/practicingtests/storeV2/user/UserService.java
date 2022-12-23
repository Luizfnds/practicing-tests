package com.lefnds.practicingtests.storeV2.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private String id;
    private Integer idade;

    public boolean isMinor(String id){
        return true;
    }
}
