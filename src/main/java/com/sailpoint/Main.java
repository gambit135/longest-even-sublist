package com.sailpoint;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Initial manual testing. See the MainTest class for more extensive testing scenarios.
        int[] arr = new int[]{2, 4, 6, 7, 8, 10, 11, 12, 14, 16, 18};
        List<Integer> longestSublistOfEvenNumbers = longestSublistOfEvenNumbers(arr);
        System.out.println("Longest even list is: " + longestSublistOfEvenNumbers.toString());

    }

    public static List<Integer> longestSublistOfEvenNumbers(int[] arr){

        //Current list of even numbers being transversed
        List<Integer> currentListOfEvenNumbers = new ArrayList<>();

        //List that will be returned, containing the largest group of even numbers
        List<Integer> largestListOfEvenNumbers = new ArrayList<>();

        for (int c : arr) {
            if (c % 2 == 0) {
                currentListOfEvenNumbers.add(c);

            }
            else {
                //If the recently reviewed list is larger than a previous large one
                if (currentListOfEvenNumbers.size() > largestListOfEvenNumbers.size()) {
                    //The recent list becomes the largest one
                    largestListOfEvenNumbers = currentListOfEvenNumbers;
                }

                //reset current variables
                currentListOfEvenNumbers = new ArrayList<>();
            }
        }

        //Final check in case the list ends in an even number.
        if (currentListOfEvenNumbers.size() > largestListOfEvenNumbers.size()) {
            //The recent list becomes the largest one
            largestListOfEvenNumbers = currentListOfEvenNumbers;
        }


        return largestListOfEvenNumbers;
    }
}
