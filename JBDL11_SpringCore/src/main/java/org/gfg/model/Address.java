package org.gfg.model;

public class Address {

    String line;
    String city;
    int pincode;


    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "line='" + line + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
