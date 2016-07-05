package com.epam.tasks.task10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Kirill_Kaluga on 7/4/2016.
 */

public class WorkerTest {

    @Test
    public void createMatrixTest() throws Exception {
        int[][] expected = new int[][]{
                {1,2,3,4},
                {4,3,2,1},
                {1,2,3,4},
                {4,3,2,1},
        };
        assertArrayEquals(expected, Worker.createMatrix(4));
    }

}