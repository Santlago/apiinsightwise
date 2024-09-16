package br.com.fiap.apiinsightwise.auth;

import br.com.fiap.apiinsightwise.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public Token login(Credentials credentials){
        var user = userRepository.findByEmail(credentials.email())
                .orElseThrow( () -> new RuntimeException("Access Denied1") );
        System.out.println(credentials.password());
        System.out.println(user.getPassword());
        if ( !passwordEncoder.matches(credentials.password(), user.getPassword()) )
            throw new RuntimeException("Access Denied2");

        return tokenService.createToken(credentials);

    }

}
