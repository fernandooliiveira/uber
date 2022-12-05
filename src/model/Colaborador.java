package model;

public class Colaborador {
    String cpf;
    String nome;
    String endereco;
    String telefone;
    String cnh;
    Integer contaBancaria;

    public Colaborador(String cpf, String nome, String endereco, String telefone, String cnh,
                Integer contaBancaria) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnh = cnh;
        this.contaBancaria = contaBancaria;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCnh() {
        return cnh;
    }

    public Integer getContaBancaria() {
        return contaBancaria;
    }
}
