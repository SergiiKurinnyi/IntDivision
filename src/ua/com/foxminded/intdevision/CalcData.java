package ua.com.foxminded.intdevision;

public class CalcData {
    private int indent;
    private String dividend;
    private String mult;

    public CalcData(int indent, String dividend, String mult) {
        this.indent = indent;
        this.dividend = dividend;
        this.mult = mult;
    }

    public int getIndent() {
        return indent;
    }

    public String getDividend() {
        return dividend;
    }

    public String getMult() {
        return mult;
    }

}
