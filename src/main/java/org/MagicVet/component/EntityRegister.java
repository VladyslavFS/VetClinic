package org.MagicVet.component;

import org.MagicVet.Main;
import org.MagicVet.model.Client;
import org.MagicVet.model.Pet;
import org.MagicVet.service.ClientService;
import org.MagicVet.service.PetService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void registerClients() {

        List<Client> clients = new ArrayList<Client>();

        String message = "Do you want to register more clients? (y/n): ";
        do {
            Client client = addClient();
            if (client != null) {
                clients.add(client);
            }
        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = groupClients(clients);
        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content = "\nLocation: " + clients.getKey()
                    + "\nClients (" + clients.getValue().size() + "):" +
                    "\n\t" + clients.getValue();
            System.out.println(content);
        }
    }

    private Map<Client.Location, List<Client>> groupClients(List<Client> clients) {
        List<Client> fromKyiv = new ArrayList<>();
        List<Client> fromLviv = new ArrayList<>();
        List<Client> fromTernopil = new ArrayList<>();
        List<Client> unknown = new ArrayList<>();

        for(Client client : clients) {
            switch (client.getLocation()) {
                case KYIV:
                    fromKyiv.add(client);
                    break;
                case LVIV:
                    fromLviv.add(client);
                    break;
                case TERNOPIL:
                    fromTernopil.add(client);
                    break;
                case UNKNOWN:
                    unknown.add(client);
                    break;
            }
        }

        Map<Client.Location, List<Client>> clientsByLocation = new HashMap<>();
        clientsByLocation.put(Client.Location.KYIV, fromKyiv);
        clientsByLocation.put(Client.Location.LVIV, fromLviv);
        clientsByLocation.put(Client.Location.TERNOPIL, fromTernopil);
        clientsByLocation.put(Client.Location.UNKNOWN, unknown);

        return clientsByLocation;
    }

    private Client addClient() {
        Client client = clientService.registerNewClient();
        if (client != null) {
            registerPets(client);
            System.out.println(client);
        }

        return client;
    }

    private void registerPets(Client client) {
        String message = "Do you want to register pets? (y/n): ";
         do {
            addPets(client);
        } while (verifyRepeating(message));
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

    private boolean verifyRepeating(String message) {
        System.out.println(message);
        
        String answer = Main.SCANNER.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            return true;
        } else if (answer.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Invalid input. Try again.");
            return verifyRepeating(message);
        }
    }
}
