package ua.kiev.prog.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CharUtilsTest {

    @Test
    @Parameters({ "character", "ascii" })
    public void test2(char character, int ascii) {

        int result = CharUtils.CharToASCII(character);
        Assert.assertEquals(result, ascii);

    }

    @Test
    @Parameters({ "character", "ascii" })
    public void test1(final char character, final int ascii) {

        char result = CharUtils.ASCIIToChar(ascii);
        Assert.assertEquals(result, character);

    }
}