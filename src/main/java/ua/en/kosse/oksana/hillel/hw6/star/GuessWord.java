package ua.en.kosse.oksana.hillel.hw6.star;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class GuessWord {

    public void guessWord(String[] words, String strInput) {
        StringBuilder stringResult = new StringBuilder();
        String mysteriousWord = new RandomWords().randomWords(words);
        while (!mysteriousWord.equals(strInput.toLowerCase())) {
            //System.out.printf("%s %s\n", mysteriousWord, strInput.toLowerCase());
            for (int i = 0; i < Math.min(mysteriousWord.length(), strInput.length()); i++) {
                if (mysteriousWord.charAt(i) == strInput.charAt(i)) {
                    stringResult.append( mysteriousWord.charAt(i));
                } else {
                    stringResult.append('#');
                }
            }
            System.out.printf("Letter matching check: %s\n",
                    StringUtils.rightPad(stringResult.toString(), 15, '#'));
            stringResult.delete(0, stringResult.length());
            strInput = getStr();

        }

        System.out.println("Congratulations! You guessed the word :)");
    }


    public static String getStr() {
        String strInput;
        Pattern pattern = Pattern.compile("[A-Za-z]*");
        System.out.println("Input string:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext(pattern)) {
            strInput = scanner.nextLine();
        } else {
            System.out.println("You made a mistake while entering a string. Please try again");
            scanner.next();
            strInput = getStr();//рекурсия
        }
        return strInput;
    }
}
