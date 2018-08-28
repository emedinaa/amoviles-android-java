package com.emedinaa.java;

import com.emedinaa.java.entity.User;

public class Main2 {

    public static void main(String args[]){
        User user= new User();
        User user1= new User(1);
        User user2=
                new User(100,"Eduardo","Medina");

        System.out.println("user " +user);
        System.out.println("user1 " +user1);
        System.out.println("user2 " +user2);


    }
}
