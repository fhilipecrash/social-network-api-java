package com.fhilipecrash.usersposts.services.user;

import com.fhilipecrash.usersposts.models.IPost;
import com.fhilipecrash.usersposts.models.IUser;
import com.fhilipecrash.usersposts.models.IUserPosts;
import com.fhilipecrash.usersposts.models.User;
import com.fhilipecrash.usersposts.repositories.PostRepository;
import com.fhilipecrash.usersposts.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserServiceImplementation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public IUser getIUser(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<IUser> getAllIUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(int id, User user) {
        User userToUpdate = userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
        if (userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            return userRepository.save(userToUpdate);
        }
        return null;
    }

    @Override
    public User delete(int id) {
        User userToDelete = userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
            return userToDelete;
        }
        return null;
    }

    @Override
    public List<IPost> getUserPosts(int id) {
        return postRepository.findPostsByUserId(id);
    }

    @Override
    public IUserPosts getIUserPosts(int id) {
        return userRepository.findUserPostsById(id);
    }
}
