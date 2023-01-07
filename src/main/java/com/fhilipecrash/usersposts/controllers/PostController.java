package com.fhilipecrash.usersposts.controllers;

import com.fhilipecrash.usersposts.models.IPost;
import com.fhilipecrash.usersposts.models.Post;
import com.fhilipecrash.usersposts.services.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts", produces = "application/json")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public List<IPost> getAllPosts() {
        return postService.getAllIPosts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public IPost getPost(@PathVariable("id") int id) {
        return postService.getIPost(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "Post created")
    public void save(@RequestBody Post post) {
        postService.save(post);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Post updated")
    public void update(@PathVariable("id") int id, @RequestBody Post post) {
        postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Post deleted")
    public void delete(@PathVariable("id") int id) {
        postService.delete(id);
    }
}
