package com.epam.tasks.task4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
@RunWith(value = Parameterized.class)
public class PointCheckerTest {
    private double numberA, numberB;
    private boolean expected;
    private static final double epsilon = 0.00001;

    public PointCheckerTest(double numberA, double numberB, boolean expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Is point at ({0},{1}) in figure? - {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, true},
                {2, 1, true},
                {0, 1, true},
                {0, 1, true},
                {2.0000001, 0.0000001, false},
                {-5, -5, false}
        });
    }

    @Test
    public void checkerTest() throws Exception {
        assertEquals(expected, Checker.checker(numberA, numberB));
    }
}