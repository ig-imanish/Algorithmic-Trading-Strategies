import java.util.List;

public interface TradingStrategy {
    void initialize(List<Double> prices);
    TradeDecision makeDecision(double currentPrice);
}
