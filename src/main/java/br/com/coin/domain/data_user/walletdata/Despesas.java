package br.com.coin.domain.data_user.walletdata;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Embeddable
public class Despesas {
    private double aluguel = 0;
    private double contas = 0;
    private double alimentacao = 0;
    private double transporte = 0;
    private double educacao = 0;
    private double saude = 0;
    private double lazer = 0;

    public Despesas(DataDespesas data){
        this.aluguel = data.aluguel();
        this.contas = data.contas();
        this.alimentacao = data.alimentacao();
        this.transporte = data.transporte();
        this.educacao = data.educacao();
        this.saude = data.saude();
        this.lazer = data.lazer();
    }

    public void atualizaDespesas(DataDespesas updateDespesas){
        if(this.aluguel != updateDespesas.aluguel()){
            this.aluguel = updateDespesas.aluguel();
        }
        if(this.contas != updateDespesas.contas()){
            this.contas = updateDespesas.contas();
        }
        if(this.alimentacao != updateDespesas.alimentacao()){
            this.alimentacao = updateDespesas.alimentacao();
        }
        if(this.transporte!= updateDespesas.transporte()){
            this.transporte = updateDespesas.transporte();
        }
        if(this.educacao != updateDespesas.educacao()){
            this.educacao = updateDespesas.educacao();
        }
        if(this.saude != updateDespesas.saude()){
            this.saude = updateDespesas.saude();
        }
        if(this.lazer != updateDespesas.lazer()){
            this.lazer = updateDespesas.lazer();
        }
    }

}
