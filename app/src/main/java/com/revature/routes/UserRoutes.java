package com.revature.routes;

import com.revature.controllers.UserController;
import io.javalin.Javalin;

public class UserRoutes extends Route{
    private UserController userController;

    public UserRoutes(UserController userController){
        this.userController = userController;
    }

    @Override
    public void registerLocalRoutes(Javalin app){
        app.post("/user", userController.createUser);
        app.get("/employee", userController.getAllEmployee);
        app.get("/manager", userController.getAllManager);
        app.get("/manager/1", userController.getAllMemberManager1);
        app.get("/manager/2", userController.getAllMemberManager2);

    }

}
