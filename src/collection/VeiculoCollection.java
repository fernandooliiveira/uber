package collection;

import interfaces.CollectionInterface;
import model.Veiculo;

import java.util.ArrayList;
import java.util.Collection;

public class VeiculoCollection implements CollectionInterface {
    Collection<Veiculo> veiculos = new ArrayList<>();

    @Override
    public void initCollection() {
        Veiculo veiculo1 = new Veiculo("BGR9909", "WOLKS", "GOL", 2002,
                5, "Branco", "FLEX", 1.0F);
        Veiculo veiculo2 = new Veiculo("APX9985", "WOLKS", "GOLF", 2010,
                5, "Branco", "FLEX", 1.0F);
        Veiculo veiculo3 = new Veiculo("HNC2215", "HYUNDAI", "HB20", 2020,
                5, "Preto", "FLEX", 1.4F);

        veiculos.add(veiculo1);
        veiculos.add(veiculo2);
        veiculos.add(veiculo3);
    }

    public Collection<Veiculo> getVeiculos() {
        return veiculos;
    }
}
