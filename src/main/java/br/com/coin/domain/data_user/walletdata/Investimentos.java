package br.com.coin.domain.data_user.walletdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Investimentos {
    private double acoes = 0;
    private double fundos = 0;
    private double criptomoedas = 0;
    private double imoveis = 0;
    private double rendaFixa = 0;
    private double negocios = 0;


    public Investimentos(DataInvestimento data){
        this.acoes = data.acoes();
        this.criptomoedas = data.criptomoedas();
        this.imoveis = data.imoveis();
        this.fundos = data.fundos();
        this.rendaFixa = data.rendafixa();
        this.negocios = data.negocios();
    }

    public void atualizaInvestimento(DataInvestimento updateData){
        if(this.acoes != updateData.acoes()){
            this.acoes = updateData.acoes();
        }
        if(this.criptomoedas != updateData.criptomoedas()){
            this.criptomoedas = updateData.criptomoedas();
        }
        if(this.imoveis != updateData.imoveis()){
            this.imoveis = updateData.imoveis();
        }
        if(this.fundos != updateData.fundos()){
            this.fundos = updateData.fundos();
        }
        if(this.rendaFixa != updateData.rendafixa()){
            this.rendaFixa = updateData.rendafixa();
        }
        if(this.negocios != updateData.negocios()){
            this.negocios = updateData.negocios();
        }

    }
}
