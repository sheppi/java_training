package com.epam.tasks.task2;

import com.epam.tasks.task2.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
@RunWith(value = Parameterized.class)
public class CalculatorTest {
    private String numberA, numberB, numberC;
    private double expected;
    private static final double epsilon = 0.00001;

    public CalculatorTest(String numberA, String numberB, String numberC, double expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.numberC = numberC;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: ({1}+sqrt({1}^2+4*{0}*{2}))/(2*{0}) - ({0}^3)*{2} + {1}^(-2)) = {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1", "1", "1", 1.61803398},
                {"1", "2", "3", 0.25},
                {"0", "1", "1", Double.POSITIVE_INFINITY},
                {"4", "1", "a", 0},
        });
    }

    @Test
    public void test_calculating() {
        assertEquals(expected, Calculator.execute(numberA, numberB, numberC), epsilon);
    }


}