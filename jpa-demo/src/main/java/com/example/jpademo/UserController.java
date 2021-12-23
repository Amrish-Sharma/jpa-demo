package com.example.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/v1/users")
    public List<User> getUsers() throws SQLException{
        return userService.getUsers();
    }

    @GetMapping("/api/v1/user/{userid}")
    public User getUser(@PathVariable int userid) throws SQLException{

        return userService.getUserById(userid);
    }

    @PostMapping("/api/v1/user/post")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest){

        try{
                userService.createUser(userCreateRequest);
                return new ResponseEntity<String>("User is created", HttpStatus.ACCEPTED);
        }
         catch (SQLException e) {
            return new ResponseEntity<>(e.getCause().getCause().getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
         catch(Exception e){
            return new ResponseEntity<>(e.getCause().getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }



    @DeleteMapping("/api/v1/delete/{userid}")
    public User deleteUser(@PathVariable int userid) throws SQLException{
        return userService.deleteUser(userid);
    }
}
