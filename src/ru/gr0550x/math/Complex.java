package ru.gr0550x.math;

import java.text.DecimalFormat;
import java.util.Objects;

public class Complex {
    private double re;
    private double im;

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public double getAbs(){
        return Math.sqrt(re*re + im*im);
    }

    public double getArg(){
        return Math.atan2(im, re);
    }

    public Complex(){
        re = 0.0;
        im = 0.0;
    }

    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }

    public Complex plus(Complex that){
        return new Complex(this.re + that.re, im + that.im);
    }

    public Complex minus(Complex that){
        return new Complex(this.re - that.re, this.im - that.im);
    }

    public Complex times(Complex that){
        return new Complex(
                this.re * that.re - this.im * that.im,
                this.re * that.im + that.re * this.im
        );
    }

    public Complex div(Complex that){
        var den = that.re * that.re + that.im * that.im;
        return new Complex(
                (this.re * that.re + this.im * that.im)/den,
                (that.re * this.im - this.re * that.im)/den
        );
    }

    public void plusAssign(Complex that){
        this.re += that.re;
        this.im += that.im;
    }

    public void minusAssign(Complex that){
        this.re -= that.re;
        this.im -= that.im;
    }

    public void timesAssign(Complex that){
        var tmp = this.re * that.re - this.im * that.im;
        this.im = this.re * that.im + that.re * this.im;
        this.re = tmp;
    }

    @Override
    public String toString() {
        if (Double.valueOf(re).isNaN() || Double.valueOf(im).isNaN())
            return "NaN";
        var sb = new StringBuilder();
        var epsilon = 1e-15;
        var df = new DecimalFormat("#.###############");
        if (Math.abs(re) > epsilon || Math.abs(im) < epsilon) {
            sb.append(df.format(re));
        }
        if (Math.abs(im) > epsilon){
            if (im > 0.0) {
                if (Math.abs(re) > epsilon) sb.append("+");
            }
            else sb.append("-");
            if (Math.abs(im - 1.0) > epsilon) {
                sb.append(df.format(Math.abs(im)));
            }
            if (Double.valueOf(im).isInfinite())
                sb.append(" ");
            sb.append("i");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Complex that){
            return this.re == that.re && this.im == that.im;
        }
        if (obj instanceof Number that){
            return this.im == 0.0 && this.re == that.doubleValue();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
//        var result = 0;
//        result = 31 * result + Double.hashCode(im);
//        result = 31 * result + Double.hashCode(re);
//        return result;
    }
}
