package ch17;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATE_FORМAT = "МММ dd уууу HH:mm:ss";
    private String code;
    private double price;
    private Date date = new Date();
    private DateFormat dateFormat = new SimpleDateFormat(DATE_FORМAT);

    public Stock(){}
    public Stock(String code, double price){
        this.code =code;
        this.price = price;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getDateForмat() {
        return DATE_FORМAT;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDateFormatted() {
        return dateFormat.format(date);
    }
}
