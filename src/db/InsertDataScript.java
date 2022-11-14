package db;

import java.sql.*;
import java.time.Instant;
import java.util.Objects;

public class InsertDataScript {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

//        insertVeiculo(con);
//        insertColaborador(con);
//        insertColaboradorProprietario(con);
//        insertColaboradorMotorista(con);
//        insertPassageiro(con);
        insertRegistroViagem(con, "CANCELADO");

        con.close();
    }

    private static void insertRegistroViagem(Connection con, String formaPagemento) throws SQLException {
        if (Objects.equals(formaPagemento, "CANCELADO")){
            PreparedStatement myStmt = con.prepareStatement
                    ("INSERT INTO registro_viagem(passageiro, veiculo, motorista, origem_viagem, destino_viagem," +
                            "data_hora_inicio, data_hora_fim, forma_pagamento, codigo_gerente) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            myStmt.setInt(1,1);
            myStmt.setInt(2,1);
            myStmt.setInt(3,2);
            myStmt.setString(4,"RUA 1");
            myStmt.setString(5,"RUA 20");
            myStmt.setTimestamp(6, Timestamp.from(Instant.now()));
            myStmt.setTimestamp(7, Timestamp.from(Instant.now()));
            myStmt.setString(8,formaPagemento);
            myStmt.setInt(9, 1203);
            myStmt.execute();
        } else {
            PreparedStatement myStmt = con.prepareStatement
                    ("INSERT INTO registro_viagem(passageiro, veiculo, motorista, origem_viagem, destino_viagem," +
                            "data_hora_inicio, data_hora_fim, forma_pagamento) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            myStmt.setInt(1,1);
            myStmt.setInt(2,1);
            myStmt.setInt(3,2);
            myStmt.setString(4,"RUA 1");
            myStmt.setString(5,"RUA 20");
            myStmt.setTimestamp(6, Timestamp.from(Instant.now()));
            myStmt.setTimestamp(7, Timestamp.from(Instant.now()));
            myStmt.setString(8,formaPagemento);
            myStmt.execute();
        }


    }

    private static void insertPassageiro(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("INSERT INTO passageiros(cpf, nome, endereco, telefone, cartao_credito," +
                        "sexo, cidade_origem, email) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        myStmt.setString(1,"600666523-96");
        myStmt.setString(2,"Leila Costa");
        myStmt.setString(3,"Rua Quebra");
        myStmt.setString(4,"+5562982941407");
        myStmt.setString(5,"12345678-9");
        myStmt.setString(6,"FEMININO");
        myStmt.setString(7,"GOIANIA");
        myStmt.setString(8,"leila@email.com");

        myStmt.execute();
    }

    private static void insertColaborador(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("INSERT INTO contas_bancaria(nome_banco, agencia, conta)" +
                        "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        myStmt.setString(1,"BANCO DO BRASIL");
        myStmt.setString(2,"12345678-9");
        myStmt.setString(3,"1234-5");

        myStmt.execute();

        ResultSet resultSet = myStmt.getGeneratedKeys();
        Integer id = 0;
        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        myStmt = con.prepareStatement
                ("INSERT INTO colaboradores(cpf, nome, endereco, telefone, cnh, conta_bancaria)" +
                        "VALUES (?, ?, ?, ?, ?, ?)");
        myStmt.setString(1,"700777295-96");
        myStmt.setString(2,"Fernando Costa");
        myStmt.setString(3,"Rua Tal Qd Tal Lt Tal Goiania");
        myStmt.setString(4,"+5562982941407");
        myStmt.setString(5,"12345678-9");
        myStmt.setInt(6, id);

        myStmt.execute();
    }

    private static void insertVeiculo(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("INSERT INTO veiculos(placa, marca, modelo, ano_fabricacao, " +
                        "capacidade, cor, tipo_combustivel, potencia_motor)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        myStmt.setString(1,"NGR9909");
        myStmt.setString(2, "GOL");
        myStmt.setString(3, "G4");
        myStmt.setDate(4, java.sql.Date.valueOf("2013-09-04"));
        myStmt.setInt(5, 5);
        myStmt.setString(6,"BRANCO");
        myStmt.setString(7,"FLEX");
        myStmt.setFloat(8, 1.0F);

        myStmt.execute();
    }

    private static void insertColaboradorProprietario(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("INSERT INTO colaborador_proprietario(proprietario, veiculo) VALUES (?, ?)");
        myStmt.setInt(1, 2);
        myStmt.setInt(2, 1);

        myStmt.execute();
    }

    private static void insertColaboradorMotorista(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("INSERT INTO colaborador_motorista(motorista, veiculo) VALUES (?, ?)");
        myStmt.setInt(1, 1);
        myStmt.setInt(2, 2);

        myStmt.execute();
    }
}
