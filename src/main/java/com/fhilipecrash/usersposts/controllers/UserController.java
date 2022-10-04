package com.fhilipecrash.usersposts.controllers;

import com.fhilipecrash.usersposts.models.Post;
import com.fhilipecrash.usersposts.models.User;
import com.fhilipecrash.usersposts.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, Object> getUser(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        Map<String, Object> userMap = new LinkedHashMap<>();
        userMap.put("id", user.getId());
        userMap.put("name", user.getName());
        userMap.put("email", user.getEmail());

        List<Post> posts = user.getPosts();
        List<Map<String, Object>> postsMap = new ArrayList<>();
        posts.forEach(post -> {
            Map<String, Object> postMap = new LinkedHashMap<>();
            postMap.put("id", post.getId());
            postMap.put("title", post.getTitle());
            postMap.put("content", post.getContent());

            postsMap.add(postMap);
        });
        userMap.put("posts", postsMap);

        return userMap;
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "User created")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "User updated")
    public void update(@PathVariable("id") int id, @RequestBody User user) {
        userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "User deleted")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }

}
