package org.MagicVet.service;

import org.MagicVet.Main;
import org.MagicVet.model.Cat;
import org.MagicVet.model.Dog;
import org.MagicVet.model.Pet;

public class PetService {
    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Pet registerNewPet() {
        Pet pet = null;
        System.out.println("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();
        pet.setType(type);

        if (DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }
        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(DOG_TYPE) ? new Dog() : new Cat();
        pet.setType(type);

        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        System.out.print("Sex (male / female): ");
        pet.setSex(Main.SCANNER.nextLine());

        if (type.equals(DOG_TYPE)) {
            System.out.print("Size (XS / S / M / L / XL): ");
            ((Dog)pet).setSize(Main.SCANNER.nextLine());
        }
        return pet;
    }
}
