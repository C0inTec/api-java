package br.com.coin.controller;

import br.com.coin.domain.user.*;
import br.com.coin.service.TokenService;
import br.com.coin.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private WalletService walletService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal()); //vai pegar o usuário baseado no auth e o principal faz isso
        User user  = (User) userRepository.findByEmail(data.email());
        return ResponseEntity.ok(new LoginResponseDTO(token, user.getId()));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRequestDTO data) {
        if (this.userRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }
        // Validar o role antes de criar o usuário
        try {
            UserRole.fromValue(data.role());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid role: " + data.role());
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.first_name(),data.last_name(),data.email(), encryptedPassword,data.cpf(),data.phone(),data.date_of_birthday(), data.role());

        this.userRepository.save(newUser);
        this.walletService.saveWallet(newUser.getId());

        return ResponseEntity.ok().body(newUser);
    }
}
