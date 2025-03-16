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

    public void atualizaDespesas(DataDespesas updateData){
        this.aluguel = (this.aluguel != updateData.aluguel() && updateData.aluguel() != 0) ? updateData.aluguel() : this.aluguel;
        this.contas = (this.contas != updateData.contas() && updateData.contas() != 0) ? updateData.contas() : this.contas;
        this.alimentacao = (this.alimentacao != updateData.alimentacao() && updateData.alimentacao() != 0) ? updateData.alimentacao() : this.alimentacao;
        this.transporte = (this.transporte != updateData.transporte() && updateData.transporte() != 0) ? updateData.transporte() : this.transporte;
        this.educacao = (this.educacao != updateData.educacao() && updateData.educacao() != 0) ? updateData.educacao() : this.educacao;
        this.saude = (this.saude != updateData.saude() && updateData.saude() != 0) ? updateData.saude() : this.saude;
        this.lazer = (this.lazer != updateData.lazer() && updateData.lazer() != 0) ? updateData.lazer() : this.lazer;
    }

}
