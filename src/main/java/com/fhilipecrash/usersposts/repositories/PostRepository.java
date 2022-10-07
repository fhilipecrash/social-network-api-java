package com.fhilipecrash.usersposts.repositories;

import com.fhilipecrash.usersposts.interfaces.PostsWithoutUserData;
import com.fhilipecrash.usersposts.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.id = ?1")
    PostsWithoutUserData findPostWithoutData(int id);

    @Query("select p from Post p")
    List<PostsWithoutUserData> findAllPosts();
}
