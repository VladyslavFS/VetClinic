package org.MagicVet;

import org.MagicVet.comparator.DogSizeComparator;
import org.MagicVet.model.Dog;

import java.util.Arrays;

public class SandBox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.XS),
                new Dog(Dog.XL),
                new Dog(Dog.L),
        };
        Arrays.sort(dogs, new DogSizeComparator());

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }
    }
}
