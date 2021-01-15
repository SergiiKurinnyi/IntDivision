package ua.com.foxminded.intdevision;

import java.util.List;

public class DataObject {
    private List<CalcData> dataList;
    private int dividend;
    private int divisor;

    public DataObject(List<CalcData> dataList, int dividend, int divisor) {
        super();
        this.dataList = dataList;
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public List<CalcData> getDataList() {
        return dataList;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataList == null) ? 0 : dataList.hashCode());
        result = prime * result + dividend;
        result = prime * result + divisor;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DataObject other = (DataObject) obj;
        if (dataList == null) {
            if (other.dataList != null)
                return false;
        } else if (!dataList.equals(other.dataList))
            return false;
        if (dividend != other.dividend)
            return false;
        if (divisor != other.divisor)
            return false;
        return true;
    }

}
