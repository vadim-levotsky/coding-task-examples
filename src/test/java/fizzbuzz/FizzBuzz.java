package fizzbuzz;

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

        Result.fizzBuzz(n);

        bufferedReader.close();
    }
}
