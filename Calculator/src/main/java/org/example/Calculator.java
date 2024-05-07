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






    public int fibonacci(int num)
    {
        if (num <=1)
            return num;
        return fibonacci(num-1) + fibonacci(num - 2);
    }

    public String fizzBuzz(int i)
    {
        if(i%3==0 && i%5==0)
            return "FizzBuzz";
        else if(i%3==0)
            return "Fizz";
        else if(i%5==0)
            return "Buzz";
        else
            return Integer.toString(i);
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

        return Arrays.equals(cArr1, cArr2);
    }

    public boolean isEven(int number)
    {
        if (number == 0)
            return false;
        return number % 2 == 0;
    }

    //a is value 1, b is value 2, n is the cap on loops
    //n will be at least 1 (we'll put a catch to make sure that's the case also at a later point)
    public int funWithExponents(int val1, int val2, int loops)
    {

        //base calculation is (a + 2^0 * b)
        //each iteration puts an additional ( + 2^n-1 * b) to the end
        /*
        for example, three iterations makes:
        (a + 2^0 * b + 2^1 * b + 2^2 * b);
         */
        /*
        it looks like there's a function within a function here, so it's:
        f(a, b, n) = (a + loop[n](f2(b, n)))
        f2(b, n) = (2^(n-1) * b)
         */

        int loopResult = 0;
        for(int x = 0; x < loops; x++)
        {
            loopResult += funWithExponents2(val2, x);
            System.out.print(loopResult+val1 + " ");
        }

        return loopResult + val1;


    }
        private int funWithExponents2(int val2, int power)
        {
            //exponent section
            int p;  //placeholder for the loop
            int x = 1;
            final int CALC = 2;
            for(p = power; p !=0; p--)
                x = x * CALC;
            //x is 2^(n-1) and val is b
            return x * val2;
        }


}
