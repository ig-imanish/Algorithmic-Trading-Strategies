import java.util.List;

public class MeanReversionStrategy implements TradingStrategy {
    private double mean;
    private double stdDev;
    private double threshold;

    public MeanReversionStrategy(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public void initialize(List<Double> prices) {
        // Calculate mean and standard deviation of historical prices
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        mean = sum / prices.size();

        double sumSquaredDiff = 0;
        for (double price : prices) {
            sumSquaredDiff += Math.pow(price - mean, 2);
        }
        stdDev = Math.sqrt(sumSquaredDiff / prices.size());
    }

    @Override
    public TradeDecision makeDecision(double currentPrice) {
        // Determine if current price deviates significantly from the mean
        if (Math.abs(currentPrice - mean) > threshold * stdDev) {
            if (currentPrice < mean) {
                return TradeDecision.BUY; // Buy when price is below mean
            } else {
                return TradeDecision.SELL; // Sell when price is above mean
            }
        } else {
            return TradeDecision.HOLD; // Hold when price is near mean
        }
    }
}
