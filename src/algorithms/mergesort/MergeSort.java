package algorithms.mergesort;

import java.util.Arrays;

//Time：O(n log n) ; Space：O(log n)
//Divide and Conquer
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1, 7, 3, 4, 2, 5, 6};
        int[] sortedArray = mergeSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0; //combined index
        int i = 0; //array1 index
        int j = 0; //array2 index

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index++] = array1[i++];
            } else {
                combined[index++] = array2[j++];
            }
        }

        while (i < array1.length) {
            combined[index++] = array1[i++];
        }

        while (j < array2.length) {
            combined[index++] = array2[j++];
        }

        return combined;
    }
}
