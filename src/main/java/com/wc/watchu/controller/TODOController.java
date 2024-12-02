package com.wc.watchu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TODOController {

    @GetMapping("/admin_registration")
    public String adminRegistration() {
        return "admin/admin_registration";
    }

    @GetMapping("/admin_read")
    public String adminRead() {
        return "admin/admin_read";
    }

    @GetMapping("/director_add")
    public String directorAdd() {
        return "admin/director_add";
    }

    @GetMapping("/director_read")
    public String directorRead() {
        return "admin/director_read";
    }

    @GetMapping("/actor_add")
    public String actorAdd() {
        return "admin/actor_add";
    }

    @GetMapping("/actor_read")
    public String actorRead() {
        return "admin/actor_read";
    }

    @GetMapping("/actor_edit")
    public String actorEdit() {
        return "admin/actor_edit";
    }

    @GetMapping("/director_edit")
    public String directorEdit() {
        return "admin/director_edit";
    }

    @GetMapping("/admin_edit")
    public String adminEdit() {
        return "admin/admin_edit";
    }

}
