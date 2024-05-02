package com.example.example;

public class EmailValidationTest {
    @Test
    public void testValidEmailRegistration() {
        RegisterUser registerUser = new RegisterUser();

        assertTrue(registerUser.validateEmail("jane.smith@example.com"));
    }
    @Test
    public void testInvalidEmailRegistration() {
        RegisterUser registerUser = new RegisterUser();
        assertFalse(registerUser.validateEmail("invalidemail"));
    }
    @Test
    public void testEmptyEmailRegistration() {
        RegisterUser registerUser = new RegisterUser();
        assertFalse(registerUser.validateEmail(""));
    }
    @Test
    public void testNullEmailRegistration() {
        RegisterUser registerUser = new RegisterUser();
        assertFalse(registerUser.validateEmail(null));
    }
}
