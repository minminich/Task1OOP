package com.lib;

import java.util.Scanner;

public class Main {

    //checkLogin
    //тесты для методов
    //сделать проверку на хэш одинаковых паролей в checkPassword


    public static void main(String[] args) throws Exception {
        /*Scanner scanner = new Scanner(System.in);
        //String password =  scanner.next();
        System.out.print("Введите логин: ");
        String login = scanner.next();
        System.out.print("Введите пароль: ");
        String input = scanner.next();
        String input_again = "minminich";
        System.out.println(login + input);
        System.out.println("SHA-256 Hash: " + hashWithSHA256(input));
        System.out.println(login + "SHA-256 Hash: " + hashWithSHA256(input));
        System.out.println("SHA-256 Hash: " + hashWithSHA256(input_again));*/

//
//        System.out.println(getSalt());
//        System.out.println(generateSalt());
//        System.out.println(generateSalt());
//        System.out.println("----------------");
//        System.out.println(generatePassword());
//        System.out.println(generatePassword());
//        System.out.println(generatePassword());
//        System.out.println("----------------");
//        String password = generatePassword();
//        System.out.println(password);
//        System.out.println(Hash.hashPassword(password));
//        System.out.println(Hash.hashPassword(password));
//        System.out.println(Hash.hashPasswordWithSalt(password));\

//        System.out.println("Enter password: ");
        Scanner scanner = new Scanner(System.in);
//        String password = scanner.nextLine();
//        String passwordHash = "miniminich";
//        String storedHash = main.java.passwordmanager.PasswordHasher.hashPassword(password);
//        System.out.println("Hashed password: " + storedHash);
//        main.java.passwordmanager.PasswordHasher.checkPasswordWithoutSalt(passwordHash, storedHash);

        UserInput passwordManager = new UserInput();

        System.out.println(PasswordHasher.generateSalt());

        System.out.print("Input username: ");
        String username = scanner.nextLine();

        System.out.print("Input password: ");
        String password = scanner.nextLine();

        passwordManager.registerUser(username, password);
        System.out.println("User " + username + "successfully registered");
        System.out.println(PasswordHasher.hashPassword(password));

        System.out.print("Input username: ");
        String usernameIn = scanner.nextLine();

        System.out.print("Input password: ");
        String passwordIn = scanner.nextLine();
        System.out.println(PasswordHasher.hashPassword(passwordIn));

        if (passwordManager.authenticateUser(usernameIn, passwordIn)) {
                System.out.println("User " + username + " successfully authenticated");
        } else {
                System.out.println("User or password are incorrect");
        }


        }
    }

