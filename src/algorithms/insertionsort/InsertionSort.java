package algorithms.insertionsort;

//Note：Insertion Sort 的最佳時間複雜度為 O(n)，發生在陣列已排序或幾乎已排序的情況下
public class InsertionSort {

    public void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int current = array[i];//要插入的元素
            int prevIndex = i - 1;

            while (prevIndex >= 0 && current < array[prevIndex]) {
                array[prevIndex + 1] = array[prevIndex];//較大的元素往後移
                prevIndex--;//繼續檢查前面的元素
            }
            array[prevIndex + 1] = current;//找到正確位置，插入current
        }
    }
}
