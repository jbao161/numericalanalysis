/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.lang.ArithmeticException;

/**
 *
 * @author jbao
 */
public class MathTools {

    public static int sign(double value) {
        if (Double.isNaN(value)) {
            throw new ArithmeticException("invalid input: " + value + " is not a number");
        }
        if (value > 0) { // allows positive infinity
            return 1;
        }
        if (value < 0) { // allows negative infinity
            return -1;
        }
        return 0;
    }

    public static double factorial(int value) {
        double result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }
        return result;
    }

    public static double min(double[][] data) {
        double result = Double.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] < result) {
                result = data[i][0];
            }
        }
        return result;
    }

    public static double max(double[][] data) {
        double result = Double.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] > result) {
                result = data[i][0];
            }
        }
        return result;
    }

    public static double logBase(double base, double number) {
        if (base == 0) {
            return number;
        } else {
            double result = Math.log(number) / Math.log(base);
            return result;
        }
    }

    public static double binomial(int n, int k) {
        double numerator = factorial(n);
        double denom = factorial(k) * factorial(n - k);
        return numerator / denom;
    }
}
