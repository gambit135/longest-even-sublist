package com.sailpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 6, 7, 8, 10, 11, 12, 14, 16, 18};
        List<Integer> longestSublistOfEvenNumbers = longestSublistOfEvenNumbers(arr);
        System.out.println("Longest even list is: " + longestSublistOfEvenNumbers.toString());

    }

    public static List<Integer> longestSublistOfEvenNumbers(int[] arr){

        //Current list of even numbers being transversed
        List<Integer> currentListOfEvenNumbers = new ArrayList<>();

        //List that will be returned, containing the largest group of even numbers
        List<Integer> largestListOfEvenNumbers = new ArrayList<>();

        //Size of actual list
        int sizeOfCurrentList = 0;

        //Size of largest list so far, for comparison
        int sizeOfLargestList = 0;

        for (int c : arr) {
            if (c % 2 == 0) {
                currentListOfEvenNumbers.add(c);
                sizeOfCurrentList++;
            }
            else {
                //If the recently reviewed list is larger than a previous large one
                if (sizeOfCurrentList > sizeOfLargestList) {
                    //The recent list becomes the largest one
                    sizeOfLargestList = sizeOfCurrentList;
                    largestListOfEvenNumbers = currentListOfEvenNumbers;
                }

                //reset current variables
                currentListOfEvenNumbers = new ArrayList<>();
                sizeOfCurrentList = 0;
            }
        }

        //Final check in case the list ends in an even number.
        if (sizeOfCurrentList > sizeOfLargestList) {
            //The recent list becomes the largest one
            sizeOfLargestList = sizeOfCurrentList;
            largestListOfEvenNumbers = currentListOfEvenNumbers;
        }


        return largestListOfEvenNumbers;
    }
}