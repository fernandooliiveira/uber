import services.Services;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Services services  = new Services();
        services.getViagensByCar("HYUNDAI");
        services.getViagensByCar("WOLKS");
        services.getMaioresFaturamentos("10");
        services.getMediaMensal("10");
        services.getFaturamentoVeiculo();
    }
}
