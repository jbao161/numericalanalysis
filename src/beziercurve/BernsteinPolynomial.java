/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beziercurve;

import numutil.Polynomial;

/**
 *
 * @author jbao
 */
public class BernsteinPolynomial extends numutil.Polynomial {

    /**
     * B(i,n)(t) = nCi * t^i * (1-t)^(n-i)
     *
     * @param i index
     * @param n degree
     */
    public BernsteinPolynomial(int i, int n) {
        Polynomial result = new Polynomial();
        result.put(0.0, 1.0); // start the bernstein polynomial at constant = 1
        // (1-t) ^ n - i 
        Polynomial singlePair = new Polynomial(new double[]{1.0, -1.0}); // set the polynomial (1-t)
        for (int k = 0; k < n - i; k++) {
            result = result.times(singlePair);
        }
        // binomial coefficient
        double binomCoef = numutil.MathTools.binomial(n, i);
        // nCi * t^i
        Polynomial tPow = new Polynomial(new double[][]{{i, binomCoef}});
        result = result.times(tPow);
        become(result);
    }
  
    /* comments:
     * 1. the bernstein polynomials form a partition of unity: sum(i =0 to n) bern(i,n)(t) = 1 because binomial theorem with x= t, y = 1-t
     */
}
