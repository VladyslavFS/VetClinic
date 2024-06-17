package org.MagicVet.component;

import org.MagicVet.Main;
import org.MagicVet.model.Client;
import org.MagicVet.model.Pet;
import org.MagicVet.service.ClientService;
import org.MagicVet.service.PetService;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                registerPets(client);
                System.out.println(client);
            }
        }
    }

    private void registerPets(Client client) {
        boolean continueAddPets = true;
        while(continueAddPets) {
            addPets(client);
            System.out.print("Do you want to add more pets? (y/n): ");
            String answer = Main.SCANNER.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                continueAddPets = false;
            }
        }
    }

    private void addPets(Client client) {
        System.out.println("Adding a new pet.");

        Pet pet = petService.registerNewPet();

        if (pet != null) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added");
        }
    }
}
