package com.min;
public class UserData {
    //данные пользователя
    private String username;
    private String storedHash;
    public UserData(String username, String password) {
        this.username = username;
        this.storedHash = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getStoredHash() {
        return storedHash;
    }
}
