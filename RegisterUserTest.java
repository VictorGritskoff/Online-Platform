package com.example.example;

public class RegisterUserTest {
    @Test
    public void testEmptyFieldsRegistration() {
        RegisterUser registerUser = new RegisterUser();
        assertFalse(registerUser.registerUser("", "password123",
                "john.doe@example.com"));
        assertFalse(registerUser.registerUser("John Doe", "",
                "john.doe@example.com"));
        assertFalse(registerUser.registerUser("John Doe", "password123",
                ""));
        assertFalse(registerUser.registerUser("", "", ""));
    }
    @Test
    public void testInvalidEmailRegistration() {
        RegisterUser registerUser = new RegisterUser();
        assertFalse(registerUser.registerUser("John Doe", "password123",
                "invalidemail"));
    }
}
