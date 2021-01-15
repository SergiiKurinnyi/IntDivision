package ua.com.foxminded.intdevision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;


class IntDevisionTest {

    private IntDivision intDivision;
    private IntDivision intDivisionMock;
    private Calculator calclulatorMock;
    private FormatOutput formatterMock;
    private List<String> result;
    private DataObject dataObject;
    private InOrder inOrder;

    private static final String EMPTY_INPUT = "";
    private static final String ZERO_INT = "0";
    private static final String NEGATIVE_INT = "-1";
    private static final String BIG_POSITVE_INT = "1823000002";
    private static final String SMALL_POSITVE_INT = "13";


    @BeforeEach
    void init() {
        formatterMock = mock(FormatOutput.class);
        calclulatorMock = mock(Calculator.class);
        intDivision = new IntDivision();
        intDivisionMock = new IntDivision(calclulatorMock, formatterMock);
        inOrder = inOrder(calclulatorMock, formatterMock);
        result = new ArrayList<>();
    }

    @Test
    void intDivision_ShouldcallCalculateDivisionMethodOnce_IfInputIsPositiveInts() {
        intDivisionMock.divide(BIG_POSITVE_INT, SMALL_POSITVE_INT);
        verify(calclulatorMock, times(1)).calculateDevision(BIG_POSITVE_INT, SMALL_POSITVE_INT);
    }

    @Test
    void intDivision_ShouldcallFormatOutputMethodOnce_IfInputIsPositiveInts() {
        intDivisionMock.divide(BIG_POSITVE_INT, SMALL_POSITVE_INT);
        verify(formatterMock, times(1)).formatOutput(dataObject);
    }

    @Test
    void intDivision_ShouldcallCalculateDivisionThenFormatOutputMethod_IfInputIsPositiveInts() {
        intDivisionMock.divide(BIG_POSITVE_INT, SMALL_POSITVE_INT);
        inOrder.verify(calclulatorMock).calculateDevision(BIG_POSITVE_INT, SMALL_POSITVE_INT);
        inOrder.verify(formatterMock).formatOutput(dataObject);
    }

    @Test
    void intDivision_ShouldThrowIllegalArgumentException_IfEmptyDividend() {
        String expected = "Input should be digits only & cannot be negative number!";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> intDivision.divide(EMPTY_INPUT, SMALL_POSITVE_INT));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void intDivision_ShouldThrowIllegalArgumentException_IfEmptyDivisor() {
        String expected = "Input should be digits only & cannot be negative number!";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> intDivision.divide(SMALL_POSITVE_INT, EMPTY_INPUT));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void intDivision_ShouldThrowIllegalArgumentException_IfDividendIsNull() {
        String expected = "Input should be digits only & cannot be negative number!";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> intDivision.divide(null, SMALL_POSITVE_INT));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void intDivision_ShouldThrowIllegalArgumentException_IfDivisorIsNull() {
        String expected = "Input should be digits only & cannot be negative number!";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> intDivision.divide(SMALL_POSITVE_INT, null));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void intDivision_ShouldThrowIllegalArgumentException_IfZeroDivident() {
        String expected = "Input cannot be zero or negative number";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> intDivision.divide(ZERO_INT, SMALL_POSITVE_INT));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void intDivision_ShouldThrowIllegalArgumentException_IfZeroDivisor() {
        String expected = "Input cannot be zero or negative number";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> intDivision.divide(SMALL_POSITVE_INT, ZERO_INT));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void intDivision_ShouldThrowIllegalArgumentException_IfNegativeDividend() {
        String expected = "Input cannot be zero or negative number";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> intDivision.divide(NEGATIVE_INT, SMALL_POSITVE_INT));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void intDivision_ShouldThrowIllegalArgumentException_IfNegativeDivisor() {
        String expected = "Input cannot be zero or negative number";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> intDivision.divide(SMALL_POSITVE_INT, NEGATIVE_INT));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void intDivision_CheckTopOutputStrings_ForInputIsPositiveInts() {
        String expected1 = "_1823000002|13";
        String expected2 = " 13        |---------";
        String expected3 = " --        |140230769";
        result = intDivision.divide(BIG_POSITVE_INT, SMALL_POSITVE_INT);
        assertEquals(expected1, result.get(0));
        assertEquals(expected2, result.get(1));
        assertEquals(expected3, result.get(2));
    }

    @Test
    void intDivision_CheckLastOutputString_ForInputIsPositiveInts() {
        String expected = "          5";
        result = intDivision.divide(BIG_POSITVE_INT, SMALL_POSITVE_INT);
        int resultLastIndex = result.size() - 1;
        assertEquals(expected, result.get(resultLastIndex));
    }

    @Test
    void intDivision_CheckLastOutputString_IfDividendIsSmallerThenDivisor() {
        String expected = " 13";
        result = intDivision.divide(SMALL_POSITVE_INT, BIG_POSITVE_INT);
        int resultLastStringIndex = result.size() - 1;
        assertEquals(expected, result.get(resultLastStringIndex));
    }

}
