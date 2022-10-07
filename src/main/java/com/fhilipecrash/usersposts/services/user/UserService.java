package com.fhilipecrash.usersposts.services.user;

import com.fhilipecrash.usersposts.interfaces.UserWithoutPosts;
import com.fhilipecrash.usersposts.models.User;

import java.util.List;

public interface UserService {
    User getUser(int id);

    User getUserByEmail(String email);

    UserWithoutPosts getUserWithoutPosts(int id);

    List<UserWithoutPosts> getAllUsersWithoutPosts();

    List<User> getAllUsers();

    User save(User user);

    User update(int id, User user);

    User delete(int id);
}
