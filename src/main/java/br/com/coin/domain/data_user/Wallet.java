package br.com.coin.domain.data_user;


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

    private double saldo;

    private double gastos;

    private double salario;

    private double investimento;

    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getInvestimento() {
        return investimento;
    }

    public void setInvestimento(double investimento) {
        this.investimento = investimento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Wallet(Long id){
        this.userId = id;
    }

    public void upWallet(UpdateWallet updateWallet) {
        if(updateWallet.saldo() != this.saldo){
            this.saldo = updateWallet.saldo();
        }
        if(updateWallet.gastos() != this.gastos){
            this.gastos = updateWallet.gastos();
        }
        if(updateWallet.salario() != this.salario){
            this.salario = updateWallet.salario();
        }
        if(updateWallet.investimentos() != this.investimento){
            this.investimento = updateWallet.investimentos();
        }
    }
}
