package com.PhamKornbluhGroup.DTO.FiltrationDTO;

public class ChartData {
    private double value;
    private Long timeStamp;

    public ChartData() {
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "value=" + value +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
