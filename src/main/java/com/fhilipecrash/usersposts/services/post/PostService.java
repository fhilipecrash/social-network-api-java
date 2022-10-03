package com.fhilipecrash.usersposts.services.post;

import com.fhilipecrash.usersposts.models.Post;

import java.util.List;

public interface PostService {
    public Post getPost(int id);

    public List<Post> getAllPosts();

    public Post save(Post post);

    public Post update(int id, Post post);

    public Post delete(int id);
}
