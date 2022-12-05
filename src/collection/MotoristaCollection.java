package collection;

import interfaces.CollectionInterface;
import model.ColaboradorMotorista;

import java.util.ArrayList;
import java.util.Collection;

public class MotoristaCollection implements CollectionInterface {
    Collection<ColaboradorMotorista> motoristas = new ArrayList<>();

    @Override
    public void initCollection() {
        ColaboradorMotorista motorista1 = new ColaboradorMotorista("55522211145", "HNC2215");
        ColaboradorMotorista motorista2 = new ColaboradorMotorista("55522211145", "APX9985");
        ColaboradorMotorista motorista3 = new ColaboradorMotorista("22233345761", "BGR9909");
        ColaboradorMotorista motorista4 = new ColaboradorMotorista("22233345761", "APX9985");

        motoristas.add(motorista1);
        motoristas.add(motorista2);
        motoristas.add(motorista3);
        motoristas.add(motorista4);
    }

    public Collection<ColaboradorMotorista> getMotoristas() {
        return motoristas;
    }
}
