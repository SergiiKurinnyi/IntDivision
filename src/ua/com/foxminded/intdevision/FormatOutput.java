package ua.com.foxminded.intdevision;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;

public class FormatOutput implements Format {

    private static final String INDENT_LINE = "                       ";
    private static final String SEPARATE_LINE = "----------";
    private static final String MINUS_SIGN = "_";
    private static final String VERTICAL_LINE = "|";
    private static final String EMPTY_LINE = "";
    private static final String LINES_2_3_FORMAT = " %s%s|%s";
    private static final String STRING_FORMAT_BEFORE_INDENT = "%";
    private static final String STRING_FORMAT_AFTER_INDENT_1VAR = "s";
    private static final String STRING_FORMAT_AFTER_INDENT_2VARS = "s%s";
    private static List<String> outputList = new ArrayList<>();


    public List<String> formatOutput(DataObject dataObject) {
        int dividend = dataObject.getDividend();
        int divisor = dataObject.getDivisor();
        int ratio = dividend / divisor;
        List<CalcData> data = dataObject.getDataList();

        String ratioLine = SEPARATE_LINE.substring(0, valueOf(ratio).length());
        int lineLength = valueOf(dividend).length() + valueOf(ratio).length() + 2;
        int indentLine2 = lineLength - (valueOf(data.get(0).getMult()).length() + valueOf(ratio).length() + 2);
        int indentLine3 = lineLength - (valueOf(data.get(0).getMult()).length() + valueOf(ratio).length() + 2);

        String line1 = (MINUS_SIGN + dividend + VERTICAL_LINE + divisor);
        String line2 = format(LINES_2_3_FORMAT, data.get(0).getMult(), INDENT_LINE.substring(0, indentLine2),
                ratioLine);
        String line3 = format(LINES_2_3_FORMAT, SEPARATE_LINE.substring(0, valueOf(data.get(0).getMult()).length()),
                INDENT_LINE.substring(0, indentLine3), ratio);

        outputList.add(line1);
        outputList.add(line2);
        outputList.add(line3);

        formatDivisionSteps(data);
        return outputList;
    }


    private void formatDivisionSteps(List<CalcData> data) {
        int indent = 0;
        for (int i = 1; i < data.size(); i++) {
            indent = data.get(i).getIndent();

            if (data.get(i).getMult().equals(EMPTY_LINE) || parseInt(data.get(i).getMult()) == 0) {
                outputList.add(format(STRING_FORMAT_BEFORE_INDENT + (indent + 2) + STRING_FORMAT_AFTER_INDENT_1VAR,
                        data.get(i).getDividend()));
                break;
            }

            if (data.get(i).getDividend().length() > 2) {
                int x = data.get(i).getDividend().length() - 2;
                outputList.add(format(STRING_FORMAT_BEFORE_INDENT + (indent - x) + STRING_FORMAT_AFTER_INDENT_2VARS,
                        MINUS_SIGN,
                        data.get(i).getDividend()));
            } else if (data.get(i).getDividend().length() == 1) {
                outputList.add(format(STRING_FORMAT_BEFORE_INDENT + (indent + 1) + STRING_FORMAT_AFTER_INDENT_2VARS,
                        MINUS_SIGN,
                        data.get(i).getDividend()));
            } else {
                outputList.add(
                        format(STRING_FORMAT_BEFORE_INDENT + indent + STRING_FORMAT_AFTER_INDENT_2VARS, MINUS_SIGN,
                                data.get(i).getDividend()));
            }

            if (parseInt(data.get(i).getMult()) == 0) {
                break;
            }

            outputList.add(format(STRING_FORMAT_BEFORE_INDENT + (indent + 2) + STRING_FORMAT_AFTER_INDENT_1VAR,
                    data.get(i).getMult()));

            if (i != data.size() - 1) {
                outputList.add(format(STRING_FORMAT_BEFORE_INDENT + (indent + 2) + STRING_FORMAT_AFTER_INDENT_1VAR,
                        SEPARATE_LINE.substring(0, valueOf(data.get(i).getDividend()).length())));
            }
        }
    }

}


