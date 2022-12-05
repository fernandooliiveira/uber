package model;

public class ContaBancaria {
    Integer id;
    String nomeBanco;
    String agencia;
    String conta;

    public ContaBancaria(Integer id, String nomeBanco, String agencia, String conta) {
        this.id = id;
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.conta = conta;
    }
    
}
