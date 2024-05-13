package org.MagicVet.comparator;

import org.MagicVet.model.Pet;

import java.util.Comparator;

public class PetAgeComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet pet1, Pet pet2) {
        return pet1.getAge() - pet2.getAge();
    }
}
