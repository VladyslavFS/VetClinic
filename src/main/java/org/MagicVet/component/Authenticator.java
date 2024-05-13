package org.MagicVet.component;

import org.MagicVet.Main;

public class Authenticator {

    private static final String PASSWORD = "d";

    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = Main.SCANNER.nextLine();

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
}
