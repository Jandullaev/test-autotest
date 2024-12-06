package com.epam.project.utils;

import java.security.SecureRandom;
import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {

  public static String generateRandomEmail() {
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "1234567890";
    int length = 8;
    String combinedChars = lowerCaseLetters  + numbers;
    SecureRandom random = new SecureRandom();
    String email =
        String.valueOf(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())))
            + numbers.charAt(random.nextInt(numbers.length()));
    return email + RandomStringUtils.random(length - 4, combinedChars);
  }

  public static String generateRandomPassword() {
    String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String specialCharacters = "!@#$";
    String numbers = "1234567890";
    int length = 8;
    String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
    SecureRandom random = new SecureRandom();
    String password =
        String.valueOf(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())))
            + capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()))
            + specialCharacters.charAt(random.nextInt(specialCharacters.length()))
            + numbers.charAt(random.nextInt(numbers.length()));
    return password + RandomStringUtils.random(length - 4, combinedChars);
  }
}
