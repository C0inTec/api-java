package br.com.coin.domain.data_user;

import br.com.coin.domain.data_user.walletdata.Despesas;
import br.com.coin.domain.data_user.walletdata.Ganhos;
import br.com.coin.domain.data_user.walletdata.Investimentos;

public record WalletResponseDTO(Long id, Despesas despesas, Ganhos ganhos, Investimentos investimentos, Long userId) {
    public WalletResponseDTO(Wallet wallet){
        this(wallet.getId(), wallet.getValoresSaidas(), wallet.getValoresEntradas(), wallet.getInvestimentos(), wallet.getUserId());
    }
}
