package org.MagicVet.component;

import org.MagicVet.Main;
import org.MagicVet.model.Client;
import org.MagicVet.model.Pet;
import org.MagicVet.service.ClientService;
import org.MagicVet.service.PetService;

public class ApplicationRunner {

    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();
    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if(client != null)
                System.out.println("Add new pet? (yes / no): ");
                if (Main.SCANNER.nextLine().equals("yes")) {
                    System.out.println("Adding a new pet.");

                    Pet pet = petService.registerNewPet();
                    client.setPet(pet);
                    pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                    System.out.println("Pet has been added");
                }
            }
        }
    }
