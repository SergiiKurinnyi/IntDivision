package ua.com.foxminded.intdevision;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public DataObject calculateDevision(String dividendInput, String divisorInput) {
        int dividend = parseInt(dividendInput);
        int divisor = parseInt(divisorInput);

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
        return createDTO(dataList, dividend, divisor);
    }

    private DataObject createDTO(List<CalcData> dataList, int dividend, int divisor) {
        DataObject data = new DataObject();
        data.setDataList(dataList);
        data.setDividend(dividend);
        data.setDivisor(divisor);
        data.setRatio(dividend / divisor);
        return data;
    }

    private int[] getIntArrayFromString(String number) {
        String[] dividendSymbols = number.split("");
        int[] dividendDigits = new int[dividendSymbols.length];

        for (int i = 0; i < dividendSymbols.length; i++) {
            dividendDigits[i] = parseInt(dividendSymbols[i]);
        }
        return dividendDigits;
    }

}

