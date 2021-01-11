package ua.com.foxminded.intdevision;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Calculator integerDevision = new Calculator();
        Facade facade = new Facade();

        List<CalcData> calc = integerDevision.calculateDevision("78945", "4");
        integerDevision.drawOutput(calc);
    }

}
