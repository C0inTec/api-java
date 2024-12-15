package br.com.coin.service;

import br.com.coin.domain.data_user.UpdateWallet;
import br.com.coin.domain.data_user.Wallet;
import br.com.coin.domain.data_user.WalletRepository;
import br.com.coin.domain.data_user.WalletResponseDTO;
import br.com.coin.domain.user.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;


    public WalletService(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    @Transactional
    public void saveWallet(Long id){
        Wallet wallet = new Wallet(id);
        walletRepository.save(wallet);
    }

    @Transactional
    public WalletResponseDTO updateWallet(UpdateWallet updateWallet){
        Wallet wallet = new Wallet(updateWallet.userId());
        if(wallet != null){
            wallet.upWallet(updateWallet);
            walletRepository.save((wallet));
        }
        return new WalletResponseDTO(wallet);
    }
}
