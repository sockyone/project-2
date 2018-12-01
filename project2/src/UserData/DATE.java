/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package UserData;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author nghun
 */
public class DATE {
    public String day;
    public String month;
    public String year;
    public String hour;

    public DATE() {
    }

    
    
    public DATE(String day, String month, String year, String hour) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
    
    
    
    public DATE getCurrentTime()
    {
        DATE temp = new DATE();
        Date current = new Date();
        String arr = current.toString();
        String []array = arr.split(" ");
        temp.hour = array[3];
        temp.day = array[2];
        temp.month = array[1];
        temp.year = array[5];
        
        return temp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DATE other = (DATE) obj;
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        if (!Objects.equals(this.month, other.month)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        if (!Objects.equals(this.hour, other.hour)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + hour + " " + day + " " + month + " " + year  ;
    }
    
    
}
    

    
    