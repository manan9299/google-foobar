package com.company;

public class Main {

    public static void main(String[] args) {

        int[] l1 = {1, 3, 5, 2, 4, 6};
        System.out.println(solution(l1));

        int[] l2 = {1, 1, 1, 1};
        System.out.println(solution(l2));

    }

    /**
     * Calculates the number of lucky triplets which can be used as access codes from a given list of integers
     * @param   l   List of integers
     * @return  Returns the number of possible access codes
     */
    public static int solution(int[] l) {

        int lenList = l.length;

        // If length is less than 3, no triplets are possible, return 0
        if(lenList < 3) return 0;

        int[] numMultiplesToRight = calculateNumMultiplesToRight(l);

        int numLuckyTriplets = 0;
        for(int left = 0; left < lenList - 2; left++){
            for(int right = left + 1; right < lenList - 1; right++){
                // If element on right is a multiple of element on left
                // add the corresponding number of numMultiplesToRight of right element to total count of lucky triplets
                if(l[right] % l[left] == 0){
                    numLuckyTriplets += numMultiplesToRight[right];
                }
            }
        }

        return numLuckyTriplets;
    }


    /**
     * Calculates the number of multiples of an element which are present to the right of an element in a given list
     * @param  l List of integers
     * @return Returns an integer array with corresponding count of multiples to it's right for each element
     */
    private static int[] calculateNumMultiplesToRight(int[] l){
        int lenList = l.length;

        int[] numMultiplesToRight = new int[lenList];

        for(int left = 0; left < lenList - 1; left++){
            int numMultiples = 0;
            for(int right = left + 1; right < lenList; right++){
                // if element on right is a multiple of element on left
                // increment the left element's numMultiples count
                if(l[right] % l[left] == 0){
                    numMultiples++;
                }
            }

            numMultiplesToRight[left] = numMultiples;
        }

        return numMultiplesToRight;
    }
}
