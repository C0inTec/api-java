package br.com.coin.service;


import br.com.coin.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public User createUser(UserRequestDTO user) {
        User newUser = new User(user);
        userRepository.save(newUser);
        return newUser;
    }

    @Transactional
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> users = userRepository.findAll().stream().map(UserResponseDTO::new).toList();
        return users;
    }

    @Transactional
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return new UserResponseDTO(user);
    }

    @Transactional
    public UserResponseDTO updateUser(UpdateUser user) {
        User userId = userRepository.getReferenceById(user.id());
        if(userId != null) {
            userId.updateData(user);
            userRepository.save(userId);
        }
        return new UserResponseDTO(userId);
    }

    @Transactional
    public void deleteUser(Long id) {
        User delUser = userRepository.getReferenceById(id);
        userRepository.delete(delUser);
    }




}
