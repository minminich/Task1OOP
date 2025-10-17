package com.min;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHasher {
    public static final int SALT_LENGTH = 16;

    private PasswordHasher() {
    }

    public static String hashPassword(String data) throws NoSuchAlgorithmException {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Data can't be null or empty");
        }
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());
        return toString(hashBytes);
    }

    public static String hashPasswordWithGeneratedSalt(String password) throws NoSuchAlgorithmException {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password can't be null or empty");
        }
        String salt = generateSalt();
        String hash = hashPassword(salt + password);
        return salt + hash;
    }

//    public static String hashPasswordWithSalt(String password) throws Exception {
//        String salt = generateSalt();
//        String saltedPassword = salt + password;
//        String hash = hashPassword(saltedPassword);
//        return salt + hash;
//    }

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return toString(salt);
    }

    private static String toString(byte[] hashBytes) {
        if (hashBytes == null) {
            throw new IllegalArgumentException("Hash bytes can't be null");
        }
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

//    private static String hashForCheck (String storedHash){
//        StringBuilder sb = new StringBuilder(storedHash);
//        sb.delete(0, SALT_LENGTH);
//        return sb.toString();
//    }


    public static boolean checkPassword(String password, String storedHash) throws Exception {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password can't be null or empty");
        }
        if (storedHash == null || storedHash.length() != (SALT_LENGTH * 2 + 64)) {
            throw new IllegalArgumentException("Hash is incorrect");
        }
        String salt = storedHash.substring(0, SALT_LENGTH * 2);
//        String saltedPassword = salt + password;
        String hashedPassword = hashPassword(salt + password);
        String hashedPasswordWithSalt = salt + hashedPassword;

        return hashedPasswordWithSalt.equals(storedHash);
    }
}


//        if (!hashedPassword.equals(storedHash)) {
////            throw new Exception("Password does not match stored hash");
//            System.out.println("Password does not match stored hash");
//        } else {
//            System.out.println("Password verified");
//        }
//        return false;


//    public static void checkPasswordWithoutSalt(String password, String storedHash) throws Exception {
//        String hashedPassword = hashPassword(password);
//        if (!(hashedPassword.equals(storedHash))) {
//            throw new Exception("Password does not match stored hash");
//        } else {
//            System.out.println("Password verified");
//        }
//    }
//}




//    public String getSalt(){
//        return generateSalt();
//    }
//    public String getHashedPassword(String data) throws Exception {
//        return hashPassword(data);
//    }
//    public String getHashedPasswordWithSalt(String data) throws Exception {
//        return hashPassword(data);
//    }


