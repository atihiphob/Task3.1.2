package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.UserEntity;

import java.util.List;
import java.util.Set;

public interface UserEntityService {
    void add (UserEntity user, Set<Role> roles);
    void update (UserEntity user, Set<Role> roles);
    void remove (int id);
    List<UserEntity> getAllUsers();
    UserEntity getUserById (int id);
    UserEntity findByUsername (String username);


}
