package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getAllUser(Model model){
        model.addAttribute("listUser",userService.getAllUser());
        return "users";
    }
}
