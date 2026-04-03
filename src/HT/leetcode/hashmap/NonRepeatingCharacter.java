package HT.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 題目：First Non-Repeating Character (尋找第一個不重複的字元)
 * 目標：撰寫一個方法，找出只包含小寫字母的字串中「第一個且不重複」的字元
 * <p>
 * 規則：
 * - 必須使用 HashMap 來解決此問題
 * - 回傳該字元 (Character 型別)
 * - 若字串中沒有任何不重複的字元，則回傳 null
 * - 建議時間複雜度需求 O(n)
 * <p>
 * 範例：
 * - Case 1: input = "leetcode"
 * Output: 'l' (因為 'l' 是第一個只出現一次的字元)
 * - Case 2: input = "hello"
 * Output: 'h' (因為 'h' 是第一個只出現一次的字元)
 * - Case 3: input = "aabbcc"
 * Output: null (所有字元均重複)
 * <p>
 * 思路(HashMap)：
 * 1.建立一個 HashMap<Character, Integer> 來記錄每個字元出現的次數
 * (Key存字元，Value存該字元出現的次數)
 * 2.第一次遍歷字串，將字元依序存入並更新 HashMap 中的計數
 * 3.第二次再按照原來字串的順序遍歷一次，檢查每個字元在 HashMap 中的計數是否為 1
 * 4.找到第一個計數為 1 的字元即刻回傳，若遍歷結束仍未找到則回傳 null
 */
public class NonRepeatingCharacter {

    public Character firstNonRepeatingCharacter(String str) {
        if (str.length() == 1) {
            return str.charAt(0);
        }

        Map<Character, Integer> hashMap = new HashMap<>();

        char[] chars = str.toCharArray();
        for (char c : chars) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (char c : chars) {
            if (hashMap.get(c) == 1) return c;
        }

        return null;
    }
}
