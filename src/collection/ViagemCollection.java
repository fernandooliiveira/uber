package collection;

import interfaces.CollectionInterface;
import model.RegistroViagem;

import java.sql.Timestamp;
import java.time.Instant;
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
    }

    public Collection<RegistroViagem> getViagens() {
        return viagens;
    }
}
