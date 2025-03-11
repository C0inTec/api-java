package br.com.coin.domain.data_user;


import br.com.coin.domain.data_user.walletdata.Despesas;
import br.com.coin.domain.data_user.walletdata.Ganhos;
import br.com.coin.domain.data_user.walletdata.Investimentos;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "wallets")
@Table(name = "wallets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Wallet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Embedded
    private Despesas valoresSaidas;

    @Embedded
    private Ganhos valoresEntradas;

    @Embedded
    private Investimentos investimentos;

    public Wallet(Long id){
        this.userId = id;
        this.valoresSaidas = new Despesas();
        this.valoresEntradas = new Ganhos();
        this.investimentos = new Investimentos();
    }

    public void upWallet(UpdateWallet updateWallet) {
        this.investimentos.atualizaInvestimento(updateWallet.investimento());
        this.valoresEntradas.atualizaGanhos(updateWallet.ganhos());
        this.valoresSaidas.atualizaDespesas(updateWallet.despesas());
        }
}
