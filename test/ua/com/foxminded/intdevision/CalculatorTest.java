package ua.com.foxminded.intdevision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;
    private List<CalcData> dataList;

    private static final String SMALL_DIVDEND = "8";
    private static final String SMALL_DIVISOR = "3";
    private static final int INT_SMALL_DIVDEND = 8;
    private static final int INT_SMALL_DIVISOR = 3;

    @BeforeEach
    void init() {
        calculator = new Calculator();
        dataList = new ArrayList<CalcData>();
    }

    @Test
    void calculateDevision_CheckDTODataList_ForInputIsPositiveInts() {
        dataList.add(new CalcData(0, "8", "6"));
        dataList.add(new CalcData(0, "2", ""));
        DataObject expectedDTO = new DataObject(dataList, INT_SMALL_DIVDEND, INT_SMALL_DIVISOR);
        DataObject actualDTO = calculator.calculateDevision(SMALL_DIVDEND, SMALL_DIVISOR);

        assertEquals(expectedDTO, actualDTO);
    }

}
