package com.fhilipecrash.usersposts.controllers;

import com.fhilipecrash.usersposts.models.IPost;
import com.fhilipecrash.usersposts.models.IUser;
import com.fhilipecrash.usersposts.models.User;
import com.fhilipecrash.usersposts.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public List<IUser> getAllUsers() {
        return userService.getAllIUsers();
    }

    @GetMapping(params = "email")
    @ResponseStatus(code = HttpStatus.OK)
    public User getUsersByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public IUser getUser(@PathVariable("id") int id) {
       return userService.getIUser(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "User created")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "User updated")
    public void update(@PathVariable("id") int id, @RequestBody User user) {
        userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "User deleted")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @GetMapping(value = "/{id}/posts", params = "with_user_info")
    public ResponseEntity<?> getUserPosts(
        @RequestParam(value = "with_user_info", required = false) boolean withUserInfo,
        @PathVariable("id") int id
    ) {
        if (withUserInfo) {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userService.getUserPosts(id), HttpStatus.OK);
        }
    }
}
