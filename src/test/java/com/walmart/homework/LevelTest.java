package com.walmart.homework;

import java.util.Collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LevelTest {
    LevelName name = new LevelName("Test Name");
    MonetaryAmount price = new MonetaryAmount(15.50);
    int rows = 4;
    int seats = 10;
    int id = 1;


    @Test
    public final void testLevel() {
        Level level = makeLevel();
        assertNotNull("Level not created.\n", level);
    }

    @Test
    public final void testHoldNumberOfSeats() {
        Level level = makeLevel();
        int seatsRequested = 5;
        int intialCount = level.numSeatsAvailable();
        int expected = intialCount - seatsRequested;

        level.holdNumberOfSeats(seatsRequested);

        int count = level.numSeatsAvailable();
        assertEquals("Wrong number of seats after hold request.\n", expected, count);
    }

    @Test
    public final void testNumSeatsAvailable() {
        Level level = makeLevel();
        assertEquals("Wrong number of seats after initialization.\n",
                     level.numSeatsAvailable(),
                     rows * seats);
    }


    @Test
    public final void testLevelReleaseSeats() {
        Level level = makeLevel();
        int seatsRequired = 5;
        int intialCount = level.numSeatsAvailable();
        int expected = intialCount - seatsRequired;
        Collection<Seat> seats = level.holdNumberOfSeats(seatsRequired);

        int count = level.numSeatsAvailable();
        assertEquals("Wrong number of seats after hold request.\n", count, expected);

        // seats.asScala.map(level.releaseSeat(_));
        seats.stream().forEach( seat -> level.releaseSeat(seat) );
        count = level.numSeatsAvailable();
        assertEquals("Wrong number of seats after hold release.\n", count, intialCount);
    }
    

    @Test
    public final void testLevelReserve() {
        fail("Not implemented\n.");
        
        // val level = makeLevel;
        // val seatCount = 5;
        // val intialCount = level.numSeatsAvailable;
        // val seats = level.holdNumberOfSeats(seatCount);
        // val expected = intialCount - seatCount;

        // var count = level.numSeatsAvailable;
        // assert(count == expected, s"Field ${count} != ${expected}");

        // seats.asScala.map(level.reserveSeat(_));
        // count = level.numSeatsAvailable;
        // assert(count == expected, s"Field ${count} != ${expected}");

  } // testLevelReserve()

    protected Level makeLevel() {
        return new Level(id, name, price, rows, seats);
    }

}
