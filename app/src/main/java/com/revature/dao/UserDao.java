package com.revature.dao;

import com.revature.models.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllEmployee();
    public List<User> getALlManager();
    public List<User> getAllMemberManager1();
    public List<User> getAllMemberManager2();
    public void createUser(User user);


    public User readUserByEmail(String email);


}
