package model;

public class ColaboradorProprietario {
    String cpfProprietario;
    String placaVeiculo;

    public ColaboradorProprietario(String cpfProprietario, String placaVeiculo) {
        this.cpfProprietario = cpfProprietario;
        this.placaVeiculo = placaVeiculo;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }
}
