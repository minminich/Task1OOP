package com.min;

import java.util.HashMap;

public class UserInput {
    private HashMap<String, UserData> users = new HashMap<>();

    public void registerUser(String username, String password) throws Exception {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (users.containsKey(username)) {
            throw new IllegalStateException("Username " + username + " is already in use");
        }
        String storedHash = PasswordHasher.hashPasswordWithGeneratedSalt(password);
        UserData user = new UserData(username, storedHash);
        users.put(username, user);
    }

    public boolean authenticateUser(String username, String password) throws Exception {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        UserData user = users.get(username);
        if (user == null) {
            throw new SecurityException("User " + username + " not found");
        }

        return PasswordHasher.checkPassword(password, user.getStoredHash());
    }
}
