package interfaces;

import java.sql.SQLException;

public interface ServicesInterface {
    public void getViagensByCar(String marca) throws SQLException;
    public void getMaioresFaturamentos(String mes)  throws SQLException;

    public void getFaturamentoVeiculo()  throws SQLException;

    public void getMediaMensal(String mes)  throws SQLException;
}
