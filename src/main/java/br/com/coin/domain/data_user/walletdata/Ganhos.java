package br.com.coin.domain.data_user.walletdata;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Ganhos {
    private double salario = 0;
    private double bonus = 0;
    private double outros = 0;
    private double rendimentosPassivos = 0;
    private double freelas = 0;
    private double dividendos = 0;

    public Ganhos(DataGanhos data){
        this.salario = data.salario();
        this.bonus = data.bonus();
        this.dividendos = data.dividendos();
        this.freelas = data.freelas();
        this.outros = data.outros();
        this.rendimentosPassivos = data.rendimentosPassivos();
    }

    public void atualizaGanhos(DataGanhos updateData){
        this.salario = (this.salario != updateData.salario() && updateData.salario() != 0) ? updateData.salario() : this.salario;
        this.outros = (this.outros != updateData.outros() && updateData.outros() != 0) ? updateData.outros() : this.outros;
        this.freelas = (this.freelas != updateData.freelas() && updateData.freelas() != 0) ? updateData.freelas() : this.freelas;
        this.bonus = (this.bonus != updateData.bonus() && updateData.bonus() != 0) ? updateData.bonus() : this.bonus;
        this.rendimentosPassivos = (this.rendimentosPassivos != updateData.rendimentosPassivos() && updateData.rendimentosPassivos() != 0) ? updateData.rendimentosPassivos() : this.rendimentosPassivos;
        this.dividendos = (this.dividendos != updateData.dividendos() && updateData.dividendos() != 0) ? updateData.dividendos() : this.dividendos;
    }
}
