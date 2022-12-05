package services;

import db.ConnectionFactory;
import interfaces.ServicesInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Services implements ServicesInterface {

    @Override
    public void getViagensByCar(String marca) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

        PreparedStatement myStmt = con.prepareStatement("SELECT v.marca, v.placa, rv.origem_viagem, " +
                "rv.destino_viagem, p.nome FROM registro_viagem rv " +
                "INNER JOIN veiculos v ON v.placa = rv.veiculo " +
                "INNER JOIN passageiros p ON rv.passageiro = p.cpf " +
                "WHERE rv.data_hora_inicio BETWEEN '2022-10-03 21:00:00.000' AND " +
                "'2022-10-04 00:00:00.000' AND v.marca = '" + marca + "'");

        myStmt.execute();
        ResultSet resultSet = myStmt.getResultSet();
        System.out.println("-------------------------------------");
        while (resultSet.next()) {
            String marcaVeiculo = resultSet.getString(1);
            String placa = resultSet.getString(2);
            String origemViagem = resultSet.getString(3);
            String destinoViagem = resultSet.getString(4);
            String nome = resultSet.getString(5);

            System.out.println("MARCA: " + marcaVeiculo +  " | PLACA: " + placa + "" +
                    " | ORIGEM: " + origemViagem + " | DESTINO: " + destinoViagem + "" +
                    " | NOME: " + nome);;
        }
        System.out.println("-------------------------------------");
        con.close();
    }

    @Override
    public void getMaioresFaturamentos(String mes) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

        PreparedStatement myStmt = con.prepareStatement("SELECT valor_pagamento FROM registro_viagem " +
                "WHERE EXTRACT(MONTH FROM data_hora_inicio) = '" + mes + "' " +
                "ORDER BY valor_pagamento DESC LIMIT 20;");

        myStmt.execute();
        ResultSet resultSet = myStmt.getResultSet();
        System.out.println("-------------------------------------");
        while (resultSet.next()) {
            Float valores = resultSet.getFloat(1);
            System.out.println("MARCA: " + valores);;
        }
        System.out.println("-------------------------------------");
        con.close();
    }

    @Override
    public void getFaturamentoVeiculo() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

        PreparedStatement myStmt = con.prepareStatement("SELECT c.nome, v.placa, sum(rv.valor_pagamento) AS total, avg(rv.valor_pagamento) AS media " +
                "from registro_viagem rv " +
                "INNER JOIN colaborador_proprietario cp ON rv.veiculo = cp.veiculo " +
                "INNER JOIN colaboradores c ON cp.proprietario = c.cpf " +
                "INNER JOIN veiculos v ON rv.veiculo = v.placa " +
                "GROUP BY rv.veiculo, c.nome, v.placa");

        myStmt.execute();
        ResultSet resultSet = myStmt.getResultSet();
        System.out.println("-------------------------------------");
        while (resultSet.next()) {
            String nome = resultSet.getString(1);
            String placa = resultSet.getString(2);
            Float total = resultSet.getFloat(3);
            Float media = resultSet.getFloat(4);
            System.out.println("NOME: " + nome + " | PLACA: " + placa + " | TOTAL: " + total + " | MEDIA: " + media);
        }
        System.out.println("-------------------------------------");
        con.close();
    }

    @Override
    public void getMediaMensal(String mes) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

        PreparedStatement myStmt = con.prepareStatement("SELECT COUNT(p.sexo), p.sexo FROM registro_viagem rv " +
                "INNER JOIN passageiros p ON rv.passageiro = p.cpf " +
                "WHERE EXTRACT(MONTH FROM data_hora_inicio) = '" + mes + "' " +
                "GROUP BY p.sexo ");

        myStmt.execute();
        ResultSet resultSet = myStmt.getResultSet();
        System.out.println("-------------------------------------");
        while (resultSet.next()) {
            Integer count = resultSet.getInt(1);
            String sexo = resultSet.getString(2);
            System.out.println("COUNT: " + count + " | SEXO: " + sexo);;
        }
        System.out.println("-------------------------------------");
        con.close();
    }
}
