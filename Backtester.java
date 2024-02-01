import java.util.List;

public class Backtester {
    public static void main(String[] args) {
        // Backtesting logic
        String symbol = "AAPL"; // Example stock symbol
        int backtestDays = 100; // Number of days for backtesting
        List<Double> historicalPrices = MarketData.getHistoricalPrices(symbol, backtestDays);

        // Initialize strategy
        TradingStrategy strategy = new MeanReversionStrategy(1.5); // Example threshold

        // Initialize strategy with historical prices
        strategy.initialize(historicalPrices);

        // Simulate trading based on the strategy
        for (double price : historicalPrices) {
            TradeDecision decision = strategy.makeDecision(price);
            // Execute trades based on decision (not implemented in this example)
            System.out.println("Price: " + price + ", Decision: " + decision);
        }
    }
}
