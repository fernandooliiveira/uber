package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableScript {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

//        createVeiculos(con);
//        createContaBancaria(con);
//        createColaboradores(con);
//        createColaboradorProprietario(con);
//        createColaboradorMotorista(con);
//        createPassageiro(con);
        createRegistroViagem(con);


        con.close();
    }

    private static void createRegistroViagem(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("CREATE TABLE registro_viagem(" +
                "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                "passageiro INT NOT NULL," +
                "veiculo INT NOT NULL," +
                "motorista INT NOT NULL," +
                "origem_viagem VARCHAR(255) NOT NULL," +
                "destino_viagem VARCHAR(255) NOT NULL," +
                "data_hora_inicio TIMESTAMP NOT NULL," +
                "data_hora_fim TIMESTAMP NOT NULL," +
                "forma_pagamento VARCHAR(255) NOT NULL," +
                "codigo_gerente INT," +
                "PRIMARY KEY(id)," +
                "CONSTRAINT fk_passageiro FOREIGN KEY (passageiro) REFERENCES passageiros(id)," +
                "CONSTRAINT fk_veiculo FOREIGN KEY (veiculo) REFERENCES veiculos(id)," +
                "CONSTRAINT fk_motorista FOREIGN KEY (motorista) REFERENCES colaboradores(id));");
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
                "PRIMARY KEY (id));");
        myStmt.execute();
    }

    private static void createContaBancaria(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("CREATE TABLE contas_bancaria(" +
                "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                "nome_banco VARCHAR(255) NOT NULL," +
                "agencia VARCHAR(255) NOT NULL," +
                "conta VARCHAR(255) NOT NULL," +
                "PRIMARY KEY (id));");
        myStmt.execute();
    }

    private static void createColaboradores(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("CREATE TABLE colaboradores(" +
                "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                "cpf VARCHAR(255) UNIQUE NOT NULL," +
                "nome VARCHAR(255) NOT NULL," +
                "endereco VARCHAR(255) NOT NULL," +
                "telefone VARCHAR(255) NOT NULL," +
                "cnh VARCHAR(255) NOT NULL," +
                "conta_bancaria INT NOT NULL," +
                "PRIMARY KEY (id)," +
                "CONSTRAINT fk_conta_bancaria " +
                "FOREIGN KEY(conta_bancaria) " +
                "REFERENCES contas_bancaria(id) ON DELETE CASCADE);");
        myStmt.execute();
    }

    private static void createVeiculos(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("CREATE TABLE veiculos(" +
                        "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                        "placa VARCHAR(50) UNIQUE NOT NULL," +
                        "marca VARCHAR(255) NOT NULL," +
                        "modelo VARCHAR(255) NOT NULL," +
                        "ano_fabricacao DATE NOT NULL," +
                        "capacidade SMALLINT NOT NULL," +
                        "cor VARCHAR(50) NOT NULL," +
                        "tipo_combustivel VARCHAR(50) NOT NULL," +
                        "potencia_motor REAL NOT NULL," +
                        "PRIMARY KEY(id));");


        myStmt.execute();
    }

    private static void createColaboradorProprietario(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("CREATE TABLE colaborador_proprietario(" +
                        "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                        "proprietario INT NOT NULL," +
                        "veiculo INT NOT NULL UNIQUE," +
                        "PRIMARY KEY (id)," +
                        "CONSTRAINT fk_proprietario FOREIGN KEY(proprietario) REFERENCES colaboradores(id) ON UPDATE CASCADE," +
                        "CONSTRAINT fk_veiculo FOREIGN KEY(veiculo) REFERENCES veiculos(id) ON UPDATE CASCADE);");


        myStmt.execute();
    }

    private static void createColaboradorMotorista(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("CREATE TABLE colaborador_motorista(" +
                        "id INT GENERATED ALWAYS AS IDENTITY UNIQUE," +
                        "motorista INT NOT NULL," +
                        "veiculo INT NOT NULL," +
                        "PRIMARY KEY (id)," +
                        "CONSTRAINT fk_motorista FOREIGN KEY(motorista) REFERENCES colaboradores(id) ON UPDATE CASCADE," +
                        "CONSTRAINT fk_veiculo FOREIGN KEY(veiculo) REFERENCES veiculos(id) ON UPDATE CASCADE);");


        myStmt.execute();
    }
}
