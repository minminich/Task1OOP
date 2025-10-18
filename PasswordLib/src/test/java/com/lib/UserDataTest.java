package com.lib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDataTest {
    @Test
    public void testUserData() {
        String username = "testUser";
        String passwordHash = "testHash";

        UserData userData = new UserData(username, passwordHash);

        assertEquals(username, userData.getUsername(), "Username needs to match");
        assertEquals(passwordHash, userData.getStoredHash(), "Hash needs to match");
    }
}
