package br.com.coin.service;


import br.com.coin.domain.data_user.Wallet;
import br.com.coin.domain.data_user.WalletRepository;
import br.com.coin.domain.user.*;
import br.com.coin.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  WalletService walletService;

    public UserService( UserRepository userRepository, WalletService walletService) {
        this.userRepository = userRepository;
        this.walletService = walletService;
    }
    @Transactional
    public User createUser(UserRequestDTO user) {
        User newUser = new User(user);
        userRepository.save(newUser);
        walletService.saveWallet(newUser.getId());
        return newUser;
    }

    @Transactional
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> users = userRepository.findAll().stream().map(UserResponseDTO::new).toList();
        return users;
    }

    @Transactional
    public UserResponseDTO getUserById(Long id)  {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound("User Not Found"));
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
