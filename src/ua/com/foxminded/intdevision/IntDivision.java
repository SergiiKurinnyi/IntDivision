package ua.com.foxminded.intdevision;

import java.util.List;

public class IntDivision {

    private Calculator calculator = new Calculator();
    private FormatOutput formatter = new FormatOutput();
    private DataObject dataObject;


    public IntDivision() {
    }

    public IntDivision(FormatOutput formatter) {
        this.formatter = formatter;
    }

    public IntDivision(Calculator calculator) {
        this.calculator = calculator;
    }


    public void divide(String dividend, String divisor) {
        checkIsPositiveInt(dividend);
        checkIsPositiveInt(divisor);
        dataObject = calculator.calculateDevision(dividend, divisor);
        formatOutput(dataObject);
    }


    public void formatOutput(DataObject dataObject) {
        List<String> outputList = formatter.formatOutput(dataObject);
        printToConsole(outputList);
    }


    public void printToConsole(List<String> outputList) {
        for (String line : outputList) {
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
