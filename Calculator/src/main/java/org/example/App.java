package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculator c = Calculator.getCalculator();

        int num = 10;
        int[] x = c.fibonacci(num);


        for (int i = 0 ; i < num ; i++)
            System.out.print(x[i] + " ");

        System.out.println();
        num = 100;
        String[] s = c.fizzBuzz(num);
        for (String string : s)
            System.out.print(string + " ");

    }
}
