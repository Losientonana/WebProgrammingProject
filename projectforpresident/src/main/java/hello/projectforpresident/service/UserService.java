package hello.projectforpresident.service;

import hello.projectforpresident.entity.User;
import hello.projectforpresident.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> authenticateUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password));
    }

}