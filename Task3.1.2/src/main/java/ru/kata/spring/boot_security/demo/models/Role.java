package ru.kata.spring.boot_security.demo.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "roles")
public class Role implements GrantedAuthority {
    @Id
    private int id;

    @Column (name = "role_name")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    public Role() {
    }

    public Role(int id) {
        this.id = id;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
