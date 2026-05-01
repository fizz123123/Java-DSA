package datastructures.array;

/**
 * 題目：Array: Max Sub Array(最大子陣列和)
 * <p>
 * 題目摘要：
 * 給定一個整數陣列 nums，找出一具有最大總和的 "連續子陣列" (至少包含一個數字)，並回傳該子陣列的最大總和
 * <p>
 * 方法簽名：
 * public static int maxSubarray(int[] nums)
 * <p>
 * 參數(Input)：
 * - nums: int[] (給定的非空整數陣列)
 * <p>
 * 回傳(Output)：
 * - int: 連續子陣列的最大總和
 * <p>
 * 範例：
 * 輸入: nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 * 輸出: 6
 * 解釋: 連續子陣列 {4, -1, 2, 1} 的總和最大，為 6
 * <p>
 * 補充說明：
 * - 子陣列 (subarray) 是陣列中一段連續的部分，不能跳過或交錯任何元素
 * - 此連續子陣列可以是整個陣列，也可以是陣列的一小部分
 * - 陣列可能包含負數，重點在於讓子陣列的總和最大化
 * - 你可以假設傳入的陣列必定非空（至少包含一個數字）
 * <p>
 * 思路(Kadane's Algorithm)：
 * 遍歷陣列時，維護一個 當前最大子陣列和 (currentSum) 與 全域最大子陣列和 (maxSum)
 * 如果 currentSum 加上當前元素反而比當前元素還小，代表前面的總和是負資產
 * 倒不如直接放棄前面的部分，從當前元素重新開始計算新的子陣列
 * 時間複雜度為 O(n)，空間複雜度為 O(1)
 */
public class MaxSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubarray(nums);
        System.out.println(result);
    }

    //------作答------
    public static int maxSubarray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + currentSum < nums[i]) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    //-----優化-----
    public static int maxSubarray2(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //取 當前元素 與 當前元素 + currentSum 的較大值
            currentSum = Math.max(nums[i], nums[i] + currentSum);

            //動態更新全域最大值
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
