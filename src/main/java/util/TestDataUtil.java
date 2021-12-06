package util;

import core.Log;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

public class TestDataUtil {

    public static String generatePin() {
        String pin = Integer.toString(ThreadLocalRandom.current().nextInt(100000, 999999 + 1));
        Log.debug("Generated PIN: " + pin);
        return pin;
    }

    public static String generateUsername() {
        String username = "testautouser_" + ThreadLocalRandom.current().nextInt(1000000, 9999999 + 1);
        Log.debug("Generated username: " + username);
        return username;
    }

    public static String generatePassword() {
        int totalLength = 20;
        int specialCharacters = 3;
        int numbers = 5;
        String normalCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numbersString = "0123456789";
        String specialCharactersString = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String password = RandomStringUtils.random(totalLength - (specialCharacters + numbers), normalCharacters) +
                RandomStringUtils.random(numbers, numbersString) +
                RandomStringUtils.random(specialCharacters, specialCharactersString);
        Log.debug("Generated password: " + password);
        return password;
    }
}
