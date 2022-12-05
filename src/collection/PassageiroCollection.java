package collection;

import interfaces.CollectionInterface;
import model.Passageiro;

import java.util.ArrayList;
import java.util.Collection;

public class PassageiroCollection implements CollectionInterface {
    Collection<Passageiro> passageiros = new ArrayList<>();

    @Override
    public void initCollection() {
        Passageiro passageiro1 = new Passageiro("70077729196", "Fernando Costa", "Rua x qd 12 lt 13",
                "62982941407", "4444", "Masculino", "Goiania",
                "fernando@email.com");
        Passageiro passageiro2 = new Passageiro("40055566698", "Ana Costa", "Rua x qd 12 lt 13",
                "62982941407", "5555", "Feminino", "São Paulo",
                "ana@email.com");
        Passageiro passageiro3 = new Passageiro("66844455523", "Marcelo Carlos", "Rua x qd 12 lt 13",
                "62982941407", "9999", "Masculino", "Rio de Janeiro",
                "marcelo@email.com");

        passageiros.add(passageiro1);
        passageiros.add(passageiro2);
        passageiros.add(passageiro3);
    }

    public Collection<Passageiro> getPassageiros() {
        return passageiros;
    }


}
