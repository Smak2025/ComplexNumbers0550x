package ru.gr0550x.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TComplexTest {

    @Test
    @DisplayName("Корректное представление тригонометрической формы записи компл. числа в виде строки")
    void testToStringOfTComplex() {
        var z = new TComplex(1, 3.14);
        var expected = "1(cos(3,14) + i sin(3,14))";
        var actual = z.toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Корректное представление тригонометрической формы записи компл. числа в виде строки")
    void testToStringOfComplex() {
        var z = new Complex(1, 0);
        TComplex tz = new TComplex(z);
        var expected = "1(cos(0) + i sin(0))";
        var actual = tz.toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Корректное представление алгебраической формы записи компл. числа в виде строки")
    void testToStringOfComplexFromTComplex() {
        TComplex tz = new TComplex(1, 180);
        Complex z = tz.toComplex();
        var actual = z.toString();
        var expected = "-1";
        assertEquals(expected, actual);
    }
}