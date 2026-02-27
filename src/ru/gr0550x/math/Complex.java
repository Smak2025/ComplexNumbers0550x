package ru.gr0550x.math;

public class Complex {
    private double re;
    private double im;

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public Complex(){
        re = 0.0;
        im = 0.0;
    }

    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }

    public Complex plus(Complex other){
        return new Complex(this.re + other.re, im + other.im);
    }

    @Override
    public String toString() {
        if (Double.valueOf(re).isNaN() || Double.valueOf(im).isNaN())
            return "NaN";
        var sb = new StringBuilder();
        if (re != 0.0 || im == 0.0) sb.append(re);
        if (im != 0.0){
            if (im > 0.0) {
                if (re != 0.0) sb.append("+");
            }
            else sb.append("-");
            if (Math.abs(im) != 1.0)
                sb.append(Math.abs(im));
            if (Double.valueOf(im).isInfinite())
                sb.append(" ");
            sb.append("i");
        }
        return sb.toString();
    }
}
