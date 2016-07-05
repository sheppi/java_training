package com.epam.tasks.task3;

import com.epam.tasks.task3.SpecialCalculator;
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
public class SpecialCalculatorTest {

    private double numberA, numberB;
    private double expectedPerimeter, expectedSquare;
    private static final double epsilon = 0.00001;

    public SpecialCalculatorTest(double numberA, double numberB, double expectedPerimeter, double expectedSquare) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expectedPerimeter = expectedPerimeter;
        this.expectedSquare = expectedSquare;
    }

    @Parameterized.Parameters(name = "{index}: Perimeter of triangle with {0} and {1} - {2}, square - {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1, 1},
                {2, 1, 1, 1},
                {0, 1, 1, 1},
                {-1, 0, 0, 0}
        });
    }

    @Test
    public void calculatePerimeter() throws Exception {
        assertEquals(expectedPerimeter, SpecialCalculator.calculatePerimeter(numberA, numberB), epsilon);
    }

    @Test
    public void calculateSquare() throws Exception {
        assertEquals(expectedSquare, SpecialCalculator.calculateSquare(numberA, numberB), epsilon);
    }

}