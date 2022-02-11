package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

import java.util.UUID;

public class AuthController {
    private AuthService authService; //loginUser() check user login is true of false
    private UserService userService; // getUserByEmail() return login user object
    private ObjectMapper mapper = new ObjectMapper();

    //Conrtructors
    public AuthController(AuthService authService, UserService userService){
        this.authService = authService;
        this.userService = userService;
    }

    //Methods
    public Handler login = (context) -> {
        LoginObject loginObject = mapper.readValue(context.body(),LoginObject.class);
        System.out.println(loginObject.email + " , " + loginObject.password);

        if(!authService.loginUser(loginObject.email,loginObject.password)){
            context.status(403);
            context.result("Username or password is incorrect.");
        }

        User user = userService.getUserByEmail(loginObject.email);

        //Let's set the session to know that the person is logged in
        context.req.getSession().setAttribute("id",""+ user.getUserId());
        context.req.getSession().setAttribute("loggedIn", user.getEmail());
        context.result(mapper.writeValueAsString(user));
        //context.header("Set-Cookie", UUID.randomUUID().toString());
    };

    public Handler verify = (context) -> {
        context.header("Access-Control-Expose_Headers", "*");
        System.out.println(context.req.getSession().getAttribute("id"));

        if(context.req.getSession().getAttribute("id") == null){
            context.status(400);
            context.result("User not logged in.");
        }else{
            context.header("userId", "" + context.req.getSession().getAttribute("id"));
            context.result("User was verified as logged in.");
        }
    };

    public Handler logout = (context) -> {
        context.req.getSession().invalidate();
        context.status(200);
        context.result("User logged out");
    };
}


class LoginObject{
    public String email;
    public String password;
}