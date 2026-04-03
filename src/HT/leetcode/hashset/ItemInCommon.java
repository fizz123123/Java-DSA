package HT.leetcode.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * 題目：Item In Common (尋找共同元素)
 * 目標：撰寫一個方法，判斷兩個給定的整數陣列 (Arrays) 中，是否至少包含一個相同的元素
 * <p>
 * 規則：
 * - 若有共同元素回傳 true，完全沒有共同元素則回傳 false
 * - 時間複雜度需求 O(n)（建議使用 Hash Table 避免 O(n^2) 的雙層迴圈）
 * - 應善用 HashMap 查找時間為 O(1) 的特性
 * <p>
 * 範例：
 * - Case 1: array1 = [1, 3, 5], array2 = [2, 4, 5]
 * - Output: true (因為共用元素 5)
 * - Case 2: array1 = [1, 3, 5], array2 = [2, 4, 6]
 * - Output: false (沒有任何共同元素)
 * <p>
 * 思路:(Hash Table)
 */
public class ItemInCommon {

    //---------------作答1：O(n^2)------------------
    public boolean itemInCommon(int[] array1, int[] array2) {
        for (int i : array1) {
            for (int j : array2) {
                if (i == j) return true;
            }
        }
        return false;
    }

    //---------------作答2：O(n)------------------
    public boolean itemInCommon1(int[] array1, int[] array2) {
        Set<Integer> mySet = new HashSet<>();

        for (int i : array1) {
            mySet.add(i);
        }

        for (int j : array2) {
            if (mySet.contains(j)) {
                return true;
            }
        }
        return false;
    }
}