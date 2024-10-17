package com.ITMentor.SpringBoot.controller;


import com.ITMentor.SpringBoot.model.User;
import com.ITMentor.SpringBoot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";

    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
//        User user = userService.findById(id);
        model.addAttribute("user", userService.findById(id));
        return "userInfo";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
//        User user = userService.getUserById(id);
        model.addAttribute("user", userService.findById(id));
        return "editUser";
    }

    @PostMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}