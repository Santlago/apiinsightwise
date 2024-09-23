package br.com.fiap.apiinsightwise.user;

import br.com.fiap.apiinsightwise.user.dto.UserProfileResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public void updateAvatar(String email, MultipartFile file) {

        // validar o arquivo
        if(file.isEmpty()){
            throw new RuntimeException("Invalid File");
        }

        // salvar arquivo no disco
        try(InputStream is = file.getInputStream()){
            Path destinationDir = Path.of("src/main/resources/static/avatars");
            Path destinationFile = destinationDir
                    .resolve(System.currentTimeMillis() + file.getOriginalFilename() )
                    .normalize()
                    .toAbsolutePath();

            Files.copy(is, destinationFile);

            System.out.println("Arquivo salvo com sucesso");

            var user = userRepository.findByEmail(email).orElseThrow( () -> new UsernameNotFoundException("User not found"));
            var baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
            var avatarUrl = baseUrl + "/avatars/" + destinationFile.getFileName();
            user.setAvatar(avatarUrl);
            userRepository.save(user);

        }catch (Exception e){
            System.out.println("Erro ao copiar arquivo. " + e.getCause());
        }
    }
}
