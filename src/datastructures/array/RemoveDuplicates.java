package datastructures.array;

/**
 * 題目：Array: Remove Duplicates(移除重複元素)
 * <p>
 * 題目摘要：
 * 給定一個 "已排序" 的整數陣列 nums，請撰寫一個方法，
 * 原地(in-place) 移除陣列中所有重複出現的整數，使得每個不重複的元素都只保留一個
 * 必須保持元素原本的相對順序，並回傳移除重複元素後的新陣列長度
 * 由於陣列是透過參照 (reference) 傳遞，因此你對陣列的修改會直接反映在呼叫端
 * <p>
 * 方法簽名：
 * public static int removeDuplicates(int[] nums)
 * <p>
 * 參數(Input)：
 * - nums: int[] (給定的已排序整數陣列)
 * <p>
 * 回傳(Output)：
 * - int: 移除重複元素後的新陣列長度，並將原陣列 nums 進行原地修改
 * <p>
 * 範例：
 * 輸入: nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
 * 輸出: 回傳 5，且 nums 修改後的前 5 個元素為 {0, 1, 2, 3, 4}
 * 解釋: 共有 5 個不重複的元素，所以回傳 5；陣列中索引 5 之後的剩餘元素是什麼並不重要，可以忽略
 * <p>
 * 補充說明：
 * - 必須透過將「不重複」的元素集中移至陣列的最前端來達成要求
 * - 空間限制：必須在空間複雜度 O(1) 的條件下「原地」修改陣列，不能使用額外的陣列或資料結構（如Set）
 * - 邊界條件：如果傳入的陣列是空的（長度為 0），則必須回傳 0
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int writeIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }
}
