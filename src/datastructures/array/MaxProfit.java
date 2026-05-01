package datastructures.array;

/**
 * 題目：Array: Max Profit(買賣股票的最佳時機)
 * <p>
 * 題目摘要：
 * 給定一個整數陣列 prices，其中的每一個元素 prices[i] 代表某支股票在第 i 天的價格
 * 你的任務是找出透過 "買入一次" 及 "賣出一次" 所能獲得的 "最大利潤"
 * 規則是必須 "先買入" 才能 "賣出"
 * <p>
 * 方法簽名：
 * public static int maxProfit(int[] prices)
 * <p>
 * 參數(Input)：
 * - prices: int[] (整數陣列，代表每天的股票價格)
 * <p>
 * 回傳(Output)：
 * - int: 能夠獲得的最大利潤。如果無法獲取任何利潤（例如價格持續下跌），則回傳 0
 * <p>
 * 範例：
 * 輸入: prices = {7, 1, 5, 3, 6, 4}
 * 輸出: 5
 * 解釋: 在第 2 天（價格 = 1）買入，並在第 5 天（價格 = 6）賣出。最大利潤為 6 - 1 = 5
 * <p>
 * 補充說明：
 * - 你只能進行一次交易（即買入一次、賣出一次後便結束）
 * - 你不能在同一天買入並賣出
 * - 賣出的時間點必須晚於買入的時間點
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {

            //若有更低的買入價，更新最低價格
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                //否則，計算當前獲利，並動態更新最大獲利
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
