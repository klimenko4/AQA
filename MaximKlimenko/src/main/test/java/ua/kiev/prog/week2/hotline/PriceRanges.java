package ua.kiev.prog.week2.hotline;

public enum PriceRanges {
    range_2500_3500(1,2500,3500);

    private final int index;
    private final int minPrice;
    private final int maxPrice;


    PriceRanges(int index, int minPrice, int maxPrice) {

        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }
}
