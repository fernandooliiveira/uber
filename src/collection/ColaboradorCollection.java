package collection;

import interfaces.CollectionInterface;
import model.Colaborador;

import java.util.ArrayList;
import java.util.Collection;

public class ColaboradorCollection implements CollectionInterface {
    Collection<Colaborador> colaboradores = new ArrayList<>();

    @Override
    public void initCollection() {
        Colaborador colaborador1 = new Colaborador("44455511125", "Roberto Andrade", "Rua X QD Y",
                "62984523695", "22233-9", 2222);
        Colaborador colaborador2 = new Colaborador("55522211145", "Jessica Martins", "Rua X QD Y",
                "62984523695", "22233-9", 1111);
        Colaborador colaborador3 = new Colaborador("22233345761", "Jośe Costa", "Rua X QD Y",
                "62984523695", "22233-9", 2222);

        colaboradores.add(colaborador1);
        colaboradores.add(colaborador2);
        colaboradores.add(colaborador3);
    }

    public Collection<Colaborador> getColaboradores() {
        return colaboradores;
    }
}
