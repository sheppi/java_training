package com.epam.tasks.task6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Kirill_Kaluga on 7/1/2016.
 */
@RunWith(value = Parameterized.class)
public class WorkerTest {
    private double numberA, numberB, numberC;
    private double expected;
    private static final double epsilon = 0.00001;

    public WorkerTest(double numberA, double numberB, double numberC, double expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.numberC = numberC;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: sum min({0},{1},{2}) and max({0},{1},{2}) = {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1, 2},
                {1, 2, 3, 4},
                {-5, -10, 1, -9},
                {4, 1, 1, 5},
        });
    }

    @Test
    public void test_calculating() {
        assertEquals(expected, Worker.calculate(numberA, numberB, numberC), epsilon);
    }


}