package com.example.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;


    public void createUser(UserCreateRequest userCreateRequest) throws SQLException{
        userDAO.save(userCreateRequest.toUser());
    }

    public User deleteUser(int userId) throws SQLException{
        User user=userDAO.findById(userId).orElse(null);
        userDAO.deleteById(userId);
        return user;
    }

    public List<User> getUsers() throws SQLException{
        return userDAO.findAll();
    }

    public User getUserById(int userId) throws SQLException{
        return userDAO.findById(userId).orElse(null);

    }
}
