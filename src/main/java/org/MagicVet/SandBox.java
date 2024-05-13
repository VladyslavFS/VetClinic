package org.MagicVet;

import org.MagicVet.comparator.DogSizeComparator;
import org.MagicVet.comparator.PetAgeComparator;
import org.MagicVet.comparator.PetNameComparator;
import org.MagicVet.comparator.PetsOwnerNameComparator;
import org.MagicVet.model.Dog;

import java.util.Arrays;

public class SandBox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.L,"Barsik"),
                new Dog(Dog.M, "Zolf"),
                new Dog(Dog.S,"Momo"),
                new Dog(Dog.XL,"Arnold"),
                new Dog(Dog.S,"Oleg"),
        };
        Arrays.sort(dogs, new DogSizeComparator());

        for (Dog dog : dogs) {
            System.out.println(dog.getName() + " " + dog.getSize());
        }
    }
}
