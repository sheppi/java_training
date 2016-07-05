package com.epam.tasks.task1;

import com.epam.tasks.task1.Checker;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class CheckerTest {

    @Test
    public void execute1st() throws Exception {
        assertTrue("4224", Checker.execute("4224"));
    }

    @Test
    public void execute2nd() throws Exception {
        assertFalse("7788", Checker.execute("7788"));
    }

    @Test
    public void execute3rd() throws Exception {
        assertFalse("9009 stop that nigga", Checker.execute("9009 stop that nigga"));
    }

    @Test
    public void execute4th() throws Exception {
        assertFalse("200$", Checker.execute("200$"));
    }

}