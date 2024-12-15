package br.com.coin.controller;

import br.com.coin.domain.user.UpdateUser;
import br.com.coin.domain.user.User;
import br.com.coin.domain.user.UserRequestDTO;
import br.com.coin.domain.user.UserResponseDTO;
import br.com.coin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO userRequestDTO, UriComponentsBuilder uriBuilder) {
        User user = userService.createUser(userRequestDTO);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
    @GetMapping
    public List<UserResponseDTO> getUsers() {
        List<UserResponseDTO> usersResponseDTOs = userService.getAllUsers();
        return usersResponseDTOs;
    }
    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping()
    public ResponseEntity updateUser(@RequestBody UpdateUser updateUser){
        UserResponseDTO userResponseDTO = userService.updateUser(updateUser);
        return ResponseEntity.ok((userResponseDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return  ResponseEntity.ok("User deleted successfully");
    }

}
