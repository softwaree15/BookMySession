package com.bookmysession.controller;

import com.bookmysession.model.Users;
import com.bookmysession.service.UserService;
import com.bookmysession.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers()
    {
        List<Users> usersList=userService.getAllUser();
        log.info("All users {} ",usersList.size());
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable() long id)
    {
        Users user=userService.getUserById(id);
        log.info("User {} ",user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> signUpUser(@RequestBody Users user)
    {
        log.info("Created user {} ",user);
        userService.createUser(user);
        log.info("Created user {} ",user);
        return new ResponseEntity<>(StringUtils.SUCCESS, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user)
    {
        log.info("Body user {} ",user);
        if (user.getEmail()==null ||  user.getPassword()==null)
        {
            throw  new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,StringUtils.SHOULD_NOT_NULL+user);
        }
        user=userService.login(user);
        log.info("Updated user {} ",user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
