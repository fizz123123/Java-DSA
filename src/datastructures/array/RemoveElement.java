package datastructures.array;

/**
 * 題目：Array: Remove Element(移除指定元素)
 * <p>
 * 題目摘要：
 * 給定一個整數陣列 nums 以及一個整數 val
 * 必須 (In-place) 移除陣列中所有數值與 val 相等的元素，並回傳移除後的陣列新長度 k
 * 必須在不使用額外陣列空間的情況下完成此操作（空間複雜度 O(1)）
 * 執行完成並回傳新長度 k 後，nums 的前 k 個元素必須是不包含 val 的其餘元素
 * 保留下來的元素順序不拘，且陣列中索引 k 之後剩餘的元素可以忽略，不影響結果
 * <p>
 * 方法簽名：
 * public static int removeElement(int[] nums, int val)
 * <p>
 * 參數(Input)：
 * - nums: int[] (給定的整數陣列)
 * - val: int (欲移除的目標整數值)
 * <p>
 * 回傳(Output)：
 * - int: 移除目標元素後的新陣列長度 k
 * <p>
 * 思路(快慢指標)
 */

public class RemoveElement {

    //-------作答--------
    public static int removeElement(int[] nums, int val) {
        int writeIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        return writeIndex;
    }
}
