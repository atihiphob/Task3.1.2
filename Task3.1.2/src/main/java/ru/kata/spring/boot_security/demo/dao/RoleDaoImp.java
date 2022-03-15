package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByName(String roleName) {
        Role role = null;
        try {
            role = entityManager.createQuery("select r from Role r where r.roleName = :role_name", Role.class)
                    .setParameter("role_name", roleName)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Exception threw from method getRoleByName() in RoleDaoImp.class");
        }
        return role;
    }

    @Override
    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> getRolesList() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getDefaultRole() {
        return getRoleByName("ROLE_USER");
    }

    @Override
    public Set <Role> findRoles(List<Integer> roles) {
        TypedQuery<Role> foundedRole = entityManager.createQuery("select r from Role r where r.id in :role", Role.class);
        foundedRole.setParameter("role", roles);
        return new HashSet<> (foundedRole.getResultList());
    }
}
