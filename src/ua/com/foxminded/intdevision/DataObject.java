package ua.com.foxminded.intdevision;

import java.util.List;

public class DataObject {
    private List<CalcData> dataList;
    private int dividend;
    private int divisor;

    public List<CalcData> getDataList() {
        return dataList;
    }

    public void setDataList(List<CalcData> dataList) {
        this.dataList = dataList;
    }
    public int getDividend() {
        return dividend;
    }
    public void setDividend(int dividend) {
        this.dividend = dividend;
    }
    public int getDivisor() {
        return divisor;
    }
    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

}
