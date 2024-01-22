/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tennisScore.tennisScoreTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/*
: In order to capture the output written to the console during the tests,
you might want to create a utility class like TestUtils to redirect the standard output.
Here's a simple example in the code below:
Note: Ensure to call redirectSystemOut() before running your tests
and restoreSystemOut() afterward to restore the original system output.
 */

public class TestUtils {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    public static void redirectSystemOut() {
        System.setOut(new PrintStream(outContent));
    }

    public static void restoreSystemOut() {
        System.setOut(originalOut);
    }

    public static String getConsoleOutput() {
        return outContent.toString();
    }
}

