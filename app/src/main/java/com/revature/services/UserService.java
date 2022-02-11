package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.LoggingSingleton;

import java.util.List;


public class UserService {

    private UserDao userDao;
    //Service is what we will use to do CRUD functionality, it will be an in between link between our program and the database
    //Create post
    //Read   get
    //Update  put
    //Delete  delete
    //The service class is also where other business logic occurs

    //Constructors
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    //Methods
    public List<User> getAllEmployee(){
        return userDao.getAllEmployee();
    }

    public List<User> getAllManager(){
        return userDao.getALlManager();
    }

    public List<User> getAllMemberManager1(){
        return userDao.getAllMemberManager1();
    }

    public List<User> getAllMemberManager2(){
        return userDao.getAllMemberManager2();
    }

    public User createNewUser(String email, String firstName, String lastName, Role role, String passWord ){
        User user = new User(email,firstName,lastName,role,passWord);
        LoggingSingleton.logger.info("User: \n" + user.toString() + " was created");

        userDao.createUser(user);
        return user;
    }

    public User getUserByEmail(String email){
        return userDao.readUserByEmail(email);
    }

}
