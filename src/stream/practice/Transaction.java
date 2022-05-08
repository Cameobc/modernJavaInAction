package stream.practice;

public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + this.trader +
                ", year=" + this.year +
                ", value=" + this.value +
                '}';
    }

    public int getValue() {
        return value;
    }
}
