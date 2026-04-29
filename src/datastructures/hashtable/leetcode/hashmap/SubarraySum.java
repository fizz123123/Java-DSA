package datastructures.hashtable.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 題目：Subarray Sum (尋找和為目標值的連續子陣列索引)
 * 目標：給定一個整數陣列 nums 和一個整數目標值 target，請找出該陣列中「連續子陣列」和為 target 的起點與終點索引
 * <p>
 * 規則：
 * - 「子陣列」指的是陣列中一段連續的非空元素序列
 * - 必須使用 HashMap 來解決此問題
 * - 回傳包含兩個整數的陣列：[起始索引, 結束索引]，代表該子陣列的範圍
 * - 若存在多個符合條件的子陣列，回傳找到的第一個即可
 * - 若找不到符合條件的子陣列，請回傳空陣列 (new int[]{})
 * <p>
 * 範例：
 * - nums = [1, 2, 3, 4, 5], target = 9
 * - Expected Output: [1, 3]
 * (因為 nums[1] + nums[2] + nums[3] = 2 + 3 + 4 = 9)
 * <p>
 * 思路：(Prefix Sum + HashMap)
 * 核心觀念：利用 前綴和(Prefix Sum) 的概念，如果 當前累積和 - 之前的某個累積和 == target
 * (currentSum - previousSum = target)，代表這中間的一段連續子陣列的總和剛好就是 target
 * <p>
 * ==================================================================
 * //起點(0) ----------------------------------> 當前位置 (currentSum)
 * //       \______/   \________________/
 * //       previousSum    target (想找的區間)
 * ==================================================================
 * <p>
 * 1.建立一個 HashMap<Integer, Integer> 來紀錄已經遍歷過的 prefixSum 和 其index
 * - Key：累積總和 (Prefix Sum)
 * - Value：該總和發生的 Index 位置
 * 2.關鍵初始化：在迴圈開始前，先放入 hashMap.put(0, -1)
 * 代表 prefix Sum 為 0 的情況發生在索引 -1 (這樣如果從索引 0 開始相加剛好等於 target，才能正確抓到起點 0)
 * 3.宣告變數 currentSum = 0 記錄目前的累積和
 * 4.使用for迴圈遍歷 nums 陣列：
 * a. 累加當前數字：currentSum += nums[i]
 * b. 計算尋找目標 (差值)：prevSum = currentSum - target
 * c. 檢查 HashMap 中是否已經存在這個差值：
 * - 如果有：代表從 "該差值發生的索引的下一個位置" 到 "當前位置i" 的這段子陣列，總和剛好就是 target，馬上回傳陣列
 * d. 若沒找到：將當前的 currentSum 與當前索引 i 放入 HashMap 中
 * 5. 迴圈結束後若都都沒有找到，回傳空陣列
 */
public class SubarraySum {

    public int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1);//避免當subarray的index是從0開始時會碰到的edge case

        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            int prevSum = currentSum - target;

            if (sumIndexMap.containsKey(prevSum)) {
                int prevSumIndex = sumIndexMap.get(prevSum);
                return new int[]{prevSumIndex + 1, i};
            }

            sumIndexMap.put(currentSum, i);
        }

        return new int[]{};
    }


}
