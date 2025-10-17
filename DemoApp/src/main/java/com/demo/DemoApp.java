package com.demo;

import com.lib.PasswordGenerator;
import com.lib.PasswordHasher;
import com.lib.UserInput;
import java.util.Scanner;

public class DemoApp {
    static UserInput user = new UserInput();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. HashPassword");
            System.out.println("4. Generate Password and Hash");
            System.out.println("0. Exit");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    hashPassword();
                    break;
                case 4:
                    hashGeneratedPassword();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Input error!");
            }
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                System.out.print("Choose the option: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private static void register() throws Exception {
        System.out.println("1. Register");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        user.registerUser(username, password);
        System.out.println("User " + username + " successfully registered!");
    }

    private static void login() throws Exception {
        System.out.println("1. Login");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (user.authenticateUser(username, password)) {
            System.out.println("User " + username + " successfully logged in!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    private static void hashPassword() throws Exception {
        System.out.println("1. Hash Password");
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        String hash = PasswordHasher.hashPassword(password);
        System.out.println("Hash: " + hash);

        String salt = PasswordHasher.generateSalt();
        System.out.println("Generated salt: " + salt);


        String hashWithSalt = PasswordHasher.hashPasswordWithGeneratedSalt(password);
        System.out.println("Hash with salt: " + hashWithSalt);

        String anotherHashWithSalt = PasswordHasher.hashPasswordWithGeneratedSalt(password);
        System.out.println("Another hash with salt: " + anotherHashWithSalt);

        if (PasswordHasher.checkPassword(password, hashWithSalt)) {
            System.out.println("Password verified!");
        } else {
            System.out.println("Invalid password!");
        }

        if (hashWithSalt.equals(anotherHashWithSalt)) {
            System.out.println("Error! Hashes are the same!");
        } else {
            System.out.println("Correct! Hashes are not the same.");
        }
    }

    public static void hashGeneratedPassword() throws Exception {
        System.out.println("4. Generate Password and Hash");
        String generatedPassword =  PasswordGenerator.generatePassword();
        String hashWithSalt = PasswordHasher.hashPasswordWithGeneratedSalt(generatedPassword);
        System.out.println("Generated password: " + generatedPassword);
        System.out.println("Hash with salt: " + hashWithSalt);
    }
}


