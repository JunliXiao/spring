package learn.junli.controller;

import learn.junli.model.User;
import learn.junli.repository.UserRepository;
import learn.junli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> allUsers() {
        return userService.listAll();
    }

    @GetMapping("/users/{username}")
    public User getUserBy(@PathVariable String username) {
        return userRepository.findByUserName(username);
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        if (userService.addUser(user)) {
            return "Successfully added " + user.getUsername();
        } else {
            return "Failed to add " + user.getUsername();
        }
    }

    @PutMapping("/users/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        User original = userRepository.findByUserName(username);
        original.setUsername(user.getUsername());
        original.setPassword(user.getPassword());
        original.setFullname(user.getFullname());
        userRepository.save(original);
        return original;
    }

    @DeleteMapping("/users/{username}")
    public User deleteUser(@PathVariable String username) {
        User user = userRepository.findByUserName(username);
        userRepository.delete(user);
        return user;
    }

}
