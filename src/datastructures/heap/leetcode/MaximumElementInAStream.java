package datastructures.heap.leetcode;

import datastructures.heap.MyHeap;

import java.util.*;

/**
 * 題目：Maximum Element in a Stream (串流中的最大元素)
 * 實作一個方法，接收一個陣列 nums，此陣列代表一個不斷進來的 "數字串流"，
 * 請在每處理一個新進來的數字時，記錄下「到目前為止所看過的最大數字」，
 * 並將這些當前最大值依序收集到 List 中並回傳
 * <p>
 * 限制與要求：
 * - 必須使用「最大堆積 (Max-Heap)」來解決此問題
 * <p>
 * 輸入參數：
 * - nums: 一個整數陣列，代表依序進來的數字串流
 * <p>
 * 輸出要求：
 * - 回傳一個 List<Integer>，長度會與 nums 完全相同，
 * List 內的每一個元素代表「讀取到對應進度時，出現過的最大數字」
 * <p>
 * 範例：
 * - input：int[] nums = {1, 5, 2, 9, 3, 6, 8};
 * - output：[1, 5, 5, 9, 9, 9, 9]
 * 解釋：
 * 讀到 1 -> 當前最大值是 1
 * 讀到 5 -> 當前最大值是 5
 * 讀到 2 -> 之前看過的最大值還是 5
 * 讀到 9 -> 刷新最大值，變為 9
 * 讀到 3 -> 最大值依然是 9
 * 讀到 6 -> 最大值依然是 9
 * 讀到 8 -> 最大值依然是 9
 * ==========================================
 * 思路：
 * 1. 初始化一個 Max-Heap
 * 2. 準備一個用來儲存結果的 List<Integer>
 * 3. 遍歷輸入進來的每一個數字
 * 4. 將當前數字加入 Max-Heap 中
 * 5. 此時 Max-Heap 頂端的元素(即目前為止的最大值)，就是該回合的答案，將其加到結果 List 內
 * 6. 遍歷結束後，回傳 List
 */
public class MaximumElementInAStream {

    //----------作答1：使用自定義類別-----------
    public List<Integer> streamMax(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        MyHeap maxHeap = new MyHeap();
        List<Integer> maxList = new ArrayList<>();

        for (int num : nums) {
            maxHeap.insert(num);
            maxList.add(maxHeap.getHeap().get(0));
        }
        return maxList;
    }

    //----------作答2：使用Java提供的 PriorityQueue 類別---------
    public List<Integer> streamMax2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> maxList = new ArrayList<>();

        for (int num : nums) {
            maxHeap.add(num);
            maxList.add(maxHeap.peek());
        }
        return maxList;
    }
}
