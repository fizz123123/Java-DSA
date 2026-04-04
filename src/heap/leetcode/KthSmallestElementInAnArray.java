package heap.leetcode;

import heap.MyHeap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 題目：Kth Smallest Element in an Array (尋找陣列中第 K 小的元素)
 * 實作一個方法，用來找出陣列 nums 中第 k 小的元素
 * <p>
 * 限制與要求：
 * - 必須使用「最大堆積 (Max-Heap)」來解決此問題
 * - 時間複雜度必須優於 O(n log n) (不能直接把陣列拿去排序)
 * <p>
 * 範例：
 * input：
 * - int[] nums = {7, 10, 4, 3, 20, 15};
 * - int k = 3;
 * expected output：7 (陣列中 第3小 的數字是 7)
 * <p>
 * ==========================================
 * 思路(MaxHeap)：
 * 1. 準備一個 Max-Heap
 * 2. 遍歷陣列中的每一個數字，將其加入 Heap 中
 * 3. 如果 Heap 的大小超過了 k，就將 Heap 頂端 (當前最大值) 的元素移除
 * 4. 這樣 Heap 裡面永遠只會保留目前看過 "最小的 k 個數字"
 * 5. 遍歷結束後，Heap 頂端的元素就會是這 k 個數字中最大的，也就是整個陣列中 "第 k 小" 的元素
 */
public class KthSmallestElementInAnArray {

    //----------作答1：使用自定義類別-----------
    public int findKthSmallest(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("無效的輸入");
        }

        MyHeap maxHeap = new MyHeap();

        for (int num : nums) {
            maxHeap.insert(num);

            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.remove();
    }

    //----------作答2：使用Java提供的 PriorityQueue 類別---------
    public int findKthSmallest2(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("無效的輸入");
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);

            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.peek();
    }
}
