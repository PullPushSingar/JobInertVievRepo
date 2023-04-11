package org.example;

import org.junit.After;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {


    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUp() {

        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void testMain() throws IOException {
        String input = "20 50\n3 2\n5 4\n7 6\n2 1\n8 5\n4 3\n6 7\n9 9\n1 2\n5 4\n7 6\n8 8\n3 3\n4 5\n6 7\n2 1\n1 2\n5 4\n8 6\n9 8\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));



        Main.main (new String[]{});






        String expectedOutput = "65\r\n";
        assertEquals(expectedOutput,outputStream.toString ());
    }
}