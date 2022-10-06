package com.fhilipecrash.usersposts.services.post;

import com.fhilipecrash.usersposts.models.Post;

import java.util.List;

public interface PostService {
    Post getPost(int id);

    List<Post> getAllPosts();

    Post save(Post post);

    Post update(int id, Post post);

    Post delete(int id);
}
