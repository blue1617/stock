package model;

/**
 * Created by apreda on 11.06.2016.
 */
public class Stock {

    private StockSymbol symbol;
    private StockType type;
    private double lastDividend;
    private Double fixedDividend;
    private double parValue;

    public StockSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(StockSymbol symbol) {
        this.symbol = symbol;
    }

    public double getParValue() {
        return parValue;
    }

    public void setParValue(double parValue) {
        this.parValue = parValue;
    }

    public Double getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(Double fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public StockType getType() {
        return type;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    public double getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(double lastDividend) {
        this.lastDividend = lastDividend;
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Stock stockToCompare = (Stock) obj;
        return symbol.equals(stockToCompare.getSymbol()) && type.equals(((Stock) obj).getType());
    }
}
