package datastructures.hashtable.leetcode.hashmap;

import java.util.*;

/**
 * 題目：Group Anagrams (字母異位詞分組)
 * 目標：撰寫一個方法將陣列中屬於「字母異位詞」的字串分開群組
 * (字母異位詞：由相同字母組成，但排列順序不同的字串)
 * <p>
 * 規則：
 * - 必須使用 HashMap 來解決此問題
 * - 回傳型別為 List<List<String>>，每個內部列表包含一組互為字母異位詞的字串
 * - 陣列中的字串僅包含小寫英文字母
 * <p>
 * 範例：
 * - Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * - Expected Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
 * (群組內部與群組之間的順序不限)
 * <p>
 * 思路(HashMap)：
 * 1. 核心概念：互為異位詞的字串，若對它們的字母進行排序，結果一定相同(例如 "eat" 與 "tea" 排序後都是 "aet")
 * 2. 建立一個 HashMap<String, List<String>>：
 * - Key存 排序後的字串(特徵值)
 * - Value存 具有相同特徵值的所有原始字串
 * 3. 遍歷字串陣列：
 * a. 針對每個字串，將其轉換為字元陣列 toCharArray()
 * b. 對字元陣列進行排序 Arrays.sort()
 * c. 將排序好的字元陣列轉回字串，當作Key
 * d. 如果 HashMap 裡還沒有這個 Key，就 put 一個新的空 ArrayList 進去
 * e. 將原本的字串加到該 Key 對應的 ArrayList 裡面
 * 4. 迴圈結束後，所有異位詞都已經分好組，直接回傳 HashMap 所有的 values
 */
public class GroupAnagrams {

    //------作答-------
    public List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> hashMap = new HashMap<>();

        for (String str : strings) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            //hashMap.put(sortedStr, hashMap.getOrDefault(sortedStr, new ArrayList<String>()));
            //hashMap.get(sortedStr).add(str);
            hashMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        }

        List<List<String>> anagrams = new ArrayList<>(hashMap.values());
        return anagrams;
        //return new ArrayList<>(hashMap.values());
    }
}
