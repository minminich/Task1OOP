package com.lib;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final int PASSWORD_LENGTH = 16;

    private static final SecureRandom random = new SecureRandom();
    private static final String caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String small_caps="abcdefghijklmnopqrstuvwxyz";
    private static final String numeric="1234567890";
    private static final String special_char="~!@#$%^&*(_+{}|:_[?]>=<";
    private static final String dic = caps + small_caps + numeric + special_char;


    private static String generatePassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH ; i++) {
            int index = random.nextInt(dic.length());
            password.append(dic.charAt(index));
        }
        return password.toString();
    }

}
//дописать возможность генерировать пароли разной сложности, проверка безопасности