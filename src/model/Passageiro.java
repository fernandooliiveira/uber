package model;

public class Passageiro {
    String cpf;
    String nome;
    String endereco;
    String telefone;
    String cartaoCredito;
    String sexo;
    String cidadeOrigem;
    String email;

//    public Passageiro(){}

    public Passageiro(String cpf, String nome, String endereco, String telefone, String cartaoCredito,
                      String sexo, String cidadeOrigem, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cartaoCredito = cartaoCredito;
        this.sexo = sexo;
        this.cidadeOrigem = cidadeOrigem;
        this.email = email;
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

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", sexo='" + sexo + '\'' +
                ", cidadeOrigem='" + cidadeOrigem + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
