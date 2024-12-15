package br.com.coin.controller;

import br.com.coin.domain.data_user.UpdateWallet;
import br.com.coin.domain.data_user.Wallet;
import br.com.coin.domain.data_user.WalletResponseDTO;
import br.com.coin.domain.user.UpdateUser;
import br.com.coin.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PutMapping
    private ResponseEntity updateWallet(@RequestBody UpdateWallet wallet) {
        WalletResponseDTO walletResponseDTO = walletService.updateWallet(wallet);
        return ResponseEntity.ok(walletResponseDTO);
    }
    @GetMapping
    private ResponseEntity allWallets(){
        return ResponseEntity.ok(walletService.getAllWallets());
    }

}
