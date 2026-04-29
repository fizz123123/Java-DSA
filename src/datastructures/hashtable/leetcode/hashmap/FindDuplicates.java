package datastructures.hashtable.leetcode.hashmap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 題目：Find Duplicates (尋找重複元素)
 * 目標：撰寫一個方法 findDuplicates，找出整數陣列中所有「出現超過一次」的數字
 * <p>
 * 規則：
 * - 必須使用 HashMap 來解決此問題
 * - 回傳一個包含所有重複數字的 List<Integer>（順序不限）
 * - 時間複雜度需求 O(n)
 * <p>
 * 範例：
 * - Case 1: nums = [4, 3, 2, 7, 8, 2, 3, 1]
 * - expected output: [2, 3] (因為 2 和 3 出現了超過一次)
 * <p>
 * 思路(HashMap)：
 * 1. 建立一個 HashMap<Integer, Integer> 來記錄每個數字出現的次數
 * - (Key存數字，Value存該數字出現的次數)
 * 2. 遍歷陣列 nums，依序更新 HashMap 中的計數
 * 3. 建立一個 ArrayList 存放結果
 * 4. 遍歷 HashMap (使用 entrySet() 或 keySet())，
 * 把 Value 大於 1 的 Key 加入 ArrayList 中並回傳
 */
public class FindDuplicates {

    //---------------作答1------------------
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    //----------作答2：Using Stream API-------------
    public List<Integer> findDuplicates1(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
