package datastructures.hashtable.leetcode.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * 題目：Longest Consecutive Sequence (最長連續序列)
 * 目標：給定一個未排序的整數陣列 nums，請找出其中「最長連續數列」的長度
 * (連續數列指的是元素的值依次遞增 1，例如 1, 2, 3, 4)
 * <p>
 * 規則：
 * - 必須使用 Set 結構來優化執行時間，以達到 O(n) 的時間複雜度
 * - 數字在原陣列中的原本位置並不重要，只要數值連續即可
 * - 回傳該最長序列的長度 (int)
 * <p>
 * 範例：
 * - Input: nums = [100, 4, 200, 1, 3, 2]
 * - Output: 4
 * (解釋：最長連續數列為 [1, 2, 3, 4]，其長度為 4)
 * <p>
 * 思路(HashSet)：
 * 1. 建立一個 HashSet<Integer>，將陣列 nums 中所有的數字全部存入
 * 2. 準備一個變數 longestStreak 記錄最長長度，初始設為 0
 * 3. 遍歷 Set 中的每一個元素 num：
 * a. 尋找序列起點：檢查 Set 中是否包含 (num - 1)
 * - 如果 "有" 包含：代表 num 只是某個序列的中間值，不是起點，直接跳過，這樣才能保證 O(n) 時間
 * - 如果 "沒有" 包含：代表 num 是一個全新連續序列的起點
 * b. 找到起點後，準備兩個變數：currentNum = num 與 currentStreak = 1
 * c. 利用 while 迴圈，不斷檢查 Set 中是否包含下一個數字 currentNum + 1
 * - 如果有，就將 currentNum 加 1，並將 currentStreak 加 1
 * d. 當 while 迴圈結束(找不到下一個數字)時，比較並更新 longestStreak
 * 4. 外層迴圈結束後，回傳 longestStreak
 */
public class LongestConsecutiveSequence {

    public int longestConsecutiveSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        int longestStreak = 0;

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }

            int currentNum = num;
            int currentStreak = 1;
            while (numSet.contains(currentNum + 1)) {
                currentStreak++;
                currentNum++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}
