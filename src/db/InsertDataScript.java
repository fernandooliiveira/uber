package db;

import collection.*;
import model.*;

import java.sql.*;
import java.time.Instant;
import java.util.Objects;

public class InsertDataScript {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

        PassageiroCollection passageiroCollection = new PassageiroCollection();
        passageiroCollection.initCollection();
        ColaboradorCollection colaboradorCollection = new ColaboradorCollection();
        colaboradorCollection.initCollection();
        VeiculoCollection veiculoCollection = new VeiculoCollection();
        veiculoCollection.initCollection();
        ProprietarioCollection proprietarioCollection = new ProprietarioCollection();
        proprietarioCollection.initCollection();
        MotoristaCollection motoristaCollection = new MotoristaCollection();
        motoristaCollection.initCollection();
        ViagemCollection viagemCollection = new ViagemCollection();
        viagemCollection.initCollection();

        insertPassageiro(con, passageiroCollection);
        insertColaborador(con, colaboradorCollection);
        insertVeiculo(con, veiculoCollection);
        insertColaboradorProprietario(con, proprietarioCollection);
        insertColaboradorMotorista(con, motoristaCollection);
        insertRegistroViagem(con, viagemCollection);


        con.close();
    }

    private static void insertRegistroViagem(Connection con, ViagemCollection collection) throws SQLException {
        for (RegistroViagem viagem:
                collection.getViagens()) {
            if (viagem.isCancelamentoMot() || viagem.isCancelamentoPass()) {
                PreparedStatement myStmt = con.prepareStatement
                        ("INSERT INTO registro_viagem(passageiro, veiculo, motorista, origem_viagem, destino_viagem," +
                                "data_hora_inicio, data_hora_fim, forma_pagamento, valor_pagamento, " +
                                "cancelamento_mot, cancelamento_pass, codigo_gerente) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                myStmt.setString(1, viagem.getPassageiro());
                myStmt.setString(2, viagem.getVeiculo());
                myStmt.setString(3, viagem.getMotorista());
                myStmt.setString(4, viagem.getOrigemViagem());
                myStmt.setString(5, viagem.getDestinoViagem());
                myStmt.setTimestamp(6, viagem.getDataHoraInicio());
                myStmt.setTimestamp(7, viagem.getDataHoraFim());
                myStmt.setString(8, viagem.getFormaPagamento());
                myStmt.setFloat(9, viagem.getValorPagamento());
                myStmt.setBoolean(10, viagem.isCancelamentoMot());
                myStmt.setBoolean(11, viagem.isCancelamentoPass());
                myStmt.setInt(12, viagem.getCodigoGerente());
                myStmt.execute();
            } else {
                PreparedStatement myStmt = con.prepareStatement
                        ("INSERT INTO registro_viagem(passageiro, veiculo, motorista, origem_viagem, destino_viagem," +
                                "data_hora_inicio, data_hora_fim, forma_pagamento, valor_pagamento, " +
                                "cancelamento_mot, cancelamento_pass) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                myStmt.setString(1, viagem.getPassageiro());
                myStmt.setString(2, viagem.getVeiculo());
                myStmt.setString(3, viagem.getMotorista());
                myStmt.setString(4, viagem.getOrigemViagem());
                myStmt.setString(5, viagem.getDestinoViagem());
                myStmt.setTimestamp(6, viagem.getDataHoraInicio());
                myStmt.setTimestamp(7, viagem.getDataHoraFim());
                myStmt.setString(8, viagem.getFormaPagamento());
                myStmt.setFloat(9, viagem.getValorPagamento());
                myStmt.setBoolean(10, viagem.isCancelamentoMot());
                myStmt.setBoolean(11, viagem.isCancelamentoPass());
                myStmt.execute();
            }
        }




    }

    private static void insertPassageiro(Connection con, PassageiroCollection collection) throws SQLException {
        for (Passageiro passageiro :
                collection.getPassageiros()) {
            PreparedStatement myStmt = con.prepareStatement
                    ("INSERT INTO passageiros(cpf, nome, endereco, telefone, cartao_credito," +
                            "sexo, cidade_origem, email) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            myStmt.setString(1, passageiro.getCpf());
            myStmt.setString(2, passageiro.getNome());
            myStmt.setString(3, passageiro.getEndereco());
            myStmt.setString(4, passageiro.getTelefone());
            myStmt.setString(5, passageiro.getCartaoCredito());
            myStmt.setString(6, passageiro.getSexo());
            myStmt.setString(7, passageiro.getCidadeOrigem());
            myStmt.setString(8, passageiro.getEmail());

            myStmt.execute();
        }


    }

    private static void insertColaborador(Connection con, ColaboradorCollection collection) throws SQLException {
        for (Colaborador colaborador :
                collection.getColaboradores()) {
            PreparedStatement myStmt = con.prepareStatement
                    ("INSERT INTO colaboradores(cpf, nome, endereco, telefone, cnh, conta_bancaria)" +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            myStmt.setString(1, colaborador.getCpf());
            myStmt.setString(2, colaborador.getNome());
            myStmt.setString(3, colaborador.getEndereco());
            myStmt.setString(4, colaborador.getTelefone());
            myStmt.setString(5, colaborador.getCnh());
            myStmt.setInt(6, colaborador.getContaBancaria());

            myStmt.execute();
        }


    }

    private static void insertVeiculo(Connection con, VeiculoCollection collection) throws SQLException {
        for (Veiculo veiculo :
                collection.getVeiculos()) {
            PreparedStatement myStmt = con.prepareStatement
                    ("INSERT INTO veiculos(placa, marca, modelo, ano_fabricacao, " +
                            "capacidade, cor, tipo_combustivel, potencia_motor)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            myStmt.setString(1, veiculo.getPlaca());
            myStmt.setString(2, veiculo.getMarca());
            myStmt.setString(3, veiculo.getModelo());
            myStmt.setInt(4, veiculo.getAnoFabricacao());
            myStmt.setInt(5, veiculo.getCapacidade());
            myStmt.setString(6, veiculo.getCor());
            myStmt.setString(7, veiculo.getTipoCombustivel());
            myStmt.setFloat(8, veiculo.getPotenciaMotor());

            myStmt.execute();
        }


    }

    private static void insertColaboradorProprietario(Connection con, ProprietarioCollection collection) throws SQLException {
        for (ColaboradorProprietario proprietario :
                collection.getProprietarios()) {
            PreparedStatement myStmt = con.prepareStatement
                    ("INSERT INTO colaborador_proprietario(proprietario, veiculo) VALUES (?, ?)");
            myStmt.setString(1, proprietario.getCpfProprietario());
            myStmt.setString(2, proprietario.getPlacaVeiculo());

            myStmt.execute();
        }


    }

    private static void insertColaboradorMotorista(Connection con, MotoristaCollection collection) throws SQLException {
        for (ColaboradorMotorista motorista :
                collection.getMotoristas()) {
            PreparedStatement myStmt = con.prepareStatement
                    ("INSERT INTO colaborador_motorista(motorista, veiculo) VALUES (?, ?)");
            myStmt.setString(1, motorista.getMotorista());
            myStmt.setString(2, motorista.getVeiculo());

            myStmt.execute();
        }

    }
}
