package ua.com.foxminded.intdevision;

import java.util.ArrayList;
import java.util.List;

public class IntDivision {

    private Calculator calculator = new Calculator();
    private Formatter formatter = new Formatter();
    private DataObject dataObject;

    public IntDivision(String dividend, String divisor) {
        checkIsPositiveInt(dividend);
        checkIsPositiveInt(divisor);

        dataObject = calculator.calculateDevision(dividend, divisor);
        List<String> result = new ArrayList<>(formatter.formatOutput(dataObject));
        printData(result);
    }

    private void printData(List<String> listToPrint) {
        for (String line : listToPrint) {
            System.out.println(line);
        }
    }

    private void checkIsPositiveInt(String number) {
        try {
            int testInt = Integer.parseInt(number);
            if (testInt < 1) {
                throw new IllegalArgumentException("Input cannot be zero or negative number");
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Input should be digits only & cannot be negative number!");
        }
    }

}
