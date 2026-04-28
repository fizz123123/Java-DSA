package algorithms;

import java.util.Arrays;

/*
Time：
  - Best & Average：O(n log n)
  - Worst：O(n^2)

Space：
  - Best & Average：O(log n)
  - Worst：O(n)

Worst Case：已排序的資料
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4, 1, 7, 6, 2, 3, 5};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            //1.取得基準點index
            int pivotIndex = pivot(array, left, right);

            //2.遞迴排序基準點左半部份
            quickSort(array, left, pivotIndex - 1);

            //3.遞迴排序基準點右半部份
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }

        swap(array, swapIndex, pivotIndex);
        return swapIndex;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
