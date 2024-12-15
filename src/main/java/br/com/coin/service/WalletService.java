package br.com.coin.service;

import br.com.coin.domain.data_user.UpdateWallet;
import br.com.coin.domain.data_user.Wallet;
import br.com.coin.domain.data_user.WalletRepository;
import br.com.coin.domain.data_user.WalletResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;


    public WalletService(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    public void saveWallet(Long id){
        Wallet wallet = new Wallet(id);
        walletRepository.save(wallet);
    }

    @Transactional
    public WalletResponseDTO updateWallet(UpdateWallet updateWallet){
        Wallet wallet = walletRepository.findWalletByUserId(updateWallet.userId());
        if(wallet != null){
            wallet.upWallet(updateWallet);
            walletRepository.save((wallet));
        }
        return new WalletResponseDTO(wallet);
    }

    @Transactional
    public List<WalletResponseDTO> getAllWallets(){
        List<WalletResponseDTO> allWallets = walletRepository.findAll().stream().map(WalletResponseDTO::new).toList();
        return allWallets;
    }
}
