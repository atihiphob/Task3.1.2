package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.Role;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    Role getRoleByName (String roleName);
    Role getRoleById (int id);
    List<Role> getRolesList();
    Role getDefaultRole();
    Set<Role> findRoles (List <Integer> roles);
}
