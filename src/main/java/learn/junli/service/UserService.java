package learn.junli.service;

import learn.junli.model.User;
import learn.junli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public boolean addUser(User user) {
        User existingUser = userRepository.findByUserName(user.getUsername());
        boolean notAlreadyExists = existingUser == null;
        if (existingUser == null) {
            userRepository.save(user);
        }
        return notAlreadyExists;
    }
}
