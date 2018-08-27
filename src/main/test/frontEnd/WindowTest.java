package main.test.frontEnd;


import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WindowTest {

    private int bubu;

    @BeforeEach
    void setUp() {
        bubu = 1;
    }

    @AfterEach
    void tearDown() {

    }



    @Test
    public void testHokuspokus() {
        assert(1 == 1);
        assertTrue("hugo".equals("hugo"));

    }

    @Test
    public void testHokuspokus2() {
        assertFalse(1 == 2);
    }
}
