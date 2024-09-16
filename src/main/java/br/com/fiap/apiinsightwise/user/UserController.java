package br.com.fiap.apiinsightwise.user;

import br.com.fiap.apiinsightwise.user.dto.UserFormRequest;
import br.com.fiap.apiinsightwise.user.dto.UserProfileResponse;
import br.com.fiap.apiinsightwise.user.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserFormRequest userForm, UriComponentsBuilder uriBuilder){
        var user = userService.create(userForm.toModel());
        var uri = uriBuilder
                .path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(UserResponse.from(user));
    }

    @GetMapping("profile")
    public UserProfileResponse getProfile(){
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return userService.getProfile(email);
    }
}
