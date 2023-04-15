package ua.en.kosse.oksana.hillel.hw5.string;

public class ThreeWords {

    public void printThreeWords (String str){
        String[] words = str.split(", ");
        for (String word : words) {
            System.out.println(word);
        }
        return ;
    }

    public void stringNumber(String str, int n) {

        for (int i = 0; i <= n; i++) {
            System.out.println(str);
        }
        return;
    }
}
