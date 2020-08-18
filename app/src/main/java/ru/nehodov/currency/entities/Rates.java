package ru.nehodov.currency.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Rates {
    @SerializedName("HRK")
    private double hrk;
    @SerializedName("CHF")
    private double chf;
    @SerializedName("MXN")
    private double mxn;
    @SerializedName("ZAR")
    private double zar;
    @SerializedName("INR")
    private double inr;
    @SerializedName("TNB")
    private double thb;
    @SerializedName("CNY")
    private double cny;
    @SerializedName("AUD")
    private double aud;
    @SerializedName("ILS")
    private double ils;
    @SerializedName("KRW")
    private double krw;
    @SerializedName("JPY")
    private double jpy;
    @SerializedName("PLN")
    private double pln;
    @SerializedName("GBP")
    private double gbp;
    @SerializedName("IDR")
    private double idr;
    @SerializedName("HUF")
    private double huf;
    @SerializedName("PHP")
    private double php;
    @SerializedName("TRY")
    private double trY;
    @SerializedName("RUB")
    private double rub;
    @SerializedName("HKD")
    private double hkd;
    @SerializedName("ISK")
    private double isk;
    @SerializedName("EUR")
    private double eur;
    @SerializedName("DKK")
    private double dkk;
    @SerializedName("CAD")
    private double cad;
    @SerializedName("MYR")
    private double myr;
    @SerializedName("USD")
    private double usd;
    @SerializedName("BGN")
    private double bgn;
    @SerializedName("NOK")
    private double nok;
    @SerializedName("RON")
    private double ron;
    @SerializedName("SGD")
    private double sgd;
    @SerializedName("CZK")
    private double czk;
    @SerializedName("SEK")
    private double sek;
    @SerializedName("NZD")
    private double nzd;
    @SerializedName("BRL")
    private double brl;

    public List<Rate> getAllRates() {
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate("HRK", hrk));
        rates.add(new Rate("CHF", chf));
        rates.add(new Rate("MXN", mxn));
        rates.add(new Rate("ZAR", zar));
        rates.add(new Rate("INR", inr));
        rates.add(new Rate("THB", thb));
        rates.add(new Rate("CNY", cny));
        rates.add(new Rate("AUD", aud));
        rates.add(new Rate("ILS", ils));
        rates.add(new Rate("KRW", krw));
        rates.add(new Rate("JPY", jpy));
        rates.add(new Rate("PLN", pln));
        rates.add(new Rate("GBP", gbp));
        rates.add(new Rate("IDR", idr));
        rates.add(new Rate("HUF", huf));
        rates.add(new Rate("PHP", php));
        rates.add(new Rate("TRY", trY));
        rates.add(new Rate("RUB", rub));
        rates.add(new Rate("HKD", hkd));
        rates.add(new Rate("ISK", isk));
        rates.add(new Rate("EUR", eur));
        rates.add(new Rate("DKK", dkk));
        rates.add(new Rate("CAD", cad));
        rates.add(new Rate("MYR", myr));
        rates.add(new Rate("USD", usd));
        rates.add(new Rate("BGN", bgn));
        rates.add(new Rate("NOK", nok));
        rates.add(new Rate("RON", ron));
        rates.add(new Rate("SGD", sgd));
        rates.add(new Rate("CZK", czk));
        rates.add(new Rate("SEK", sek));
        rates.add(new Rate("NZD", nzd));
        rates.add(new Rate("BRL", brl));
        return rates;
    }

    public double getHrk() {
        return hrk;
    }

    public void setHrk(double hrk) {
        this.hrk = hrk;
    }

    public double getChf() {
        return chf;
    }

    public void setChf(double chf) {
        this.chf = chf;
    }

    public double getMxn() {
        return mxn;
    }

    public void setMxn(double mxn) {
        this.mxn = mxn;
    }

    public double getZar() {
        return zar;
    }

    public void setZar(double zar) {
        this.zar = zar;
    }

    public double getInr() {
        return inr;
    }

    public void setInr(double inr) {
        this.inr = inr;
    }

    public double getThb() {
        return thb;
    }

    public void setThb(double thb) {
        this.thb = thb;
    }

    public double getCny() {
        return cny;
    }

    public void setCny(double cny) {
        this.cny = cny;
    }

    public double getAud() {
        return aud;
    }

    public void setAud(double aud) {
        this.aud = aud;
    }

    public double getIls() {
        return ils;
    }

    public void setIls(double ils) {
        this.ils = ils;
    }

    public double getKrw() {
        return krw;
    }

    public void setKrw(double krw) {
        this.krw = krw;
    }

    public double getJpy() {
        return jpy;
    }

    public void setJpy(double jpy) {
        this.jpy = jpy;
    }

    public double getPln() {
        return pln;
    }

    public void setPln(double pln) {
        this.pln = pln;
    }

    public double getGbp() {
        return gbp;
    }

    public void setGbp(double gbp) {
        this.gbp = gbp;
    }

    public double getIdr() {
        return idr;
    }

    public void setIdr(double idr) {
        this.idr = idr;
    }

    public double getHuf() {
        return huf;
    }

    public void setHuf(double huf) {
        this.huf = huf;
    }

    public double getPhp() {
        return php;
    }

    public void setPhp(double php) {
        this.php = php;
    }

    public double getTrY() {
        return trY;
    }

    public void setTrY(double trY) {
        this.trY = trY;
    }

    public double getRub() {
        return rub;
    }

    public void setRub(double rub) {
        this.rub = rub;
    }

    public double getHkd() {
        return hkd;
    }

    public void setHkd(double hkd) {
        this.hkd = hkd;
    }

    public double getIsk() {
        return isk;
    }

    public void setIsk(double isk) {
        this.isk = isk;
    }

    public double getEur() {
        return eur;
    }

    public void setEur(double eur) {
        this.eur = eur;
    }

    public double getDkk() {
        return dkk;
    }

    public void setDkk(double dkk) {
        this.dkk = dkk;
    }

    public double getCad() {
        return cad;
    }

    public void setCad(double cad) {
        this.cad = cad;
    }

    public double getMyr() {
        return myr;
    }

    public void setMyr(double myr) {
        this.myr = myr;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getBgn() {
        return bgn;
    }

    public void setBgn(double bgn) {
        this.bgn = bgn;
    }

    public double getNok() {
        return nok;
    }

    public void setNok(double nok) {
        this.nok = nok;
    }

    public double getRon() {
        return ron;
    }

    public void setRon(double ron) {
        this.ron = ron;
    }

    public double getSgd() {
        return sgd;
    }

    public void setSgd(double sgd) {
        this.sgd = sgd;
    }

    public double getCzk() {
        return czk;
    }

    public void setCzk(double czk) {
        this.czk = czk;
    }

    public double getSek() {
        return sek;
    }

    public void setSek(double sek) {
        this.sek = sek;
    }

    public double getNzd() {
        return nzd;
    }

    public void setNzd(double nzd) {
        this.nzd = nzd;
    }

    public double getBrl() {
        return brl;
    }

    public void setBrl(double brl) {
        this.brl = brl;
    }
}
