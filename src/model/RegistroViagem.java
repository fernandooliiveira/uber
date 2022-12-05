package model;

import java.sql.Timestamp;

public class RegistroViagem {
    String passageiro;
    String veiculo;
    String motorista;
    String origemViagem;
    String destinoViagem;
    Timestamp dataHoraInicio;
    Timestamp dataHoraFim;
    String formaPagamento;
    Float valorPagamento;
    boolean cancelamentoMot;
    boolean cancelamentoPass;
    Integer codigoGerente;

    public RegistroViagem(String passageiro, String veiculo, String motorista, String origemViagem,
                   String destinoViagem, Timestamp dataHoraInicio, Timestamp dataHoraFim, String formaPagamento,
                   Float valorPagamento, boolean cancelamentoMot, boolean cancelamentoPass, Integer codigoGerente){
        this.passageiro = passageiro;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.origemViagem = origemViagem;
        this.destinoViagem = destinoViagem;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.formaPagamento = formaPagamento;
        this.valorPagamento = valorPagamento;
        this.cancelamentoMot = cancelamentoMot;
        this.cancelamentoPass = cancelamentoPass;
        this.codigoGerente = codigoGerente;
    }

    public RegistroViagem(String passageiro, String veiculo, String motorista, String origemViagem,
                          String destinoViagem, Timestamp dataHoraInicio, Timestamp dataHoraFim, String formaPagamento,
                          Float valorPagamento, boolean cancelamentoMot, boolean cancelamentoPass){
        this.passageiro = passageiro;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.origemViagem = origemViagem;
        this.destinoViagem = destinoViagem;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.formaPagamento = formaPagamento;
        this.valorPagamento = valorPagamento;
        this.cancelamentoMot = cancelamentoMot;
        this.cancelamentoPass = cancelamentoPass;
    }


    public String getPassageiro() {
        return passageiro;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public String getMotorista() {
        return motorista;
    }

    public String getOrigemViagem() {
        return origemViagem;
    }

    public String getDestinoViagem() {
        return destinoViagem;
    }

    public Timestamp getDataHoraInicio() {
        return dataHoraInicio;
    }

    public Timestamp getDataHoraFim() {
        return dataHoraFim;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public Integer getCodigoGerente() {
        return codigoGerente;
    }

    public Float getValorPagamento() {
        return valorPagamento;
    }

    public boolean isCancelamentoMot() {
        return cancelamentoMot;
    }

    public boolean isCancelamentoPass() {
        return cancelamentoPass;
    }
}
