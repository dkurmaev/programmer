package ait.user.test;

import ait.user.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    final String email = "peter@gmail.com";
    final String password = "12345Az!";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        user = new User(email, password);
    }

    @Test
    void testValidPassword() {
        String validPassword = "qwertY1@";
        user.setPassword(validPassword);
        assertEquals(validPassword, user.getPassword());
    }

    @Test
    void testValidEmail() {
        String validEmail = "peter@gmail.com";
        user.setEmail(validEmail);
        assertEquals(validEmail, user.getEmail());
    }


    @Test
    void testPasswordLength() {
        String inValidPassword = "wertY1@";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordUppercase() {
        String inValidPassword = "werty1@";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordLowercase() {
        String inValidPassword = "QWERTY1@";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordDigits() {
        String inValidPassword = "Qwertyl@";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordSpecialSymbols() {
        String inValidPassword = "Qwerty12";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testEmailAt() {
        String inValidEmail = "petergmail.com";
        user.setEmail(inValidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailAtOnlyOne() {
        String inValidEmail = "pe@ter@gmail.com";
        user.setEmail(inValidEmail);
        assertEquals(email, user.getEmail());
    }
    @Test
    void testEmailDotAfterAt() {
        String inValidEmail = "pet.er@gmailcom";
        user.setEmail(inValidEmail);
        assertEquals(email, user.getEmail());
    }
    @Test
    void testEmailAfterDotMinTwoSymbols() {
        String inValidEmail = "peter@gmail.co.m";
        user.setEmail(inValidEmail);
        assertEquals(email, user.getEmail());
    }
    @Test
    void testEmailaValidCharakters() {
        String inValidEmail = "pet/er@gmail.com";
        user.setEmail(inValidEmail);
        assertEquals(email, user.getEmail());
    }

}