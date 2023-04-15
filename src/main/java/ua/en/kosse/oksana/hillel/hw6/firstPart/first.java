package ua.en.kosse.oksana.hillel.hw6.firstPart;

public class first {
    public static int findSymbolOccurance(String str, char ch) {
        int count = 0;
        /*for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch)
                count++;
        }*/
        for (char element : str.toCharArray()){
            if (element == ch) count++;
        }
        return count;
    }

    public static int findWordPosition(String string, String target) {
        return string.indexOf(target);
    }

    public static String stringReverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static Boolean isPalindrome(String polindr) {
        return polindr.equals(new StringBuilder(polindr).reverse().toString());
    }
}
