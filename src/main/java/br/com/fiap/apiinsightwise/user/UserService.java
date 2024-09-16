package br.com.fiap.apiinsightwise.user;

import br.com.fiap.apiinsightwise.user.dto.UserProfileResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAvatar("https://avatar.iran.liara.run/username?username=" + user.getName());
        // mailService.sendWelcomeEmail(user);
        return userRepository.save(user);
    }

    public UserProfileResponse getProfile(String email) {
        return userRepository.findByEmail(email)
                .map(UserProfileResponse::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
