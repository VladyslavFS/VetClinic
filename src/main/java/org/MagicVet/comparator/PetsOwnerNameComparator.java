package org.MagicVet.comparator;

import org.MagicVet.model.Pet;

import java.util.Comparator;

public class PetsOwnerNameComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet o1, Pet o2) {
        return o1.getOwnerName().compareTo(o2.getOwnerName());
    }
}
