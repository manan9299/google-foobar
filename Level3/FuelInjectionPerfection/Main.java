package com.company;


import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        // System.out.println(solution("8"));
        System.out.println(solution("15"));
        // System.out.println(solution("9"));
        // System.out.println(solution("3"));
        System.out.println(solution("4"));
    }


    /**
     * Calculates the minimum number of operations required to reduce the number of pellets to one.
     * @param   x   String representing initial number of fuel pellets
     * @return  Returns the minimum number of operations required to reduce pellets to one.
     */
    public static int solution(String x) {

        final BigInteger ZERO = BigInteger.ZERO;
        final BigInteger ONE = BigInteger.ONE;
        final BigInteger THREE = BigInteger.valueOf(3);
        final BigInteger FOUR = BigInteger.valueOf(4);

        BigInteger numPellets = new BigInteger(x);
        int numOps = 0;

        while(!numPellets.equals(ONE)){

            if(numPellets.and(ONE).equals(ZERO)){
                // If number of pellets is even, greedily reduce it to half
                numPellets = numPellets.shiftRight(1);
            } else if (numPellets.equals(THREE) || numPellets.mod(FOUR).equals(ONE)){
                // If number of pallets is 3, or
                // number of pallets modulo 4 returns 1, reduce them by one
                numPellets = numPellets.subtract(ONE);
            } else {
                numPellets = numPellets.add(ONE);
            }

            numOps++;
        }

        return numOps;
    }
}
