package mvc.service;

import mvc.model.User;
import mvc.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class UserService implements UserDetailsService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }


    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;

    }
    //    public User getUserByName(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//
//    public User getUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//
//    public boolean existsUserById(long id) {
//        if (userRepository.existsById(id)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
