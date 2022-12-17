package com.fhilipecrash.usersposts.models;

import java.util.List;

public interface IUserPosts {
    int getId();
    String getName();
    String getEmail();
    List<IPost> getPosts();
}
