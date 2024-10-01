package org.example.fizzbuzz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a number 'n', for each integer 1 to n (inclusive) print one value per line as follows:
 *  - if 'i' is a multiple of both 3 and 5 => FizzBuzz
 *  - if 'i' is a multiple of 3 (but not 5) => Fizz
 *  - if 'i' is a multiple of 5 (but not 3) => Buzz
 *  - if not multiple 3 or 5 => print i value.
 *
 * Constrains: 0 < n < 2*10^5
 */

public class FizzBuzz {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        fizzBuzz(n);

        bufferedReader.close();
    }

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        if (n < 0) {
            throw new UnsupportedOperationException("Negative value!");
        }
        if (n > 2 * 100000) {
            throw new UnsupportedOperationException("To high value!");
        }

        for (int inputValue = 1; inputValue <= n; inputValue++) {
            double divideByThree = inputValue % 3;
            double divideByFive = inputValue % 5;

            System.out.println("INPUT VALUE=" + inputValue + " divide by 3= " + divideByThree + " | divide by 5= " + divideByFive);

            if (divideByThree == 0 && divideByFive == 0) {
                System.out.println("FizzBuzz");
            }
            if (divideByThree == 0 && divideByFive != 0) {
                System.out.println("Fizz");
            }
            if (divideByFive == 0 && divideByThree != 0) {
                System.out.println("Buzz");
            }
            if (divideByFive != 0 && divideByThree != 0) {
                System.out.println(inputValue);
            }
        }

    }
}
