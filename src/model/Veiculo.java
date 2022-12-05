package model;

import java.util.Date;

public class Veiculo {
    String placa;
    String marca;
    String modelo;
    Integer anoFabricacao;
    Integer capacidade;
    String cor;
    String tipoCombustivel;
    Float potenciaMotor;

    public Veiculo(String placa, String marca, String modelo, Integer anoFabricaco,
            Integer capacidade, String cor, String tipoCombustivel, Float potenciaMotor){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricaco;
        this.capacidade = capacidade;
        this.cor = cor;
        this.tipoCombustivel = tipoCombustivel;
        this.potenciaMotor = potenciaMotor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public String getCor() {
        return cor;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public Float getPotenciaMotor() {
        return potenciaMotor;
    }
}
