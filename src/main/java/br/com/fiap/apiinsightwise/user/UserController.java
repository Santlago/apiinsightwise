package br.com.fiap.apiinsightwise.user;

import br.com.fiap.apiinsightwise.user.dto.UserFormRequest;
import br.com.fiap.apiinsightwise.user.dto.UserResponse;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserResponse> save(@RequestBody UserFormRequest userForm, UriComponentsBuilder uribuilder) {
        var user= userService.create(userForm.toModel());
        var uri = uribuilder
                .path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(UserResponse.from(user));
    }
}
