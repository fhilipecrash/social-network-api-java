package com.fhilipecrash.usersposts.repositories;

import com.fhilipecrash.usersposts.models.IUser;
import com.fhilipecrash.usersposts.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

    @Query("select u from User u where u.id = ?1")
    IUser findUserById(int id);

    @Query("select u from User u")
    List<IUser> findAllUsers();
}
