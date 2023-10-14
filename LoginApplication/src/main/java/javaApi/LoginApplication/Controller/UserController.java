package javaApi.LoginApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javaApi.LoginApplication.Entity.User;
import javaApi.LoginApplication.Service.UserService;

@RestController
public class UserController {
@Autowired
private UserService userService;

 @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return "Fields must not be empty.";
        }
        User existingUser = userService.findByEmail(user.getEmail());
        
        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            return "Invalid username or password.";
        }

        return "Login successful.";
    }
  
}