package collection;

import interfaces.CollectionInterface;
import model.RegistroViagem;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class ViagemCollection implements CollectionInterface {

    Collection<RegistroViagem> viagens = new ArrayList<>();

    @Override
    public void initCollection() {
        RegistroViagem viagem1 = new RegistroViagem("70077729196", "BGR9909", "22233345761",
                "Sonho Verde", "Flamboyant", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()),
                "DINHEIRO", 20.50F, false, false);
        RegistroViagem viagem2 = new RegistroViagem("40055566698", "BGR9909", "22233345761",
                "Flamboyant", "Setor Oeste", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()),
                "CRÉDITO", 20.50F, false, false);
        RegistroViagem viagem3 = new RegistroViagem("40055566698", "BGR9909", "22233345761",
                "Flamboyant", "Setor Oeste", Timestamp.from(Instant.now()), Timestamp.from(Instant.now()),
                "CANCELADO", 20.50F, true, false, 1010);

        viagens.add(viagem1);
        viagens.add(viagem2);
        viagens.add(viagem3);

        try {
            RegistroViagem viagem4 = new RegistroViagem("40055566698", "BGR9909", "22233345761",
                    "Flamboyant", "Setor Oeste",
                    Timestamp.from(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-10-03 21:45:00").toInstant()),
                    Timestamp.from(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-10-03 21:48:00").toInstant()),
                    "DINHEIRO", 29.50F, false, false);

            RegistroViagem viagem5 = new RegistroViagem("70077729196", "APX9985", "55522211145",
                    "Sonho Verde", "Riviera",
                    Timestamp.from(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-10-03 21:45:00").toInstant()),
                    Timestamp.from(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-10-03 21:48:00").toInstant()),
                    "DINHEIRO", 40.00F, false, false);

            RegistroViagem viagem6 = new RegistroViagem("66844455523", "HNC2215", "55522211145",
                    "Setor Universitario", "PUC GO",
                    Timestamp.from(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-10-03 22:45:00").toInstant()),
                    Timestamp.from(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-10-03 23:48:00").toInstant()),
                    "DINHEIRO", 18.00F, false, false);
            viagens.add(viagem4);
            viagens.add(viagem5);
            viagens.add(viagem6);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<RegistroViagem> getViagens() {
        return viagens;
    }
}
