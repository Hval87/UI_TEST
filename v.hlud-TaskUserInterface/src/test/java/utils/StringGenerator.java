package utils;

import java.util.Random;

public class StringGenerator {

    public static StringBuilder stringGenerate(int strLenght, String letterSet) {
        Random random = new Random();
        StringBuilder string = new StringBuilder();
        String set;
        if (letterSet.length() == 0) {
            set = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        } else {
            set = letterSet;
        }
        for (int i = 0; i < strLenght; i++) {
            String letter = String.valueOf(set.charAt(random.nextInt(set.length())));
            string.append(letter);
        }
        return string;
    }

    public static StringBuilder passwordGenerate(int passwordLenght, String email) {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String candidateCharsRUS = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧЩЬЪЭЮЯ";
        String candidateCharsNUM = "1234567890";
        str.append(stringGenerate(1, email)).append(stringGenerate(1, candidateCharsNUM).append(stringGenerate(1, candidateCharsRUS)));
        for (int i = 0; i < passwordLenght - 3; i++) {
            String letter = String.valueOf(candidateChars.charAt(random.nextInt(candidateChars.length())));
            str.append(letter);
        }
        return str;
    }
}

