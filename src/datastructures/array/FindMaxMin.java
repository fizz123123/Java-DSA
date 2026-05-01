package datastructures.array;

/**
 * 題目：Array: Find Max Min(尋找最大值與最小值)
 * <p>
 * 題目摘要：
 * 給定一個整數陣列 myList，你的任務是撰寫一個方法，找出並回傳該陣列中的最大值與最小值
 * 方法的回傳結果必須是一個長度為 2 的整數陣列，其中：
 * - 第一個位置（索引 0）放置 "最大值"
 * - 第二個位置（索引 1）放置 "最小值"
 * <p>
 * 方法簽名：
 * public static int[] findMaxMin(int[] myList)
 * <p>
 * 參數(Input)：
 * - myList: int[] (給定的整數陣列)
 * <p>
 * 回傳(Output)：
 * - int[]: 一個包含兩個整數的陣列，格式: [最大值, 最小值]
 * <p>
 * 範例：
 * 輸入: myList = [5, 3, 8, 1, 6, 9]
 * 輸出: [9, 1]
 * 解釋: 陣列中的最大值為 9，最小值為 1，因此回傳 [9, 1]
 * <p>
 * 補充：
 * - 該方法必須能正確處理包含負數、零的情況
 * - 如果陣列中包含重複的數字，也必須能正確辨識出最大與最小值
 */
public class FindMaxMin {

    public static int[] findMaxMin(int[] myList) {
        int max = myList[0];
        int min = myList[0];

        for (int i = 1; i < myList.length; i++) {
            max = Math.max(max, myList[i]);
            min = Math.min(min, myList[i]);
        }
        return new int[]{max, min};
    }
}
