import ru.gr0550x.math.Complex;

void main() {
    var z = new Complex(1.0, 2.5);
    System.out.println(z);
    var z2 = new Complex(2.0, -0.5);
    z.plus(z2);
}