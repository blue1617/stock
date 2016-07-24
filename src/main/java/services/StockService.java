package services;

import model.StockSymbol;
import model.Trade;
import org.springframework.stereotype.Service;

/**
 * Created by apreda on 11.06.2016.
 */
@Service
public interface StockService {

    double calculateDividendYield(Trade trade);

    /**
     *
     * @param stockSymbol
     * @return the price earning ratio
     */
    double calculatePERatio(Trade stockSymbol);
    void recordTrade(Trade trade);
    double calculateStockPrice(StockSymbol trade);
    double calculateGBCEAllShareIndex();
}
