package hashtable.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 題目：Two Sum(兩數之和)
 * 目標：給定一個整數陣列 nums 和一個整數目標值 target，
 * 請在該陣列中找出「和為目標值」的兩個整數，並回傳它們的索引 (Indices)
 * <p>
 * 規則：
 * - 必須使用 HashMap 來解決此問題，以達到 O(n) 的時間複雜度
 * - 每種輸入皆確保只會對應到「一個」有效的答案
 * - 不能重複使用陣列中同一個位置 (同一個索引) 的元素
 * - 回傳的索引順序不限，回傳型別為整數陣列 int[]
 * - 若找不到符合條件的組合，通常回傳空的陣列 (例如 new int[0])
 * <p>
 * 範例：
 * - Input：nums = [2, 7, 11, 15], target = 9
 * - Expected Output：[0, 1]
 * (因為 nums[0] + nums[1] = 2 + 7 = 9)
 * <p>
 * 思路(HashMap)：
 * 1. 建立一個 HashMap<Integer, Integer> 儲存遍歷過的數字
 * - Key：存數字本身
 * - Value：存該數字的索引(index)
 * 2. 遍歷nums陣列
 * a. 計算要達到 target 還缺少的另一半數值：complement
 * b. 檢查 HashMap 中是否已經存在這個 complement (缺少的數字)
 * - 如果有找到：代表我們之前已經遇過它了，這兩數之和剛好是 target，直接回傳 int[index1,index2]
 * - 如果沒找到：把當前的數字與其索引存入 HashMap 中，留給後面的數字來配對
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }

            hashMap.put(nums[i], i);
        }

        return new int[]{};
    }
}
