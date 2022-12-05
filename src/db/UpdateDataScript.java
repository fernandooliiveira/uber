package db;

import java.sql.*;
import java.time.Instant;

public class UpdateDataScript {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();
        ListDataScript list = new ListDataScript();

        updateVeiculo(con, list);
        updateColaborador(con, list);
        updateContaBancariaColaborador(con, list);
        updateProprietario(con);
        updateMotorista(con);
        updatePassageiro(con);
        updateRegistroViagem(con);


        con.close();
    }

    private static void updateRegistroViagem(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("UPDATE registro_viagem " +
                        "SET origem_viagem = ?, destino_viagem = ?, data_hora_inicio = ?, data_hora_fim = ? " +
                        "WHERE id = ?");
        myStmt.setString(1, "RUA 40");
        myStmt.setString(2, "RUA 70");
        myStmt.setTimestamp(3, Timestamp.from(Instant.now()));
        myStmt.setTimestamp(4, Timestamp.from(Instant.now()));
        myStmt.setInt(5, 2);

        myStmt.execute();
    }

    private static void updatePassageiro(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("UPDATE passageiros " +
                        "SET cpf = ?, nome = ?, endereco = ?, telefone = ?, cartao_credito = ?," +
                        "sexo = ?, cidade_origem = ?, email = ? " +
                        "WHERE id = ?");
        myStmt.setString(1, "888999444-40");
        myStmt.setString(2, "Thabata Shneyder");
        myStmt.setString(3, "Sonho Verde");
        myStmt.setString(4, "+5562985613474");
        myStmt.setString(5, "1010101010");
        myStmt.setString(6, "FEMININO");
        myStmt.setString(7, "ANAPOLIS");
        myStmt.setString(8, "thabata@email.com");
        myStmt.setInt(9, 1);

        myStmt.execute();
    }

    private static void updateMotorista(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("UPDATE colaborador_motorista " +
                        "SET motorista = ? WHERE id = ?");
        myStmt.setInt(1, 1);
        myStmt.setInt(2, 1);

        myStmt.execute();
    }

    private static void updateProprietario(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("UPDATE colaborador_proprietario " +
                        "SET proprietario = ? WHERE id = ?");
        myStmt.setInt(1, 2);
        myStmt.setInt(2, 1);

        myStmt.execute();
    }

    private static void updateColaborador(Connection con, ListDataScript list) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("UPDATE colaboradores " +
                        "SET cpf = ?, nome = ?, endereco = ?, telefone = ?, cnh = ? " +
                        "WHERE id = ?");
        myStmt.setString(1, "800999364-85");
        myStmt.setString(2, "Jose Da Silva");
        myStmt.setString(3, "Rua serra");
        myStmt.setString(4, "+5561985623478");
        myStmt.setString(5, "102030-40");
        myStmt.setInt(6, 1);

        myStmt.execute();
    }

    private static void updateContaBancariaColaborador(Connection con, ListDataScript list) throws SQLException {

        PreparedStatement myStmt = con.prepareStatement
                ("UPDATE contas_bancaria " +
                        "SET nome_banco = ?, agencia = ?, conta = ? " +
                        "WHERE id = ? RETURNING *");
        myStmt.setString(1, "CAIXA ECONOMICA");
        myStmt.setString(2, "404040");
        myStmt.setString(3, "4444-2");
        myStmt.setInt(4, 1);

        myStmt.execute();
    }

    private static void updateVeiculo(Connection con, ListDataScript list) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("UPDATE veiculos " +
                        "SET placa = ?, marca = ?, modelo = ?, ano_fabricacao = ?," +
                        "capacidade = ?, cor = ?, tipo_combustivel = ?, potencia_motor = ? " +
                        "WHERE id = ? RETURNING *");
        myStmt.setString(1, "NGR9908");
        myStmt.setString(2, "HONDA CIVIC");
        myStmt.setString(3, "2021");
        myStmt.setDate(4, java.sql.Date.valueOf("2019-09-04"));
        myStmt.setInt(5, 5);
        myStmt.setString(6,"PRETO");
        myStmt.setString(7,"FLEX");
        myStmt.setFloat(8, 2.0F);
        myStmt.setInt(9, 1);

        myStmt.execute();
    }
}
