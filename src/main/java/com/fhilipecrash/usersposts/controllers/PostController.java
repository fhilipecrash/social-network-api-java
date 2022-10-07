package com.fhilipecrash.usersposts.controllers;

import com.fhilipecrash.usersposts.interfaces.PostsWithoutUserData;
import com.fhilipecrash.usersposts.models.Post;
import com.fhilipecrash.usersposts.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public List<PostsWithoutUserData> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PostsWithoutUserData getPost(@PathVariable("id") int id) {
        return postService.getPostWithoutUserData(id);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "Post created")
    public void save(@RequestBody Post post) {
        postService.save(post);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Post updated")
    public void update(@PathVariable("id") int id, @RequestBody Post post) {
        postService.update(id, post);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Post deleted")
    public void delete(@PathVariable("id") int id) {
        postService.delete(id);
    }
}
