package com.numberToText.numberToText.Model;

public class FileResponseTime {
    private int hour;
    private int minute;
    private String time;

    public int getHour() {
        return hour;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
