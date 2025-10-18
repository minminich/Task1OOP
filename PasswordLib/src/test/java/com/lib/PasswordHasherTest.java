package com.lib;

import org.junit.jupiter.api.Test;
import java.security.NoSuchAlgorithmException;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordHasherTest {
    @Test
    public void testHashPassword() throws NoSuchAlgorithmException {
        String password = "testPassword";
        String hash = PasswordHasher.hashPassword(password);

        assertNotNull(hash, "Hash can not be null");
        assertEquals(64, hash.length(), "Hash length should be 64");
    }
    @Test
    public void testHashPasswordWithGeneratedSalt() throws NoSuchAlgorithmException {
        String password = "testPassword";
        String hashWithSalt = PasswordHasher.hashPasswordWithGeneratedSalt(password);

        assertNotNull(hashWithSalt, "HashWithSalt can not be null");
        assertEquals(96, hashWithSalt.length(), "HashWithSalt length should be 96");

        String salt = hashWithSalt.substring(0, 32);
        String hash = hashWithSalt.substring(32);

        assertEquals(32, salt.length(), "Salt length should be 32");
        assertEquals(64, hash.length(), "Hash length should be 64");
    }
    @Test
    public void testGenerateSalt() {
        String salt = PasswordHasher.generateSalt();

        assertNotNull(salt, "Salt can not be null");
        assertEquals(32, salt.length(), "Salt length should be 32");
    }
    @Test
    public void testCheckPassword() throws Exception {
        String password = "testPassword";
        String storedHash = PasswordHasher.hashPasswordWithGeneratedSalt(password);

        boolean check = PasswordHasher.checkPassword(password, storedHash);
        assertTrue(check, "Password checking needs to be true");
    }
    @Test
    public void testCheckPasswordWrongPassword() throws Exception {
        String password = "testPassword";
        String wrongPassword = "wrongPassword";
        String storedHash = PasswordHasher.hashPasswordWithGeneratedSalt(password);

        boolean check = PasswordHasher.checkPassword(wrongPassword, storedHash);
        assertFalse(check, "Incorrect password checking needs to be false");
    }

    @Test
    public void testCheckPasswordWithDifferentSalts() throws Exception {
        String password = "testPassword";
        String hash1 = PasswordHasher.hashPasswordWithGeneratedSalt(password);
        String hash2 = PasswordHasher.hashPasswordWithGeneratedSalt(password);

        assertNotEquals(hash1, hash2, "Hashes needs to be different");

        assertTrue(PasswordHasher.checkPassword(password, hash1));
        assertTrue(PasswordHasher.checkPassword(password, hash2));
    }

}
