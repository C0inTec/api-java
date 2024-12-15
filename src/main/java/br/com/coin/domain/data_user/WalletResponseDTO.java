package br.com.coin.domain.data_user;

public record WalletResponseDTO(Long id, double saldo, double gastos, double salario, double investimentos, Long userId) {
    public WalletResponseDTO(Wallet wallet){
        this(wallet.getId(), wallet.getSaldo(), wallet.getGastos(), wallet.getSalario(), wallet.getInvestimento(), wallet.getUserId());
    }
}
