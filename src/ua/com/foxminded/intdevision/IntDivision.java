package ua.com.foxminded.intdevision;

import java.util.ArrayList;
import java.util.List;

public class IntDivision {

    private Calculator calculator = new Calculator();
    private FormatOutput formatter = new FormatOutput();

    public IntDivision() {
    }

    public IntDivision(Calculator calculator, FormatOutput formatter) {
        this.formatter = formatter;
        this.calculator = calculator;
    }


    public List<String> divide(String dividend, String divisor) {
        checkIsPositiveInt(dividend);
        checkIsPositiveInt(divisor);
        DataObject dataObject = calculator.calculateDevision(dividend, divisor);
        return new ArrayList<>(formatter.formatOutput(dataObject));
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
