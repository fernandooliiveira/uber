package db;

import java.sql.*;

public class ListDataScript {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

        getAllVeiculos(con);
        getAllColaboradores(con);
        getAllProprietarios(con);
        getAllMotoristas(con);
        getAllRegistroViagem(con);

        con.close();
    }

    private static void getAllRegistroViagem(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("select p.cpf, v.placa, c.cpf, rv.origem_viagem, rv.destino_viagem, rv.data_hora_inicio," +
                        "rv.data_hora_fim, rv.forma_pagamento, rv.codigo_gerente " +
                        "from registro_viagem rv \n" +
                        "inner join passageiros p on rv.passageiro = p.id " +
                        "inner join veiculos v on rv.veiculo = v.id " +
                        "inner join colaboradores c on rv.motorista = c.id order by rv.id");

        myStmt.execute();
        ResultSet resultSet = myStmt.getResultSet();
        while (resultSet.next()) {
            String cpfPassageiro = resultSet.getString(1);
            String placa = resultSet.getString(2);
            String cpfMotorista = resultSet.getString(3);
            String origemViagem = resultSet.getString(4);
            String destinoViagem = resultSet.getString(5);
            Timestamp dataHoraInicio = resultSet.getTimestamp(6);
            Timestamp dataHoraFim = resultSet.getTimestamp(7);
            String formaPagamento = resultSet.getString(8);
            Integer codigoGerente = null;
            try {
                codigoGerente = resultSet.getInt(9);
            } catch (Exception e) {

            }
            System.out.println("-------------------------------------------");
            System.out.println("CPF PASSAGEIRO: " + cpfPassageiro + " | PLACA: " + placa + " | CPF MOTORISTA: "
                    + cpfMotorista);
            System.out.println("ORIGEM VIAGEM: " + origemViagem + " | DESTINO VIAGEM: " + destinoViagem +
                    " | DATA HORA INICIO: " + dataHoraInicio);
            System.out.println("DATA HORA FIM: " + dataHoraFim + " | FORMA PAGAMENTO: " + formaPagamento +
                    " | CODIGO GERENTE: " + codigoGerente);
        }
    }

    private static void getAllMotoristas(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("SELECT c.nome, c.cpf, v.placa, v.marca FROM colaborador_motorista cm " +
                        "INNER JOIN colaboradores c ON cm.motorista = c.id " +
                        "LEFT JOIN veiculos v ON cm.veiculo = v.id ");
        myStmt.execute();
        ResultSet resultSet = myStmt.getResultSet();
        listProprietariosAndMotoristas(resultSet);
    }

    private static void getAllProprietarios(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("SELECT c.nome, c.cpf, v.placa, v.marca FROM colaborador_proprietario cp " +
                        "INNER JOIN colaboradores c ON cp.proprietario = c.id " +
                        "LEFT JOIN veiculos v ON cp.veiculo = v.id ");
        myStmt.execute();
        ResultSet resultSet = myStmt.getResultSet();
        listProprietariosAndMotoristas(resultSet);
    }

    private static void listProprietariosAndMotoristas(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            String placa = resultSet.getString("placa");
            String marca = resultSet.getString("marca");
            System.out.println("-------------------------------------------");
            System.out.println("NOME PROPRIETARIO: " + nome + " | CPF: " + cpf + " | PLACA: " + placa + " | MARCA: " + marca);
        }
    }

    private static void getAllColaboradores(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("SELECT * FROM colaboradores AS v INNER JOIN contas_bancaria AS c ON v.id = c.id");

        myStmt.execute();
        ResultSet resultSet = myStmt.getResultSet();
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String cpf = resultSet.getString(2);
            String nome = resultSet.getString(3);
            String endereco = resultSet.getString(4);
            String telefone = resultSet.getString(5);
            String cnh = resultSet.getString(6);
            String nomeBanco = resultSet.getString(9);
            String agencia = resultSet.getString(10);
            String conta = resultSet.getString(11);
            System.out.println("-------------------------------------------");
            System.out.println("ID: " + id + " | CPF: " + cpf + " | NOME: " + nome);
            System.out.println("ENDERECO: " + endereco + " | TELEFONE: " + telefone + " | CNH: " + cnh);
            System.out.println("NOME BANCO: " + nomeBanco + " | AGENCIA: " + agencia + " | CONTA: " + conta);
        }
    }

    private static void getAllVeiculos(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement
                ("SELECT * FROM veiculos");

        myStmt.execute();

        ResultSet resultSet = myStmt.getResultSet();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String placa = resultSet.getString("placa");
            String marca = resultSet.getString("marca");
            String modelo = resultSet.getString("modelo");
            Date anoFabricacao = resultSet.getDate("ano_fabricacao");
            Integer capacidade = resultSet.getInt("capacidade");
            String cor = resultSet.getString("cor");
            String tipoCombustivel = resultSet.getString("tipo_combustivel");
            Float potenciaMotor = resultSet.getFloat("potencia_motor");

            System.out.println("-------------------------------------------");
            System.out.println("ID: " + id + " | PLACA: " + placa + " | MARCA: " + marca);
            System.out.println("MODELO: " + modelo + " | ANO FABRICACAO: " + anoFabricacao + " | CAPACIDADE: " + capacidade);
            System.out.println("COR: " + cor + " | TIPO COMBUSTIVEL: " + tipoCombustivel + " | POTENCIA MOTOR: " + potenciaMotor);
        }
    }





}
