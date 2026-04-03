package HT.leetcode.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * 題目：Has Unique Chars (判斷字串中的字元是否皆為唯一)
 * 目標：撰寫一個方法，判斷給定的字串中是否「完全沒有重複的字元」
 * <p>
 * 規則：
 * - 必須使用 Set (例如 HashSet) 來解決此問題，以達到 O(n) 的時間複雜度
 * - 如果字串中所有的字元都不重複，回傳 true
 * - 如果字串中有任何一個字元重複出現，回傳 false
 * <p>
 * 思路(HashSet)：
 * 1. 建立一個 HashSet<Character> 儲存已經看過(seen)的字元
 * (Set 的特性是裡面的元素不能重複，且尋找元素的時間複雜度為 O(1))
 * 2. 使用迴圈遍歷字串中的每一個字元：
 * a. 檢查當前的字元是否已經存在於 Set 中
 * - 如果存在：代表這個字元重複了，立刻回傳 false
 * - 如果不存在：將這個字元加入 Set 中繼續檢查
 * 3. 如果成功走完迴圈，代表沒有任何字元重複，最後回傳 true
 * <p>
 * Note：Set.add(element)方法在加入已存在的元素時會直接回傳 false
 * 因此可以將判斷與加入合併為一行指令：if (!set.add(c)) return false;
 */
public class HasUniqueChars {

    //-------作答1--------
    public boolean hasUniqueChars(String str) {
        Set<Character> seen = new HashSet<>();

        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (seen.contains(c)) {
                return false;
            }
            seen.add(c);
        }
        return true;
    }

    //------作答2：精簡版-------
    public boolean hasUniqueChars1(String str) {
        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!seen.add(c)) {
                return false;
            }
        }
        return true;
    }


}
