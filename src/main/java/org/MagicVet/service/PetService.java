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

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        System.out.print("Sex (male / female): ");
        pet.setSex(Main.SCANNER.nextLine());

        if (type.equals(DOG_TYPE)) {
            System.out.print("Size (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog)pet).setSize(Dog.Size.valueOf(size));
        }

        //in future may be a problem with Scanner if you want use .nextLine() after calling .nextInt()
        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextInt());

        System.out.print("State of health (0-4): " +
                "\n1-Sick" +
                "\n2-Injured" +
                "\n3-Recovering" +
                "\n4-Healthy" +
                "\nEnter 0 if health status is unknown: ");
        int healthStateValue = Main.SCANNER.nextInt();
        Pet.HealthState healthState = Pet.HealthState.fromValue(healthStateValue);
        if (healthState != null) {
            pet.setHealthState(healthState);
        } else {
            System.out.println("Invalid input. Please enter a number between 0 and 4.");
        }


        return pet;
    }
}
