package org.example;

import java.util.Arrays;

public class Calculator
{
    private static final Calculator calculator = new Calculator();

    public static Calculator getCalculator()
    {
        return calculator;
    }

    private Calculator(){}


    public int[] fibonacci(int iterations)
    {
        int[] result = new int[iterations];

        for(int i = 0; i < result.length; i++)
            result[i]=fib(i);

        return result;
    }

    private int fib(int num)
    {
        if (num <=1)
            return num;
        return fib(num-1) + fib(num - 2);
    }


    public String[] fizzBuzz(int iterations)
    {
        String[] result = new String[iterations];

        for (int i = 1; i <= result.length; i++)
        {
            int index = i - 1; //starting value is 1
            if(i%3==0 && i%5==0)
                result[index] = "FizzBuzz";
            else if(i%3==0)
                result[index] = "Fizz";
            else if(i%5==0)
                result[index] = "Buzz";
            else
                result[index] = Integer.toString(i);
        }

        return result;
    }

    public int largestValue(int[] array)
    {
        int largest = -2147483648;
        for (int j : array)
            if (j > largest)
                largest = j;

        return largest;
    }


    public String reverseString (String string)
    {
        String reverse = "";
        for(int i = 0 ; i < string.length() ; i++)
            reverse = string.charAt(i) + reverse;

        return reverse;
    }

    public boolean isPalindrome (String string)
    {
        String check = reverseString(string);
        return check.equals(string);
    }


    public boolean isAnagram (String str1, String str2)
    {
        String string1 = str1.toLowerCase();
        String string2 = str2.toLowerCase();
        if(string1.equals(string2))
            return false;

        char[] cArr1 = string1.toCharArray();
        char[] cArr2 = string2.toCharArray();
        int length1 = cArr1.length;
        int length2 = cArr2.length;

        if(length1 != length2)
            return false;

        Arrays.sort(cArr1);
        Arrays.sort(cArr2);

        for(int i = 0; i < length1 ; i++)
            if (cArr1[i] != cArr2[i])
                return false;

        return true;
    }
}
