package org.MagicVet;

import org.MagicVet.model.Dog;
import java.util.Arrays;
import java.util.Comparator;

public class SandBox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Size.L,"Barsik"),
                new Dog(Dog.Size.M, "Zolf"),
                new Dog(Dog.Size.S,"Momo"),
                new Dog(Dog.Size.XL,"Arnold"),
                new Dog(Dog.Size.S,"Oleg"),
        };
        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });

        for (Dog dog : dogs) {
            System.out.println(dog.getName() + " " + dog.getSize());
        }
    }
}
