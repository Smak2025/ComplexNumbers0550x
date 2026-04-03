package ru.gr0550x.math;

import java.text.DecimalFormat;

public class TComplex extends Complex{

    public TComplex(double r, double phi){
        var re = r * Math.cos(phi);
        var im = r * Math.sin(phi);
        super(re, im);
    }

    public TComplex(double r, int phi){
        var rad = phi / 180.0 * Math.PI;
        this(r, rad);
    }

    public TComplex(Complex z){
        this(z.getAbs(), z.getArg());
    }

    public Complex toComplex(){
        return new Complex(getRe(), getIm());
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        var df = new DecimalFormat("#.###############");
        if (getRe() == 0.0 && getIm() == 0.0) {
            builder.append("0");
        } else {
            var abs = df.format(getAbs());
            builder.append(abs);
            var arg = df.format(getArg());
            builder.append("(cos(");
            builder.append(arg);
            builder.append(") + i sin(");
            builder.append(arg);
            builder.append("))");
        }
        return builder.toString();
    }
}
