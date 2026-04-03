package HT.leetcode.hashset;

import java.util.*;

/**
 * 題目：Find Pairs (跨陣列尋找和為目標值的配對)
 * 目標：給定兩個整數陣列 arr1 和 arr2，以及一個目標值 target，
 * 請找出所有的數對 (一數來自 arr1，一數來自 arr2)，使得兩數之和等於 target
 * <p>
 * 規則：
 * - 必須使用 Set (如：HashSet) 來優化尋找過程以達到 O(n + m) 的時間複雜度
 * - 根據測試要求，請將 arr1 的元素存入 Set 中作為尋找基準
 * - 回傳一個 List，裡面包含多個 int[]，每個 int[] 包含了符合條件的一對數字 [來自 arr1 的數, 來自 arr2 的數]
 * <p>
 * 範例：
 * - arr1 = [1, 2, 3]
 * - arr2 = [4, 5, 6]
 * - target = 7
 * - expected output: [[1, 6], [2, 5], [3, 4]]
 * <p>
 * 思路(HashSet)：
 * 1. 建立一個 HashSet<Integer> 來儲存 arr1 中的所有數字
 * (這樣就能在 O(1) 的時間內判斷某個數字是否存在於 arr1)
 * 2. 建立一個 List<int[]> 來準備存放符合條件的配對
 * 3. 遍歷 arr1，將所有的元素放入 Set 中
 * 4. 遍歷 arr2，對於 arr2 中的每一個數字 num2：
 * a. 計算達到 target 還缺少的數值 complement
 * b. 檢查 Set 中是否包含這個缺少的數值 complement：
 * - 如果包含：代表在 arr1 中找到了互相匹配的數字，建立一個陣列，並加入結果 List 中
 * 5. 迴圈結束後，回傳 List
 */
public class FindPairs {

    public List<int[]> findPairs(int[] arr1, int[] arr2, int target) {

        Set<Integer> arr1Set = new HashSet<>();

        for (int num1 : arr1) {
            arr1Set.add(num1);
        }

        List<int[]> pairs = new ArrayList<>();

        for (int num2 : arr2) {
            int complement = target - num2;

            if (arr1Set.contains(complement)) {
                pairs.add(new int[]{complement, num2});
            }
        }

        return pairs;
    }


}
