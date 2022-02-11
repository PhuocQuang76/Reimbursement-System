package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.models.User;

public class AuthService {
    private UserDao userDao;

    //Constructor
    public AuthService(UserDao userDao){
        this.userDao = userDao;
    }

    //Methods
    public boolean loginUser(String email, String password){
        User login = userDao.readUserByEmail(email);
        if(login == null || !login.getPassWord().equals(password)){
            return false;
        }
        return true;
    }

}
