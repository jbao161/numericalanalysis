/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numutil;

import java.lang.ArithmeticException;
import java.util.Arrays;

/**
 *
 * @author jbao
 */
public class MathTools {

    public static double[] Copy(double[] array) {
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

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

    public static double factorial(double value) {
        double result = 1;
        for (double i = value; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static double binomNum(double value, int numOfTerms) {
        double result = 1;
        for (double i = value; i > value - numOfTerms; i--) {
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

    /**
     * converts a list of multidimensional points into a list of coordinates
     * grouped by their dimension. (its just a matrix transpose)
     *
     * @param listOfDimensionalPoints input format: {p1,p2, ...} for points p1 =
     * {x1,y1,..}, p2 = {x2,y2,..}
     * @return same dimension coordinates are grouped into arrays
     * {{x1,x2,...},{y1,y2,...},...}
     */
    public static double[][] pointToCoordinateArray(double[][] listOfDimensionalPoints) {
        int numOfPoints = listOfDimensionalPoints.length;
        int numOfDimensions = listOfDimensionalPoints[0].length; // must all be same dimensions!
        double[][] result = new double[numOfDimensions][numOfPoints];
        for (int i = 0; i < numOfDimensions; i++) {
            for (int j = 0; j < numOfPoints; j++) {
                result[i][j] = listOfDimensionalPoints[j][i];
            }
        }
        return result;
    }

    /**
     * calculates the expected return from a random buying game
     *
     * @param iterations how many times you resell your unwanted purchases
     * @param successRate chance of getting the purchase you want
     * @param sellRate the percent return from selling a purchase you don't want
     * @return
     */
    public static double returnRate(int iterations, double successRate, double sellRate) {
        double earnings = successRate;
        double reinvestment = 1 - earnings;
        double cash;
        for (int i = 0; i < iterations; i++) {
            cash = reinvestment * sellRate;
            earnings += cash * successRate;
            reinvestment = cash * (1 - successRate);
            System.out.println("cash: " + cash);
            System.out.println("resell earnings: " + cash * successRate);
        }
        return earnings;
    }
    
    public static void print(double[] array){
        System.out.println(Arrays.toString(array));
    }
}
