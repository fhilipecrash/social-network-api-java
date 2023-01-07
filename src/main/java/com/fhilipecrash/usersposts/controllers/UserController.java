package com.fhilipecrash.usersposts.controllers;

import com.fhilipecrash.usersposts.models.IUser;
import com.fhilipecrash.usersposts.models.User;
import com.fhilipecrash.usersposts.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> getUsers(@RequestParam(value = "email", required = false) Optional<String> email) {
        if (email.isEmpty()) {
            return ResponseEntity.ok(userService.getAllIUsers());
        } else {
            return ResponseEntity.ok(userService.getUserByEmail(email.get()));
        }
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

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<?> getUserPosts(
            @RequestParam(value = "with_user_info", required = false) boolean withUserInfo,
            @PathVariable("id") int id) {
        if (withUserInfo) {
            return ResponseEntity.ok(userService.getIUserPosts(id));
        } else {
            return ResponseEntity.ok(userService.getUserPosts(id));
        }
    }
}
