package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {

    private ObjectMapper mapper = new ObjectMapper();
    private UserService userService;

    //Constructor
    public UserController(UserService userService){
        this.userService = userService;
    }


    public Handler getAllEmployee = (context) -> {
        context.result(mapper.writeValueAsString(userService.getAllEmployee()));
    };

    public Handler getAllManager = (context) -> {
        context.result(mapper.writeValueAsString(userService.getAllManager()));
    };

    public Handler getAllMemberManager1 = (context) -> {
        context.result(mapper.writeValueAsString(userService.getAllMemberManager1()));
    };

    public Handler getAllMemberManager2 = (context) -> {
        context.result(mapper.writeValueAsString(userService.getAllMemberManager2()));
    };

    public Handler createUser = (context) -> {
        User user = mapper.readValue(context.body(), User.class);

        System.out.println(user);

        userService.createNewUser(user.getEmail(),user.getFirstName(), user.getLastName(), user.getRole(), user.getPassWord());

        context.result(mapper.writeValueAsString(user));

    };
}
