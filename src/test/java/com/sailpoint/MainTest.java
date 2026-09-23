package com.sailpoint;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the Main class.
 *
 */
class MainTest {

    @Test
    void returnsLongestEvenGroup() {
        int[] arr = {1, 2, 4, 6, 3, 8, 10};

        List<Integer> result = Main.longestSublistOfEvenNumbers(arr);

        assertEquals(List.of(2, 4, 6), result);
    }

    @Test
    void returnsEmptyListWhenThereAreNoEvenNumbers() {
        int[] arr = {1, 3, 5};

        assertEquals(
                List.of(),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void returnsFirstGroupWhenLongestGroupsAreTied() {
        int[] arr = {2, 4, 1, 6, 8};

        assertEquals(
                List.of(2, 4),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void returnsLongestGroupWhenItEndsAtTheEndOfTheArray() {
        int[] arr = {2, 4, 6, 7, 8, 10, 11, 12, 14, 16, 18};

        assertEquals(
                List.of(12, 14, 16, 18),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void returnsEntireArrayWhenEveryNumberIsEven() {
        int[] arr = {2, 4, 6, 8};

        assertEquals(
                List.of(2, 4, 6, 8),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void returnsEmptyListForAnEmptyArray() {
        int[] arr = {};

        assertEquals(
                List.of(),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void returnsSingleEvenNumber() {
        int[] arr = {2};

        assertEquals(
                List.of(2),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void treatsZeroAndNegativeEvenNumbersAsEven() {
        int[] arr = {1, -2, 0, -4, 3, 6};

        assertEquals(
                List.of(-2, 0, -4),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void doesNotJoinGroupsSeparatedByConsecutiveOddNumbers() {
        int[] arr = {2, 4, 1, 3, 6, 5};

        assertEquals(
                List.of(2, 4),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void returnsEmptyListForSingleOddNumber() {
        assertEquals(
                List.of(),
                Main.longestSublistOfEvenNumbers(new int[]{3})
        );
    }

    @Test
    void keepsFirstTiedGroupWhenBothGroupsEndBeforeArrayEnd() {
        // Tests a tie handled inside the loop, rather than by the final check.
        int[] arr = {2, 4, 1, 6, 8, 3};

        assertEquals(
                List.of(2, 4),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void handlesMinimumAndMaximumIntegerValues() {
        // MIN_VALUE is even; MAX_VALUE is odd.
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 3};

        assertEquals(
                List.of(Integer.MIN_VALUE, 0),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }

    @Test
    void replacesEarlierBestWithLongerGroupBeforeArrayEnd() {
        int[] arr = {2, 4, 1, 6, 8, 10, 3};

        assertEquals(
                List.of(6, 8, 10),
                Main.longestSublistOfEvenNumbers(arr)
        );
    }
}
