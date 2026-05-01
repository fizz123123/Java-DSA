package datastructures.array;

import java.util.Arrays;

/**
 * 題目：Array: Rotate(旋轉陣列)
 * <p>
 * 題目摘要：
 * 給定一個非空的整數陣列 nums 以及一個非負整數 k
 * 請撰寫一個方法，將陣列中的元素 "向右旋轉" k 步
 * 每次旋轉一步，陣列的最後一個元素會被移動到最前方，其餘元素則統一向右平移一格
 * <p>
 * 方法簽名：
 * public static void rotate(int[] nums, int k)
 * <p>
 * 參數(Input)：
 * - nums: int[] (給定的非空整數陣列)
 * - k: int (向右旋轉的步數)
 * <p>
 * 回傳(Output)：
 * - void: 不回傳任何值，必須原地修改傳入的 nums 陣列
 * <p>
 * 範例：
 * 輸入: nums = {1, 2, 3, 4, 5, 6, 7}, k = 3
 * 輸出: 修改後的 nums 變為 {5, 6, 7, 1, 2, 3, 4}
 * 解釋:
 * 向右旋轉 1 步: {7, 1, 2, 3, 4, 5, 6}
 * 向右旋轉 2 步: {6, 7, 1, 2, 3, 4, 5}
 * 向右旋轉 3 步: {5, 6, 7, 1, 2, 3, 4}
 * <p>
 * 補充說明：
 * - 實際需要旋轉的次數等於 "k % nums.length" ，因為當旋轉次數等於陣列長度時，陣列會回到初始狀態
 * - 空間限制：必須在空間複雜度 O(1) 的條件下原地修改陣列
 * - 效能要求：目標是達成線性時間複雜度 O(n)
 * <p>
 * 思路(Two-Pointer + 三次反轉-Reversal Algorithm)：
 * 1. 計算出實際的旋轉次數：(k = k % nums.length)
 * 2. 先反轉整個陣列
 * 3. 接著反轉前 k 個元素
 * 4. 最後反轉後面剩餘的元素
 */
public class Rotate {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;

        //反轉整個陣列
        reverse(nums, 0, nums.length - 1);
        //反轉前k個元素
        reverse(nums, 0, k - 1);
        //反轉剩餘元素
        reverse(nums, k, nums.length - 1);
    }

    //helper
    private static void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
