package web.controller;

import web.model.User;
import web.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String findAllUsers(ModelMap model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "findAllUsers";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestParam("addFieldName") String name, @RequestParam("addFieldAge") Integer age, ModelMap model) {
        User user = new User(name, age);
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @PostMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("deleteUser") Integer id, ModelMap model) {
        User userById = userService.getUserById(id);
        userService.deleteUser(userById);
        return "redirect:/";
    }

    @GetMapping(value = "/findUser")
    public String findUserById(@RequestParam("addIdName") Integer id, ModelMap model) {
        User userById = userService.getUserById(id);
        model.addAttribute("userById", userById);
        return "findUserById";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestParam("updateUser") Integer id, @RequestParam("addNewName") String name, @RequestParam("addNewAge") Integer age, ModelMap model) {
        User userById = userService.getUserById(id);
        userById.setName(name);
        userById.setAge(age);
        userService.updateUser(userById);
        return "redirect:/";
    }
}
