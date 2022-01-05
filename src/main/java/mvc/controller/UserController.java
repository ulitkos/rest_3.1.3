package mvc.controller;

import mvc.model.User;
import mvc.service.RoleService;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping(value = "/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "userpage";
    }

    @GetMapping(value = "/admin")
    public String listUsers(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "adminpage";
    }

//    @GetMapping(value = "/login")
//    public String login() {
//        return "loginpage";
//    }
//    @GetMapping(value = "/user")
//    public String userInfo(@AuthenticationPrincipal User user, Model model) {
//        model.addAttribute("user", user);
//        model.addAttribute("roles", user.getRoles());
//        return "userpage";
//    }
//
//    @GetMapping(value = "/admin")
//    public String listUsers(@AuthenticationPrincipal User user, Model model) {
//        model.addAttribute("user", user);
//        model.addAttribute("allUsers", userService.getAllUsers());
//        model.addAttribute("allRoles", roleService.getAllRoles());
//        return "adminpage";
//    }
//
//    @PostMapping(value = "/admin")
//    public String editUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
//        user.setRoles(roleService.getRoleSetFromStrings(checkBoxRoles));
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping(value = "/admin/add")
//    public String addUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
//        user.setRoles(roleService.getRoleSetFromStrings(checkBoxRoles));
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping(value = "admin/delete")
//    public String adminDeletePost(@RequestParam("id") Long id) {
//        userService.removeUserById(id);
//        return "redirect:/admin";
//    }
}
