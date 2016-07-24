package services.impl;

import model.StockSymbol;
import model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import services.StockEntityManager;
import services.StockService;
import utils.DateUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by apreda on 24.07.2016.
 */
public class StockServiceImpl implements StockService {
    @Autowired
    private StockEntityManager entityManager;

    @Override
    public double calculateDividendYield(Trade trade) {
        double dividendYield = 0;
        switch (trade.getStock().getType()) {
            case COMMON:
                dividendYield = trade.getStock().getLastDividend() / trade.getPrice();
                break;
            case PREFERRED:
                dividendYield = trade.getStock().getParValue() / trade.getPrice();
                break;
        }

        return dividendYield;
    }

    @Override
    public double calculatePERatio(Trade trade) {
        return trade.getPrice() / trade.getStock().getLastDividend();
    }

    @Override
    public void recordTrade(Trade trade) {
        entityManager.recordTrade(trade);
    }

    @Override
    public double calculateStockPrice(StockSymbol stockSymbol) {
        double result = 0;

        Stream<Trade> streamWithValidTrades = entityManager.getTrades().stream().filter(trade -> stockSymbol.equals(trade.getStock().getSymbol()) && DateUtils.timeInLast15Minutes(trade.getTimestamp()));
        long numberOfTrades = entityManager.getTrades().stream().filter(trade -> stockSymbol.equals(trade.getStock().getSymbol()) && DateUtils.timeInLast15Minutes(trade.getTimestamp())).count();
        double sum = streamWithValidTrades.
                mapToDouble(trade -> trade.getPrice() * trade.getQuantity()).sum();
        result = sum / numberOfTrades;
        return result;
    }

    @Override
    public double calculateGBCEAllShareIndex() {
        double multipliedPriced = 1;
        for (Trade trade : entityManager.getTrades()) {
            multipliedPriced = multipliedPriced * trade.getPrice();
        }
        return Math.sqrt(multipliedPriced);
    }

    public StockEntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(StockEntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
