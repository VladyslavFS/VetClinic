package org.MagicVet;

import java.util.Scanner;

public class Main {

    static String PASSWORD = "default";
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        run();
    }

    static void run() {
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
    }
}