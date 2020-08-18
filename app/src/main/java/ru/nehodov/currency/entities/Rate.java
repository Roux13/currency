package ru.nehodov.currency.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Rate {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String currency;

    private double rate;

    public Rate(long id, String currency, double rate) {
        this.id = id;
        this.currency = currency;
        this.rate = rate;
    }

    @Ignore
    public Rate(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
