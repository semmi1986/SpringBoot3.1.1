package com.ITMentor.SpringBoot.dao;



import com.ITMentor.SpringBoot.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}