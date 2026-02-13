package HotWhellShop_Spring_react.controller;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import HotWhellShop_Spring_react.domain.User;
import HotWhellShop_Spring_react.domain.DTO.UserDTO.ResGetAllUserDTO;
import HotWhellShop_Spring_react.domain.DTO.UserDTO.ResGetUserByidDTO;
import HotWhellShop_Spring_react.domain.DTO.UserDTO.ResUpdateUserDTO;
import HotWhellShop_Spring_react.domain.DTO.UserDTO.ResUserDTO;
import HotWhellShop_Spring_react.service.UserService;
import HotWhellShop_Spring_react.util.error.IdInvalidException;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // Create User
    @PostMapping("/users")
    public ResponseEntity<ResUserDTO> CreateUser(@RequestBody User UserPostman) {
        String passWordEncode = this.passwordEncoder.encode(UserPostman.getPassword());
        UserPostman.setPassword(passWordEncode);
        User hiu = this.userService.handleCreateUser(UserPostman);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.handleConvertCreateUserDTO(hiu));
    }

    // fetch user by id
    @GetMapping("/users/{id}")
    public ResponseEntity<ResGetUserByidDTO> getUserByID(@PathVariable("id") long id) {
        User fetchUser = this.userService.fetchUserByid(id);
        return ResponseEntity.ok(this.userService.handleConvertGetUserByIdDTO(fetchUser));
    }

    // fetch user
    @GetMapping("/users")
    public ResponseEntity<List<ResGetAllUserDTO>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.handleConvertGetAllUserDTO());
    }

    @PutMapping("/users")
    public ResponseEntity<ResUpdateUserDTO> UpdateUser(@RequestBody User user) {
        User hiunumdum = this.userService.handleUpdateUser(user);
        return ResponseEntity.ok().body(this.userService.handleConvertUpdateUserDTO(hiunumdum));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable("id") long id) throws IdInvalidException {
        if (id > 15) {
            throw new IdInvalidException("id khong duoc lon hon 15");
        }
        this.userService.handleDeleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete user");
    }
}
