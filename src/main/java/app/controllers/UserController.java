package app.controllers;

import app.models.User;
import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("user", us.getAllUsers());
        return "hello";
    }

    @GetMapping("/new")
    public String newCustomerForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("User") User user) {
        us.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/editUser")
    public String edit (ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user",us.findById(id));
        return "editUser";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("User") User user, @PathVariable("id")  long id){
        us.update(id,user);
        return "redirect:/";
    }

    @PostMapping("/{id}deleter")
    public String delete(@PathVariable("id") long id){
        us.delete(id);
        return "redirect:/";
    }
}
