package br.com.coin.domain.data_user;

import br.com.coin.domain.data_user.walletdata.DataDespesas;
import br.com.coin.domain.data_user.walletdata.DataGanhos;
import br.com.coin.domain.data_user.walletdata.DataInvestimento;

public record UpdateWallet(Long userId, DataDespesas despesas, DataInvestimento investimento, DataGanhos ganhos) {
}
