package ua.com.foxminded.intdevision;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;

public class Formatter implements Formattable {

    private static final String INDENT_LINE = "                       ";
    private static final String SEPARATE_LINE = "----------";


    public List<String> formatOutput(DataObject dataObject) {
        int dividend = dataObject.getDividend();
        int divisor = dataObject.getDivisor();
        int ratio = dataObject.getRatio();
        List<CalcData> data = dataObject.getDataList();

        List<String> outputList = new ArrayList<>();
        String ratioLine = SEPARATE_LINE.substring(0, valueOf(ratio).length());

        int lineLength = valueOf(dividend).length() + valueOf(ratio).length() + 2;
        int indent2 = lineLength - (valueOf(data.get(0).getMult()).length() + valueOf(ratio).length() + 2);
        int indent3 = lineLength - (valueOf(data.get(0).getMult()).length() + valueOf(ratio).length() + 2);

        String line1 = ("_" + dividend + "|" + divisor);
        String line2 = format(" %s%s|%s", data.get(0).getMult(), INDENT_LINE.substring(0, indent2), ratioLine);
        String line3 = format(" %s%s|%s", SEPARATE_LINE.substring(0, valueOf(data.get(0).getMult()).length()),
                INDENT_LINE.substring(0, indent3), ratio);

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
                        SEPARATE_LINE.substring(0, valueOf(data.get(i).getDividend()).length())));
            }
        }
        return outputList;
    }

}


