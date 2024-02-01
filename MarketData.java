import java.util.ArrayList;
import java.util.List;

public class MarketData {
    public static List<Double> getHistoricalPrices(String symbol, int days) {
        // Fetch historical prices from a data source (mocked data for demonstration)
        List<Double> prices = new ArrayList<>();
        // Mocked historical prices
        for (int i = 0; i < days; i++) {
            prices.add(100.0 + Math.random() * 20); // Random price between 100 and 120
        }
        return prices;
    }
}
