package ru.gr0550x.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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


}