package web.controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import web.model.User;
import web.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String findAllUsers(ModelMap model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "find-all-users";
    }

    @GetMapping(value = "/actionUserForm")
    public String addUserRedirect(ModelMap model) {
        return "add-user";
    }

    @PostMapping(value ="/addUser")
    public String addUser(@ModelAttribute("user") @Validated User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("deleteUser") Integer id) {
        User userById = userService.getUserById(id);
        userService.deleteUser(userById);
        return "redirect:/";
    }

    @GetMapping(value = "/findUser")
    public String findUserById(@RequestParam("findID") Integer id, ModelMap model) {
        User userById = userService.getUserById(id);
        model.addAttribute("userById", userById);
        return "find-user-by-id";
    }

    @GetMapping(value = "/actionUpdateForm")
    public String updateUserRedirect(ModelMap model) {
        List<User> allUsers1 = userService.getAllUsers();
        model.addAttribute("allUsers1", allUsers1);
        return "update-user";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@ModelAttribute("user1") @Validated User user, @RequestParam("updateUser") Integer id) {
        userService.updateUser(id,user);
        return "redirect:/";
    }


}
