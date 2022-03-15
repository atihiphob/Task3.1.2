package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.UserEntity;

import java.util.List;
import java.util.Set;

public interface UserEntityDao {
    void add (UserEntity user);
    void update(UserEntity user, Set<Role> roles);
    void remove(int id);
    UserEntity getUserById (int id);
    List<UserEntity> getAllUsers();
    UserEntity getUserEntityByUsername (String username);
//    void setRoleToUserById (int user_id, int role_id);
}
