package com.pravin.clock;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * ClockTest class
 * 
 * @author pravin.dilpak
 * @since 05-07-2023
 *
 */

public class ClockTest {
	@Rule
    public ExpectedException exceptionRule = ExpectedException.none();

	//when entered chars instead of integers
    @Test
    public void testCase1() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("You need to pass a valid 24 hour format hour");
        Clock clock = new Clock("12:aa");
        clock.displayTime();
    }

    //when entered semicolon instead of colon
    @Test
    public void testCase2() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("You need to pass a valid 24 hour format hour");
        Clock clock = new Clock("12;13");
        clock.displayTime();
    }

    // midday time
    @Test
    public void testCase3() {
    	Clock clock = new Clock("12:00");
        clock.displayTime();
        assertEquals("It's Midday", clock.getResult());
    }

    //midnight time
    @Test
    public void testCase4() {
    	Clock clock = new Clock("24:00");
        clock.displayTime();
        assertEquals("It's Midnight", clock.getResult());
    }

    @Test
    public void testCase5() {
        Clock clock = new Clock("12:50");
        clock.displayTime();
        assertEquals("It's twelve fifty ", clock.getResult());
    }

    @Test
    public void testCase6() {
        Clock clock = new Clock("13:00");
        clock.displayTime();
        assertEquals("It's one ", clock.getResult());
    }

    @Test
    public void testCase7() {
        Clock clock = new Clock("14:06");
        clock.displayTime();
        assertEquals("It's two oh six ", clock.getResult());
    }

    @Test
    public void testCase8() {
        Clock clock = new Clock("18:15");
        clock.displayTime();
        assertEquals("It's five fifteen ", clock.getResult());
    }
    
    @Test
    public void testCase9() {
        Clock clock = new Clock("00:00");
        clock.displayTime();
        assertEquals("It's zero zero ", clock.getResult());
    }

}
