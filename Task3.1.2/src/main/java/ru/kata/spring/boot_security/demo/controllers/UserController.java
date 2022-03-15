package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.UserEntity;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserEntityService;

import java.security.Principal;


@Controller
@RequestMapping ("/user")
public class UserController {
    private final UserEntityService userEntityService;
    private final RoleService roleService;
    @Autowired
    public UserController(UserEntityService userEntityService, RoleService roleService) {
        this.userEntityService = userEntityService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showUser(Principal principal, Model model) {
        UserEntity user = userEntityService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("listRoles",roleService.getAllRoles());
        return "user";
    }
}
