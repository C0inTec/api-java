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
        this.acoes = (this.acoes != updateData.acoes() && updateData.acoes() != 0) ? updateData.acoes() : this.acoes;
        this.criptomoedas = (this.criptomoedas != updateData.criptomoedas() && updateData.criptomoedas() != 0) ? updateData.criptomoedas() : this.criptomoedas;
        this.imoveis = (this.imoveis != updateData.imoveis() && updateData.imoveis() != 0) ? updateData.imoveis() : this.imoveis;
        this.fundos = (this.fundos != updateData.fundos() && updateData.fundos() != 0) ? updateData.fundos() : this.fundos;
        this.rendaFixa = (this.rendaFixa != updateData.rendafixa() && updateData.rendafixa() != 0) ? updateData.rendafixa() : this.rendaFixa;
        this.negocios = (this.negocios != updateData.negocios() && updateData.negocios() != 0) ? updateData.negocios() : this.negocios;

    }
}
