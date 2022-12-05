package collection;

import interfaces.CollectionInterface;
import model.ColaboradorProprietario;

import java.util.ArrayList;
import java.util.Collection;

public class ProprietarioCollection implements CollectionInterface {
    Collection<ColaboradorProprietario> proprietarios = new ArrayList<>();

    @Override
    public void initCollection() {
        ColaboradorProprietario proprietario1 = new ColaboradorProprietario("44455511125",
                "HNC2215");
        ColaboradorProprietario proprietario2 = new ColaboradorProprietario("85566692354",
                "APX9985");
        ColaboradorProprietario proprietario3 = new ColaboradorProprietario("12233345785",
                "BGR9909");

        proprietarios.add(proprietario1);
        proprietarios.add(proprietario2);
        proprietarios.add(proprietario3);
    }

    public Collection<ColaboradorProprietario> getProprietarios() {
        return proprietarios;
    }
}
