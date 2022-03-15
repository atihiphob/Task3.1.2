package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.models.Role;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService{
    private final RoleDao roleDao;
    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Set<Role> findRoles(List<Integer> roles) {
        return roleDao.findRoles(roles);
    }

    @Override
    public Role getRoleByName(String role_name) {
        return roleDao.getRoleByName(role_name);
    }

    @Override
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getRolesList();
    }
}
