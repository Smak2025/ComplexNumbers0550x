package ru.gr0550x.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @Test
    @DisplayName("Тестирование конструктора по умолчанию")
    void defaultConstructorTest(){
        var z = new Complex();
        var expectedRe = 0.0;
        var expectedIm = 0.0;
        var actualRe = z.getRe();
        var actualIm = z.getIm();
        Assertions.assertEquals(expectedRe, actualRe);
        Assertions.assertEquals(expectedIm, actualIm);
    }

    @Test
    @DisplayName("Тестирование конструктора с параметрами")
    void constructionTest(){
        var z = new Complex(1.0, -2.5);
        var expectedRe = 1.0;
        var expectedIm = -2.5;
        var actualRe = z.getRe();
        var actualIm = z.getIm();
        Assertions.assertEquals(expectedRe, actualRe);
        Assertions.assertEquals(expectedIm, actualIm);
    }

    @ParameterizedTest
    @DisplayName("Преобразование в строку")
    @CsvSource({
            "1.0, 0.0, 1.0",
            "1.0, 2.5, 1.0+2.5i",
            "0.0, 1.0, i",
            "0.0, -1.0, -i",
            "-1.0, 0.0, -1.0",
            "0.0, 0.0, 0.0",
            "-2.3, -26.5, -2.3-26.5i",
            "1.0, -2.3, 1.0-2.3i",
            "-5.5, 7.5, -5.5+7.5i",
            "Infinity, 2.0, Infinity+2.0i",
            "-Infinity, 2.0, -Infinity+2.0i",
            "2.0, Infinity, 2.0+Infinity i",
            "2.0, -Infinity, 2.0-Infinity i",
            "Infinity, Infinity, Infinity+Infinity i",
            "-Infinity, -Infinity, -Infinity-Infinity i",
            "NaN, 2.0, NaN",
            "2.0, NaN, NaN"
    })
    void toStringTest(double re, double im, String expected){
        var z = new Complex(re, im);
        var actual = z.toString();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Сложение комплексных чисел")
    @MethodSource("plusArgsGenerator")
    void plusTest(Complex z1, Complex z2, Complex expected){
        var actual = z1.plus(z2);
        assertEquals(expected, actual); // expected.equals(actual)
    }

    private static Stream<Arguments> plusArgsGenerator(){
        var z = new Complex(3.0, 3.0);
        return Stream.of(new Arguments[]{
                Arguments.of(new Complex(1.0, 2.0), new Complex(-1.0, 1.0), new Complex(0.0, 3.0)),
                Arguments.of(new Complex(0.0, 0.0), new Complex(5.0, 1.0), new Complex(5.0, 1.0)),
                Arguments.of(z, z, new Complex(6.0, 6.0)),
        });
    }

    @ParameterizedTest
    @DisplayName("HashCode")
    @MethodSource("hashCodeArgsGenerator")
    void hashCodeTest(Complex z1, Complex z2, boolean expected){
        var h1 = z1.hashCode();
        var h2 = z2.hashCode();
        var actual = h1 == h2;
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> hashCodeArgsGenerator(){
        var builder = Stream.<Arguments>builder();
        builder.add(Arguments.of(new Complex(1.0, 2.0), new Complex(1.0, 2.0), true));
        builder.add(Arguments.of(new Complex(0.0, 1.0), new Complex(3.0, -7.0), false));
        builder.add(Arguments.of(new Complex(-3.0, 5.0), new Complex(5.0, -3.0), false));
        builder.add(Arguments.of(new Complex(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY), new Complex(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY), true));
        return builder.build();
    }

    @ParameterizedTest
    @DisplayName("HashCode2")
    @MethodSource("hashCode2ArgsGenerator")
    void hashCode2Test(Complex z1, double d, boolean expected){
        var h1 = z1.hashCode();
        var h2 = Double.hashCode(d);
        var actual = h1 == h2;
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> hashCode2ArgsGenerator(){
        var builder = Stream.<Arguments>builder();
        builder.add(Arguments.of(new Complex(1.0, 0.0), 1.0, true));
        return builder.build();
    }

    @Test
    @DisplayName("Умножение с присвоением")
    void timesAssignTest(){
        var z1 = new Complex(3.0, 1.0);
        var z2 = new Complex(3.0, 1.0);
        z1.timesAssign(z2);
        assertEquals(new Complex(8, 6), z1);
    }
}