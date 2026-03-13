package ru.gr0550x.math;

public class TComplex extends Complex{

    public TComplex(double r, double phi){
        var re = r * Math.cos(phi);
        var im = r * Math.sin(phi);
        super(re, im);
    }

    @Override
    public String toString() {
        return "";
    }
}
