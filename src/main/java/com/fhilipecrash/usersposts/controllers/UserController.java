package com.fhilipecrash.usersposts.controllers;

import com.fhilipecrash.usersposts.models.User;
import com.fhilipecrash.usersposts.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("/create")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "User saved";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody User user) {
        if (userService.update(id, user) != null) {
            return "User updated";
        } else {
            return "User not found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        if (userService.delete(id) != null) {
            return "User deleted";
        } else {
            return "User not found";
        }
    }

}
