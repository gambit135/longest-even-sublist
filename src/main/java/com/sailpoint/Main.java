package com.sailpoint;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Initial manual testing. See the MainTest class for more extensive testing scenarios.
        int[] arr = new int[]{2, 4, 6, 7, 8, 10, 11, 12, 14, 16, 18};
        List<Integer> longestSublistOfEvenNumbers = longestSublistOfEvenNumbers(arr);
        System.out.println("Longest even list is: " + longestSublistOfEvenNumbers);
    }

    /**
     * This is still not the optimal solution, since it uses O(n) additional working space, without counting the actual result.
     * However, it works and is somewhat easy to read
     * @param arr   An array containing odd an even numbers
     * @return The longest continuous sublist of even numbers
     */
    public static List<Integer> longestSublistOfEvenNumbers(int[] arr){

        //Current list of even numbers being transversed
        List<Integer> currentListOfEvenNumbers = new ArrayList<>();

        //List that will be returned, containing the largest group of even numbers
        List<Integer> largestListOfEvenNumbers = new ArrayList<>();

        //Needed to know when a new even sublist starts
        boolean previousWasEven = false;

        for (int c : arr) {
            boolean currentIsEven = c % 2 == 0;

            if (currentIsEven) {
                //Checks if this is a new series of even numbers, so that it creates a new list only on this particular case
                if (!previousWasEven) {
                    currentListOfEvenNumbers = new ArrayList<>();
                }
                currentListOfEvenNumbers.add(c);
            }
            else {

                //If the recently reviewed list is larger than a previous large one
                if (currentListOfEvenNumbers.size() > largestListOfEvenNumbers.size()) {
                    //The recent list becomes the largest one
                    largestListOfEvenNumbers = currentListOfEvenNumbers;
                }
            }
            previousWasEven = currentIsEven;
        }

        //Final check in case the list ends in an even number.
        if (currentListOfEvenNumbers.size() > largestListOfEvenNumbers.size()) {
            //The recent list becomes the largest one
            largestListOfEvenNumbers = currentListOfEvenNumbers;
        }


        return largestListOfEvenNumbers;
    }
}
