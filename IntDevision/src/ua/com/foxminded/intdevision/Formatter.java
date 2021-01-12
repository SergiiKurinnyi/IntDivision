package ua.com.foxminded.intdevision;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;

public class Formatter {

    public String dividendInput;
    public String divisorInput;
    private final String indentLine = "                       ";
    private final String separateLine = "----------";

    public void setDividend(String dividendInput) {
        this.dividendInput = dividendInput;
    }

    public void setDivisor(String divisorInput) {
        this.divisorInput = divisorInput;
    }


    public List<String> drawOutput(List<CalcData> data) {
        int dividend = parseInt(dividendInput);
        int divisor = parseInt(divisorInput);
        int ratio = dividend / divisor;

        List<String> outputList = new ArrayList<>();
        String ratioLine = separateLine.substring(0, valueOf(ratio).length());

        int lineLength = valueOf(dividend).length() + valueOf(ratio).length() + 2;
        int indent2 = lineLength - (valueOf(data.get(0).getMult()).length() + valueOf(ratio).length() + 2);
        int indent3 = lineLength - (valueOf(data.get(0).getMult()).length() + valueOf(ratio).length() + 2);

        String line1 = ("_" + dividend + "|" + divisor);
        String line2 = format(" %s%s|%s", data.get(0).getMult(), indentLine.substring(0, indent2), ratioLine);
        String line3 = format(" %s%s|%s", separateLine.substring(0, valueOf(data.get(0).getMult()).length()),
                indentLine.substring(0, indent3), ratio);

        outputList.add(line1);
        outputList.add(line2);
        outputList.add(line3);

        int indent = 0;
        for (int i = 1; i < data.size(); i++) {
            indent = data.get(i).getIndent();

            if (data.get(i).getMult().equals("") || parseInt(data.get(i).getMult()) == 0) {
                outputList.add(format("%" + (indent + 2) + "s", data.get(i).getDividend()));
                break;
            }

            if (data.get(i).getDividend().length() > 2) {
                int x = data.get(i).getDividend().length() - 2;
                outputList.add(format("%" + (indent - x) + "s%s", "_", data.get(i).getDividend()));
            } else if (data.get(i).getDividend().length() == 1) {
                outputList.add(format("%" + (indent + 1) + "s%s", "_", data.get(i).getDividend()));
            } else {
                outputList.add(format("%" + indent + "s%s", "_", data.get(i).getDividend()));
            }

            if (parseInt(data.get(i).getMult()) == 0) {
                break;
            }

            outputList.add(format("%" + (indent + 2) + "s", data.get(i).getMult()));

            if (i != data.size() - 1) {
                outputList.add(format("%" + (indent + 2) + "s",
                        separateLine.substring(0, valueOf(data.get(i).getDividend()).length())));
            }
        }
        return outputList;
    }

}


