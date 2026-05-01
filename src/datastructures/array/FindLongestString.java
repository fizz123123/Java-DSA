package datastructures.array;

/**
 * 題目：Array: Find Longest String(尋找最長字串)
 * <p>
 * 題目摘要：
 * 給定一個字串陣列 stringList，撰寫一個方法找出並回傳該陣列中最長的字串
 * 如果有多個字串具有相同的最大長度，則回傳 "第一個" 遇到的字串
 * <p>
 * 方法簽名：
 * public static String findLongestString(String[] stringList)
 * <p>
 * 參數(Input)：
 * - stringList: String[] (給定的字串陣列)
 * <p>
 * 回傳(Output)：
 * - String: 陣列中最長的字串。如果有多個字串長度相同，回傳最先出現的那個
 * <p>
 * 範例：
 * 輸入: stringList = {"apple", "banana", "kiwi", "pear"}
 * 輸出: "banana"
 * 解釋: "banana" 是陣列中最長的字串，因此回傳 "banana"
 * <p>
 * 補充說明：
 * - 實作時需要考慮陣列中包含空字串 "" 的情況（其長度為 0）
 * - 如果陣列中所有的字串長度都相同，該方法應回傳陣列中的第一個字串
 */
public class FindLongestString {

    public static String findLongestString(String[] stringList) {
        String longestString = stringList[0];

        for (int i = 1; i < stringList.length; i++) {
            if (stringList[i].length() > longestString.length()) {
                longestString = stringList[i];
            }
        }
        return longestString;
    }
}
