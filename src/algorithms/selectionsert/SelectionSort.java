package algorithms.selectionsert;

public class SelectionSort {

    public void selectionSort(int[] array) {

        //只需跑到倒數第二個元素
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            //找出尚未排序的區間中，最小值的index位置
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
