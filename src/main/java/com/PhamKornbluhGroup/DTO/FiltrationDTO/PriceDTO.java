package com.PhamKornbluhGroup.DTO.FiltrationDTO;

import java.util.Objects;

public class PriceDTO {
    private String currencyType = "";
    private int quantity;
    private long timestamp;

    public PriceDTO() {
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PriceDTO priceDTO)) return false;
        return quantity == priceDTO.quantity && timestamp == priceDTO.timestamp && Objects.equals(currencyType, priceDTO.currencyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyType, quantity, timestamp);
    }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "currencyType='" + currencyType + '\'' +
                ", quantity=" + quantity +
                ", timestamp=" + timestamp +
                '}';
    }

    public boolean isPriceValid() {

        if (this.currencyType == null) {
            return false;
        }
        if (this.currencyType.equals("")) {
            return false;
        }
        if (this.quantity == 0) {
            return false;
        }
        return true;
    }

    public double calculatePriceInChaos() {
        if (!this.isPriceValid()) {
            return 0;
        }
        double valueOfCurrencyTypeInChaos = calculateValueOfCurrencyTypeInChaos();
        double totalCostToPurchaseInChaos = valueOfCurrencyTypeInChaos * this.getQuantity();

        return totalCostToPurchaseInChaos;
    }

    private double calculateValueOfCurrencyTypeInChaos() {
        /* TODO:
            - Replace hardcoded values by instead calling to poe.ninja to get the actual value of the currency, or
            alternatively, call GGG merchant price API for hourly updates
                - Do these calls once per hour w/ a cron job, etc
                - Include all major currencies listed here:
                    - https://www.pathofexile.com/trade/about
                - Store the results in a new internal table
                - Query that table when performing this conversion
        */
        switch (currencyType) {
            case "chaos" -> {
                return 1d;
            }
            // Pretending divine orb is worth exactly 300 chaos
            case "divine" -> {
                return 300d;
            }
            // Pretending annulment orb is worth exactly 15 chaos
            case "annul" -> {
                return 15d;
            }
            // Pretending Mirror of Kalandra is worth exactly 150k chaos
            case "mirror" -> {
                return 150000d;
            }
        }
        return 0d;
    }
}
