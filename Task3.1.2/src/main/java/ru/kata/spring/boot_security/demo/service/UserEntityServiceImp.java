package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserEntityDao;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.UserEntity;


import java.util.List;
import java.util.Set;

@Service ("userEntityServiceImp")
public class UserEntityServiceImp implements UserEntityService, UserDetailsService {
    private final UserEntityDao userEntityDao;
    @Autowired
    public UserEntityServiceImp(UserEntityDao userEntityDao) {
        this.userEntityDao = userEntityDao;
    }

    @Transactional
    @Override
    public void add(UserEntity user, Set<Role> roles) {
        user.setRoles(roles);
        userEntityDao.add(user);
    }

    @Transactional
    @Override
    public void update(UserEntity user, Set<Role> roles) {
        user.setRoles(roles);
        userEntityDao.update(user, roles);
    }

    @Transactional
    @Override
    public void remove(int id) {
        userEntityDao.remove(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userEntityDao.getAllUsers();
    }

    @Override
    public UserEntity getUserById(int id) {
        return userEntityDao.getUserById(id);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userEntityDao.getUserEntityByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userEntityDao.getUserEntityByUsername(username);
    }
}
