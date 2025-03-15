package br.com.coin.domain.data_user;


import br.com.coin.domain.data_user.walletdata.*;
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
        if (updateWallet.investimento() != null) {
            this.investimentos.atualizaInvestimento(updateWallet.investimento());
        } else {
            this.investimentos.atualizaInvestimento(new DataInvestimento(0, 0, 0, 0, 0, 0));
        }
        if (updateWallet.despesas() != null) {
            this.valoresSaidas.atualizaDespesas(updateWallet.despesas());
        } else {
            this.valoresSaidas.atualizaDespesas(new DataDespesas(0, 0, 0, 0, 0, 0, 0));
        }
        if (updateWallet.ganhos() != null) {
            this.valoresEntradas.atualizaGanhos(updateWallet.ganhos());
        } else {
            this.valoresEntradas.atualizaGanhos(new DataGanhos(0, 0, 0, 0, 0, 0));
        }
    }
}
