package lab0;

public class Variant22 {

    /**
     * Swap the contents of variables A and B and display the new values of A and B.
     *
     * @param a variable
     * @param b variable
     * @return new values of a and b.
     */
    public Pair<Integer, Integer> inputOutputTask(int a, int b) {
        return new Pair<Integer, Integer>(b, a);
    }

    /**
     * N seconds have passed since the beginning of the day (N is an integer).
     * Find the number of seconds elapsed since the beginning of the last hour.
     *
     * @param n seconds have passed since the beginning of the day
     * @return the number of seconds elapsed since the beginning of the last hour.
     */
    public int integerTask(int n) {
        return n % 3600;
    }

    /**
     * A three-digit number is given. Check the truth of the statement:
     * "The numbers of a given number form an increasing or decreasing sequence."
     *
     * @param number three-digit number
     * @return true if the statement is true
     */
    public boolean booleanTask(int number) {
        if (number < 100 || number > 999) throw new IllegalArgumentException("Number should be 3 digit integer");

        final int firstDigit = number / 100;
        final int secondDigit = (number / 10) - (firstDigit * 10);
        final int thirdDigit = number % 10;

        System.out.println(firstDigit + " " + secondDigit + " " + thirdDigit);

        return (firstDigit > secondDigit && secondDigit > thirdDigit)
                || (firstDigit < secondDigit && secondDigit < thirdDigit);
    }

    /**
     * The coordinates of a point that does not lie on the coordinate axes OX and OY are given.
     * Determine the number of the coordinate quarter in which this point is located.
     *
     * @param x x
     * @param y y
     * @return the number of the coordinate quarter in which this point is located
     * @throws IllegalArgumentException if x or y is zero
     */
    public int conditionTask(int x, int y) {
        if (x > 0 && y > 0) return 1;
        if (x < 0 && y > 0) return 2;
        if (x < 0 && y < 0) return 3;
        if (x > 0 && y < 0) return 4;
        throw new IllegalArgumentException("X and Y can't be zero");
    }

    /**
     * Given an integer K. Print a description string for the score corresponding to the number K
     * (1 - “bad”, 2 - “unsatisfactory”, 3 - “satisfactory”, 4 - “good”, 5 - “excellent”).
     * If K does not lie in the range 1–5, then print the string “error”.
     *
     * @param k integer
     * @return description of mark or error if such mark don't exists
     */
    public String switchTask(int k) {
        switch (k) {
            case 1: return "very bad";
            case 2: return "bad";
            case 3: return "normal";
            case 4: return "good";
            case 5: return "excellent";
            default: return "error";
        }
    }

    /**
     * Given a real number X and an integer N (> 0). Find the value of an expression
     * 1 + X + X2 / (2!) + ... + XN / (N!)
     * The resulting number is an approximate value of the function exp at point X.
     *
     * @param x float
     * @param n integer (> 0)
     * @return value of expression
     * @throws IllegalArgumentException if n <= 0
     */
    public float forTask(float x, int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");

        float result = 1, xPow = 1, fact = 1;
        for (int i = 1; i <= n; i++) {
            xPow *= x;
            fact *= i;
            result += xPow / fact;
        }

        return result;
    }

    /**
     * Given an integer N (> 1). If it is simple, that is, it does not have positive divisors,
     * except 1 and itself, then print True, otherwise print False.
     *
     * @param n integer (> 1)
     * @return true if it is simple
     */
    public boolean whileTask(int n) {
        if (n <= 1) throw new IllegalArgumentException("n must be greater than 1");

        int i = 2, sqrt = (int)Math.sqrt(n);
        while (i <= sqrt) {
            if (n % i == 0)
                return false;
            i++;
        }

        return true;
    }

    /**
     * Given an array of size N and integers K and L (1 < K < L < N).
     * Find the sum of all elements of the array, except elements with numbers from K to L inclusive.
     *
     * @param arr array
     * @param k start position
     * @param l end position
     * @return sum of elements from start to end positions
     */
    public int arrayTask(Integer[] arr, int k, int l) {
        if (k < 1 || k > l || l > arr.length) throw new IllegalArgumentException("Statement (1 < K < L < N) must be true");
        int result = 0;
        for (int i = k; i <= l; i++) {
            result += arr[i];
        }
        return result;
    }

    /**
     * A matrix of size M x N is given.
     * For each column of the matrix with an even number (2, 4, ...), find the sum of its elements.
     * Do not use conditional operator.
     *
     * @param arr matrix
     * @return array with sums of even columns numbers
     */
    public Integer[] twoDimensionTask(Integer[][] arr) {
        int m = arr.length, n = arr[0].length, resultIndex = 0;
        Integer[] result = new Integer[n / 2];
        for (int i = 1; i < n; i += 2) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += arr[j][i];
            }
            result[resultIndex++] = sum;
        }
        return result;
    }
}
