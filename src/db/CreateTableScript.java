package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableScript {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

//        createPassageiro(con);
//        createColaboradores(con);
//        createVeiculos(con);
//        createColaboradorProprietario(con);
//        createColaboradorMotorista(con);
        createRegistroViagem(con);

        con.close();
    }

    private static void createRegistroViagem(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("CREATE TABLE registro_viagem(" +
                "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                "passageiro VARCHAR(255) NOT NULL," +
                "veiculo VARCHAR(255) NOT NULL," +
                "motorista VARCHAR(255) NOT NULL," +
                "origem_viagem VARCHAR(255) NOT NULL," +
                "destino_viagem VARCHAR(255) NOT NULL," +
                "data_hora_inicio TIMESTAMP NOT NULL," +
                "data_hora_fim TIMESTAMP NOT NULL," +
                "forma_pagamento VARCHAR(255) NOT NULL," +
                "valor_pagamento REAL NOT NULL," +
                "cancelamento_mot BOOLEAN NOT NULL," +
                "cancelamento_pass BOOLEAN NOT NULL," +
                "codigo_gerente INT," +
                "PRIMARY KEY(id)," +
                "CONSTRAINT fk_passageiro FOREIGN KEY (passageiro) REFERENCES passageiros(cpf)," +
                "CONSTRAINT fk_veiculo FOREIGN KEY (veiculo) REFERENCES veiculos(placa)," +
                "CONSTRAINT fk_motorista FOREIGN KEY (motorista) REFERENCES colaboradores(cpf));");
        myStmt.execute();
    }

    private static void createPassageiro(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("CREATE TABLE passageiros(" +
                "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                "cpf VARCHAR(255) NOT NULL," +
                "nome VARCHAR(255) NOT NULL," +
                "endereco VARCHAR(255) NOT NULL," +
                "telefone VARCHAR(255) NOT NULL," +
                "cartao_credito VARCHAR(255) NOT NULL," +
                "sexo VARCHAR(50) NOT NULL," +
                "cidade_origem VARCHAR(255) NOT NULL," +
                "email VARCHAR(255) NOT NULL," +
                "PRIMARY KEY (cpf));");
        myStmt.execute();
    }
//
//    private static void createContaBancaria(Connection con) throws SQLException {
//        PreparedStatement myStmt = con.prepareStatement("CREATE TABLE contas_bancaria(" +
//                "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
//                "nome_banco VARCHAR(255) NOT NULL," +
//                "agencia VARCHAR(255) NOT NULL," +
//                "conta VARCHAR(255) NOT NULL," +
//                "PRIMARY KEY (id));");
//        myStmt.execute();
//    }

    private static void createColaboradores(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("CREATE TABLE colaboradores(" +
                "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                "cpf VARCHAR(255) UNIQUE NOT NULL," +
                "nome VARCHAR(255) NOT NULL," +
                "endereco VARCHAR(255) NOT NULL," +
                "telefone VARCHAR(255) NOT NULL," +
                "cnh VARCHAR(255) NOT NULL," +
                "conta_bancaria INT NOT NULL," +
                "PRIMARY KEY (cpf));");
        myStmt.execute();
    }

    private static void createVeiculos(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("CREATE TABLE veiculos(" +
                        "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                        "placa VARCHAR(50) UNIQUE NOT NULL," +
                        "marca VARCHAR(255) NOT NULL," +
                        "modelo VARCHAR(255) NOT NULL," +
                        "ano_fabricacao INT NOT NULL," +
                        "capacidade SMALLINT NOT NULL," +
                        "cor VARCHAR(50) NOT NULL," +
                        "tipo_combustivel VARCHAR(50) NOT NULL," +
                        "potencia_motor REAL NOT NULL," +
                        "PRIMARY KEY(placa));");


        myStmt.execute();
    }

    private static void createColaboradorProprietario(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("CREATE TABLE colaborador_proprietario(" +
                        "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                        "proprietario VARCHAR(255) NOT NULL," +
                        "veiculo VARCHAR(255) NOT NULL UNIQUE," +
                        "PRIMARY KEY (id)," +
                        "CONSTRAINT fk_proprietario FOREIGN KEY(proprietario) REFERENCES colaboradores(cpf) ON UPDATE CASCADE," +
                        "CONSTRAINT fk_veiculo FOREIGN KEY(veiculo) REFERENCES veiculos(placa) ON UPDATE CASCADE);");


        myStmt.execute();
    }

    private static void createColaboradorMotorista(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("CREATE TABLE colaborador_motorista(" +
                        "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                        "motorista VARCHAR(255) NOT NULL," +
                        "veiculo VARCHAR(255) NOT NULL," +
                        "PRIMARY KEY (id)," +
                        "CONSTRAINT fk_motorista FOREIGN KEY(motorista) REFERENCES colaboradores(cpf) ON UPDATE CASCADE," +
                        "CONSTRAINT fk_veiculo FOREIGN KEY(veiculo) REFERENCES veiculos(placa) ON UPDATE CASCADE);");


        myStmt.execute();
    }
}
