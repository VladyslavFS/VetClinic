package org.MagicVet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner scanner = new Scanner(System.in);

    static  String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }


    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = scanner.nextLine();
            if (input.equals(PASSWORD)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }

        System.out.println(accepted ? "Welcome to the clinic" : "App has been blocked");
        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (isEmailValid(email)) {
            Client client = buildClient(email);
            System.out.println("New client: " + client.name + " " + client.lastName + " (" + client.email + ")");
        } else {
            System.out.println("Provided email is invalid");
        }
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        System.out.print("First name: ");
        client.name = scanner.nextLine();

        System.out.print("Last name: ");
        client.lastName = scanner.nextLine();

        return  client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}