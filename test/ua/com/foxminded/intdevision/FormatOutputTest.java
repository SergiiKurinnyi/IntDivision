package ua.com.foxminded.intdevision;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormatOutputTest {

    private FormatOutput formatOutput;
    private DataObject dataObject;
    private List<CalcData> dataList;

    private static final int SMALL_DIVDEND = 8;
    private static final int SMALL_DIVISOR = 3;

    @BeforeEach
    void init() {
        formatOutput = new FormatOutput();
        dataList = new ArrayList<CalcData>();
    }

    @Test
    void formatOutput_CheckReturnStringList_ForValidDTO() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("_8|3");
        expectedList.add(" 6|-");
        expectedList.add(" -|2");
        expectedList.add(" 2");

        dataList.add(new CalcData(0, "8", "6"));
        dataList.add(new CalcData(0, "2", ""));
        dataObject = new DataObject(dataList, SMALL_DIVDEND, SMALL_DIVISOR);
        List<String> actualList = formatOutput.formatOutput(dataObject);

        assertIterableEquals(expectedList, actualList);
    }

}
