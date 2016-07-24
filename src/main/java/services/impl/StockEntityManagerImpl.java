package services.impl;

import model.Stock;
import model.StockSymbol;
import model.Trade;
import org.springframework.stereotype.Component;
import services.StockEntityManager;

import java.util.*;

/**
 * Created by apreda on 11.06.2016.
 */
@Component
public class StockEntityManagerImpl implements StockEntityManager {


    /**
     *
     */
    private Set<Stock> stocks = null;

    /**
     *
     */
    private List<Trade> trades = null;

    public StockEntityManagerImpl() {
        stocks = new HashSet<>();
        trades = new ArrayList<>();
    }

    public void recordTrade(Trade trade) {
        trades.add(trade);
    }

    public ArrayList<Trade> getTrades() {
        return (ArrayList<Trade>) trades;
    }

    public Stock getStockBySymbol(final StockSymbol stockSymbol) {
        return stocks.stream().filter(stock -> stock.getType().equals(stockSymbol)).iterator().next();
    }

    @Override
    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }
}
