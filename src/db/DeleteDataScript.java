package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataScript {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.createConnect();

//        deleteVeiculo(con);
//        deleteContasBancarias(con);
//        deleteColaborador(con);
//        deleteProprietario(con);
//        deleteMotorista(con);
//        deletePassageiro(con);
//        deleteRegistro(con);
        con.close();

    }

    private static void deleteRegistro(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("DELETE FROM registro_viagem WHERE id = ?");
        myStmt.setInt(1, 1);

        myStmt.execute();
    }

    private static void deletePassageiro(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("DELETE FROM passageiros WHERE id = ?");
        myStmt.setInt(1, 1);

        myStmt.execute();
    }

    private static void deleteMotorista(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("DELETE FROM colaborador_motorista WHERE id = ?");
        myStmt.setInt(1, 1);

        myStmt.execute();
    }

    private static void deleteProprietario(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("DELETE FROM colaborador_proprietario WHERE id = ?");
        myStmt.setInt(1, 1);

        myStmt.execute();
    }

    private static void deleteContasBancarias(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("DELETE FROM contas_bancaria WHERE id = ?");
        myStmt.setInt(1, 1);

        myStmt.execute();
    }

    private static void deleteColaborador(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("DELETE FROM colaboradores WHERE id = ?");
        myStmt.setInt(1, 1);

        myStmt.execute();
    }

    private static void deleteVeiculo(Connection con) throws SQLException {
        PreparedStatement myStmt = con.prepareStatement("DELETE FROM veiculos WHERE id = ?");
        myStmt.setInt(1, 1);

        myStmt.execute();
    }
}
