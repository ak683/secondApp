package com.example.secondapp;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<String> userList;
    public List<String> getUserList(){
        userList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            this.userList.add("Человек_"+i);
        }
        return this.userList;
    }


}
