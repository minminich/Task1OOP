package com.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserInputTest {

    private UserInput userInput;

    @BeforeEach
    public void setUp() {
        userInput = new UserInput();
    }

    @Test
    public void testRegisterUserSuccess() throws Exception {
        String username = "testUser";
        String password = "testPassword";

        userInput.registerUser(username, password);

        boolean auth = userInput.authenticateUser(username, password);
        assertTrue(auth, "User needs to be authenticated");
    }

    @Test
    public void testAuthenticateUserSuccess() throws Exception {
        String username = "testUser";
        String password = "testPassword";

        userInput.registerUser(username, password);
        boolean auth = userInput.authenticateUser(username, password);

        assertTrue(auth, "Authenticated user should be successful");
    }

    @Test
    public void testAuthenticateUserWrongPassword() throws Exception {
        String username = "testUser";
        String password = "testPassword";
        String wrongPassword = "wrongPassword";

        userInput.registerUser(username, password);
        boolean check = userInput.authenticateUser(username, wrongPassword);

        assertFalse(check, "Authenticated user with wrong password should not be successful");
    }

    @Test
    public void testMultipleUsers() throws Exception {
        userInput.registerUser("user1", "password1");
        userInput.registerUser("user2", "password2");
        userInput.registerUser("user3", "password3");

        assertTrue(userInput.authenticateUser("user1", "password1"));
        assertTrue(userInput.authenticateUser("user2", "password2"));
        assertTrue(userInput.authenticateUser("user3", "password3"));

        assertFalse(userInput.authenticateUser("user1", "password2"));
        assertFalse(userInput.authenticateUser("user2", "password3"));
        assertFalse(userInput.authenticateUser("user3", "password1"));
    }
}
