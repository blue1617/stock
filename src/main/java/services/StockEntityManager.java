package services;

import model.Stock;
import model.StockSymbol;
import model.Trade;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by apreda on 11.06.2016.
 */
@Service
public interface StockEntityManager {

    void recordTrade(Trade trade);

    ArrayList<Trade> getTrades();

    Stock getStockBySymbol(StockSymbol stockSymbol);

    Set<Stock> getStocks();
}
