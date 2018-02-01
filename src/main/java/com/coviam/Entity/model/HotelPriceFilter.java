package com.coviam.Entity.model;

public class HotelPriceFilter {

    private String min;
    private String max;

    public HotelPriceFilter(String min, String max) {
        this.min = min;
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "HotelPriceFilter{" +
                "min='" + min + '\'' +
                ", max='" + max + '\'' +
                '}';
    }
}
