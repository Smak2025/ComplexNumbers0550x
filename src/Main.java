import ru.gr0550x.math.Complex;
import ru.gr0550x.math.TComplex;

void main() {
    var z = new Complex(1.0, 2.5);
    System.out.println(z);
    var z2 = new Complex(2.0, -0.5);
    z.plus(z2);
    System.out.println(Double.hashCode(0.0));

    TComplex z3 = new TComplex(1.0, 3.14159265358979323);
    System.out.println(z3);
    System.out.println(z3.getAbs());
    System.out.println(z3.getArg());
}