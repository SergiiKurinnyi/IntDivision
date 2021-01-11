package ua.com.foxminded.intdevision;

public class CalcData {
    private int indent;
    private String dividend;
    private String mem;

    public CalcData(int indent, String dividend, String mem) {
        this.indent = indent;
        this.dividend = dividend;
        this.mem = mem;
    }

    public int getIndent() {
        return indent;
    }

    public String getDividend() {
        return dividend;
    }

    public String getMem() {
        return mem;
    }

}
