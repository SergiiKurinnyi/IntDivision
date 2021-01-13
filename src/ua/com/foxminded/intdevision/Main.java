package ua.com.foxminded.intdevision;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IntDivision intDivision = new IntDivision();
        List<String> result = intDivision.divide("1823000002", "13");
        for (String resultString : result) {
            System.out.println(resultString);
        }
    }

}
