package vn.edu.likelion.manageBank.enums;

public enum InterestRateOf {
    NONE(0, 0),
    THREE_MONTH(0.019, 3),
    SIX_MONTH(0.029, 6),
    NINE_MONTH(0.029, 9),
    ONE_YEAR(0.046, 12),
    THREE_YEAR(0.047, 36),
    SIX_YEAR(0.047, 72);

    private final double iterestRate;
    private final int monthAmount;

    InterestRateOf(double iterestRate, int monthAmount) {
        this.iterestRate = iterestRate;
        this.monthAmount = monthAmount;
    }

    public double getIterestRate() {
        return this.iterestRate;
    }

    public int getMonthAmount() {
        return this.monthAmount;
    }
}
