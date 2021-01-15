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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dividend == null) ? 0 : dividend.hashCode());
        result = prime * result + indent;
        result = prime * result + ((mult == null) ? 0 : mult.hashCode());
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
        CalcData other = (CalcData) obj;
        if (dividend == null) {
            if (other.dividend != null)
                return false;
        } else if (!dividend.equals(other.dividend))
            return false;
        if (indent != other.indent)
            return false;
        if (mult == null) {
            if (other.mult != null)
                return false;
        } else if (!mult.equals(other.mult))
            return false;
        return true;
    }

}
