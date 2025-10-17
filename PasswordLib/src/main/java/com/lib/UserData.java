package com.lib;
public class UserData {
    private String username;
    private String storedHash;
    public UserData(String username, String password) {
        this.username = username;
        this.storedHash = password;
    }
    public String getStoredHash() {
        return storedHash;
    }
}
