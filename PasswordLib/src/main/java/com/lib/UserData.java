package com.lib;
public class UserData {
    private final String username;
    private final String storedHash;
    public UserData(String username, String password) {
        this.username = username;
        this.storedHash = password;
    }
    public String getStoredHash() {
        return storedHash;
    }

    public String getUsername() {
        return username;
    }
}
