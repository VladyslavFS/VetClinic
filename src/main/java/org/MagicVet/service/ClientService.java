package org.MagicVet.service;

import org.MagicVet.Main;
import org.MagicVet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[A-Z][a-zA-Z'-]{1,}$";

    public Client registerNewClient() {

        Client client = null;

        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();

        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid");
        }

        return client;
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        System.out.print("First name: ");
        String firstName = Main.SCANNER.nextLine();
        while (!isNameValid(firstName)) {
            System.out.print("The name must contain at least 2 letters. The first letter must be in upper case." +
                    "\nPlease try again: ");
            firstName = Main.SCANNER.nextLine();
        }

        client.setFirstName(firstName);

        System.out.print("Last name: ");
        String lastName = Main.SCANNER.nextLine();
        while (!isNameValid(lastName)) {
            System.out.print("The last name must contain at least 2 letters. The first letter must be in upper case." +
                    "\nPlease try again: ");
            lastName = Main.SCANNER.nextLine();
        }
        client.setLastName(lastName);

        System.out.println("Location: ");
        Client.Location location;
        String locationInput = Main.SCANNER.nextLine();
        try {
            location = Client.Location.valueOf(locationInput);
        } catch (IllegalArgumentException e) {
            location = Client.Location.UNKNOWN;
            System.out.println("Invalid location " + locationInput + ". Using default location: " + Client.Location.UNKNOWN);
        }

        client.setLocation(location);

        return  client;
    }

    private static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
