package org.example;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests
{

    Calculator c = Calculator.getCalculator();

    @Test
    public void largest_value_test()
    {
        int[] input = {-20, 5, 62, 45, -300, 4};
        int expected = 62;
        Assert.assertEquals(expected,c.largestValue(input));
    }

    @Test
    public void test_reverse_string()
    {
        String input = "Hello world!";
        String expected = "!dlrow olleH";
        Assert.assertEquals(expected, c.reverseString(input));
    }

    @Test
    public void palindrome_test()
    {
        String input = "racecar";
        boolean expected = true;
        Assert.assertEquals(expected, c.isPalindrome(input));



    }

    @Test
    public void palindrome_test_false()
    {
        String input = "Hello world!";
        boolean expected = false;
        Assert.assertEquals(expected, c.isPalindrome(input));
    }

    @Test
    public void anagram_test_true()
    {
        String input1 = "listen";
        String input2 = "silent";
        boolean expected = true;
        Assert.assertEquals(expected, c.isAnagram(input1, input2));
    }

    @Test
    public void anagram_test_false()
    {
        String input1 = "Hello";
        String input2 = "World";
        boolean expected = false;
        Assert.assertEquals(expected, c.isAnagram(input1, input2));
    }

    @Test
    public void anagram_test_edge_case_same_string_input()
    {
        String input1 = "Hello";
        String input2 = "Hello";
        boolean expected = false;
        Assert.assertEquals(expected, c.isAnagram(input1,input2));
    }

    @Test
    public void anagram_test_edge_case_strange_casing()
    {
        String input1 = "siLent";
        String input2 = "liSten";
        boolean expected = true;
        Assert.assertEquals(expected, c.isAnagram(input1, input2));
    }

}
