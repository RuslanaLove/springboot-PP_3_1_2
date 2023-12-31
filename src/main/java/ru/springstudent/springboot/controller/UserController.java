package ru.springstudent.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springstudent.springboot.model.User;
import ru.springstudent.springboot.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping (value = "/")
    public String showAllUsers(ModelMap modelMap) {
        List<User> allUsers = userService.showAllUsers();
        modelMap.addAttribute("allUsers", allUsers);
        return "users";
    }

    @PostMapping(value = "/addUser")
    public String addNewUser(@ModelAttribute ("user") User user) {
        userService.addNewUser(user);
        return "redirect:/";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
        User userUpdate = userService.findById(id);

        if (userUpdate != null) {
            userUpdate.setName(user.getName());
            userUpdate.setSurname(user.getSurname());
            userUpdate.setAge(user.getAge());
            userService.updateUser(userUpdate);
        }
        return "redirect:/";
    }

    @PostMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}