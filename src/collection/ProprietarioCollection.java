package collection;

import interfaces.CollectionInterface;
import model.ColaboradorProprietario;

import java.util.ArrayList;
import java.util.Collection;

public class ProprietarioCollection implements CollectionInterface {
    Collection<ColaboradorProprietario> proprietarios = new ArrayList<>();

    @Override
    public void initCollection() {
        ColaboradorProprietario proprietario = new ColaboradorProprietario("44455511125",
                "HNC2215");

        proprietarios.add(proprietario);
    }

    public Collection<ColaboradorProprietario> getProprietarios() {
        return proprietarios;
    }
}
