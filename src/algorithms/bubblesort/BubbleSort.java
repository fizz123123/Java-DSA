package algorithms.bubblesort;

public class BubbleSort {

    public void bubbleSort(int[] array) {

        //i：每一輪要把最大的數字推到 index i 的位置
        for (int i = array.length - 1; i > 0; i--) {

            //j：只檢查還沒被推到 index i 的數字
            for (int j = 0; j < i; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
