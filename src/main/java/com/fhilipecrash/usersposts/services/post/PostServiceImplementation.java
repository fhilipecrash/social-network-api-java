package com.fhilipecrash.usersposts.services.post;

import com.fhilipecrash.usersposts.models.IPost;
import com.fhilipecrash.usersposts.models.Post;
import com.fhilipecrash.usersposts.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post getPost(int id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public IPost getIPost(int id) {
        return postRepository.findPostById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<IPost> getAllIPosts() {
        return postRepository.findAllPosts();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(int id, Post post) {
        Post postToUpdate = postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null;
        if (postToUpdate != null) {
            postToUpdate.setTitle(post.getTitle());
            postToUpdate.setContent(post.getContent());
            return postRepository.save(postToUpdate);
        }
        return null;
    }

    @Override
    public Post delete(int id) {
        Post postToDelete = postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null;
        if (postToDelete != null) {
            postRepository.delete(postToDelete);
            return postToDelete;
        }
        return null;
    }
}
