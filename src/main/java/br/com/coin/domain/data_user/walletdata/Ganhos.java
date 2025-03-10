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
        if(this.salario != updateData.salario()){
            this.salario = updateData.salario();
        }
        if(this.outros != updateData.outros()){
            this.outros = updateData.outros();
        }
        if(this.freelas != updateData.freelas()){
            this.freelas = updateData.freelas();
        }
        if(this.bonus!= updateData.bonus()){
            this.bonus = updateData.bonus();
        }
        if(this.rendimentosPassivos != updateData.rendimentosPassivos()){
            this.rendimentosPassivos = updateData.rendimentosPassivos();
        }
        if(this.dividendos != updateData.dividendos()){
            this.dividendos = updateData.dividendos();
        }
    }
}
