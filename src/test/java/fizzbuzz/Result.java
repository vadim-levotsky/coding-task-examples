package fizzbuzz;

public class Result {

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
