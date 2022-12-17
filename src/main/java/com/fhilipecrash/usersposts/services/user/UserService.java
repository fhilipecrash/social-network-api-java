package com.fhilipecrash.usersposts.services.user;

import com.fhilipecrash.usersposts.models.IPost;
import com.fhilipecrash.usersposts.models.IUser;
import com.fhilipecrash.usersposts.models.IUserPosts;
import com.fhilipecrash.usersposts.models.User;

import java.util.List;

public interface UserService {
    User getUser(int id);

    IUser getIUser(int id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    List<IUser> getAllIUsers();

    User save(User user);

    User update(int id, User user);

    User delete(int id);

    List<IPost> getUserPosts(int id);

    IUserPosts getIUserPosts(int id);
}
