package com.lib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordGeneratorTest {
    @Test
    public void testGeneratePasswordLength() {
        String password = PasswordGenerator.generatePassword();
        assertEquals(16, password.length(), "Password length needs to be 16");
    }
    @Test
    public void testGeneratePasswordUniqueness() {
        String password1 = PasswordGenerator.generatePassword();
        String password2 = PasswordGenerator.generatePassword();
        assertNotEquals(password1, password2, "Generated passwords needs to be different");
    }
}



