package ua.com.foxminded.intdevision;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IntDivision intDivision = new IntDivision();
        List<String> result = intDivision.divide("8", "3");
        for (String resultString : result) {
            System.out.println(resultString);
        }
    }

}
