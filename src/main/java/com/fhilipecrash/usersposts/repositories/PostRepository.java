package com.fhilipecrash.usersposts.repositories;

import com.fhilipecrash.usersposts.models.IPost;
import com.fhilipecrash.usersposts.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.id = ?1")
    IPost findPostById(int id);

    @Query("select p from Post p")
    List<IPost> findAllPosts();

    @Query("select p from Post p where p.user.id = ?1")
    List<IPost> findPostsByUserId(int id);
}
