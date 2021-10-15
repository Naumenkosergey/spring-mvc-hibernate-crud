package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getAllUser(Model model) {
        model.addAttribute("listUser", userService.getAllUser());
        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "user_details";
    }


    @PostMapping("/users/add")
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/user/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @PostMapping("user/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("listUser", userService.getAllUser());
        return "users";
    }
}
