package ua.com.foxminded.intdevision;

import static java.lang.String.format;
import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static int dividend;
    private static int divisor;
    private static int quotient;

    public List<CalcData> calculateDevision(String dividendInput, String divisorInput) {
        checkIsPositiveInt(dividendInput);
        checkIsPositiveInt(divisorInput);
        dividend = Integer.parseInt(dividendInput);
        divisor = Integer.parseInt(divisorInput);
        quotient = dividend / divisor;

        List<CalcData> dataList = new ArrayList<>();
        int[] dividendDigits = getIntArrayFromString(dividendInput);
        int currentDividend = dividendDigits[0];

        int digitCounter = 0;
        for (int i = 0; i < dividendDigits.length; i++) {
            while (currentDividend < divisor) {
                if (digitCounter == dividendDigits.length - 1) {
                    break;
                }
                digitCounter++;
                currentDividend = currentDividend * 10 + dividendDigits[digitCounter];
            }
            if (currentDividend != 0) {
                dataList.add(new CalcData(digitCounter, valueOf(currentDividend),
                        valueOf((currentDividend / divisor) * divisor)));
            }
            currentDividend = currentDividend % divisor;
        }
        dataList.add(new CalcData(digitCounter, valueOf(currentDividend), ""));
        return dataList;
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


    private int[] getIntArrayFromString(String number) {
        String[] dividendSymbols = number.split("");
        int[] dividendDigits = new int[dividendSymbols.length];

        for (int i = 0; i < dividendSymbols.length; i++) {
            dividendDigits[i] = Integer.parseInt(dividendSymbols[i]);
        }
        return dividendDigits;
    }

    public void drawOutput(List<CalcData> data) {
        final String lineSpaces = "                       ";
        final String separatorLine = "----------";
        List<String> outputList = new ArrayList<>();

        String quitientLine = separatorLine.substring(0, (valueOf(quotient).length()));

        int lineLength = valueOf(dividend).length() + valueOf(quotient).length() + 2;
        int indentation2 = lineLength
                - (valueOf(data.get(0).getMem()).length() + valueOf(quotient).length() + 2);
        int indentation3 = lineLength
                - (valueOf(data.get(0).getMem()).length() + valueOf(quotient).length() + 2);

        String line1 = ("_" + dividend + "|" + divisor);
        String line2 = format(" %s%s|%s", data.get(0).getMem(), lineSpaces.substring(0, indentation2),
                quitientLine);
        String line3 = format(" %s%s|%s",
                separatorLine.substring(0, valueOf(data.get(0).getMem()).length()),
                lineSpaces.substring(0, indentation3), quotient);

        outputList.add(line1);
        outputList.add(line2);
        outputList.add(line3);


        int currentIndent = 0;
        for (int i = 1; i < data.size(); i++) {
            currentIndent = data.get(i).getIndent();
            if (data.get(i).getMem().equals("") || Integer.parseInt(data.get(i).getMem()) == 0) {
                outputList.add(format("%" + (currentIndent + 2) + "s", data.get(i).getDividend()));
                break;
            }
            if (data.get(i).getDividend().length() > 2) {
                int x = data.get(i).getDividend().length() - 2;
                outputList.add(format("%" + (currentIndent - x) + "s%s", "_", data.get(i).getDividend()));

            } else if (data.get(i).getDividend().length() == 1) {
                outputList.add(format("%" + (currentIndent + 1) + "s%s", "_", data.get(i).getDividend()));
            } else {
                outputList.add(format("%" + currentIndent + "s%s", "_", data.get(i).getDividend()));
            }

            if (Integer.parseInt(data.get(i).getMem()) == 0) {
                break;
            }

            outputList.add(format("%" + (currentIndent + 2) + "s", data.get(i).getMem()));
            
            if (i != data.size() - 1) {
                outputList.add(format("%" + (currentIndent + 2) + "s",
                        separatorLine.substring(0, valueOf(data.get(i).getDividend()).length())));
            }
        }

        for (String s : outputList) {
            System.out.println(s);
        }
    }

}