package javaApi.LoginApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaApi.LoginApplication.Entity.User;
import javaApi.LoginApplication.Repository.UserRepository;

@Service
public class UserService {
@Autowired
private UserRepository userRepository;

public String saveUser(User user) {

    if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
        return "Fields must not be empty.";
    }
    if (userRepository.findByEmail(user.getEmail()) != null ){
        return "User already exists.";
    }
    userRepository.save(user);
        return "User saved successfully.";
}
public User findByEmail(String email) {
    return userRepository.findByEmail(email);
}
}

    
