package com.fhilipecrash.usersposts.controllers;

import com.fhilipecrash.usersposts.models.Post;
import com.fhilipecrash.usersposts.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping()
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable int id) {
        return postService.getPost(id);
    }

    @PostMapping("/create")
    public String save(@RequestBody Post post) {
        postService.save(post);
        return "Post saved";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Post post) {
        if (postService.update(id, post) != null) {
            return "Post updated";
        } else {
            return "Post not found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        if (postService.delete(id) != null) {
            return "Post deleted";
        } else {
            return "Post not found";
        }
    }
}
