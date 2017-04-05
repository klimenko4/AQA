package ua.kiev.prog.week2.hotline;

/**
 * Created by Zver on 03.04.2017.
 */
public enum PriceRange  {
    PRICE_RANGE_2500_3500(2500, 3500),
    PRICE_RANGE_3500_5000(3500, 5000),
    PRICE_RANGE_5000_7500(5000, 7500),
    PRICE_RANGE_7500_10000(7500, 10000);

    private final int minPrice;
    private final int maxPrice;
    private final String rangeString;

    PriceRange(int minPrice, int maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.rangeString = minPrice + "-" + maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public String getRangeString() {
        return rangeString;
    }

}
