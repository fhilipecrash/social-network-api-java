package com.fhilipecrash.usersposts.services.user;

import com.fhilipecrash.usersposts.models.User;

import java.util.List;

public interface UserService {
    public User getUser(int id);

    public List<User> getAllUsers();

    public User save(User user);

    public User update(int id, User user);

    public User delete(int id);
}
