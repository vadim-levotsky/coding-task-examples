package org.example.string;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringInverter {

    public static void main(String[] args) {
        String inputString = "Amazon is the best IT company!";
        System.out.println(reverseWordCharacters(inputString));
        System.out.println("!ynapmoc TI tseb eht si nozamA".equals(reverseWordCharacters(inputString)));
        System.out.println(" ===== 2nd method ====== ");
        System.out.println(reverseWordCharactersV2(inputString));
        System.out.println("!ynapmoc TI tseb eht si nozamA".equals(reverseWordCharactersV2(inputString)));
    }

    public static String reverseWordCharacters(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            stringBuilder.append(charArray[i]);
        }
        return stringBuilder.toString();
    }

    public static String reverseWordCharactersV2(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        return IntStream.range(0, length)
                .boxed()
                .map(it -> String.valueOf(charArray[length - 1 - it]))
                .collect(Collectors.joining());
    }

}
