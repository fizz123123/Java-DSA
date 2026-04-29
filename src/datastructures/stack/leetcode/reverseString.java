package datastructures.stack.leetcode;

/**
 * 題目：Reverse String using Stack (使用堆疊反轉字串)
 * 目標：給定一個字串，利用堆疊 (Stack) 的特性將其字元順序完全反轉。
 * <p>
 * 規則：
 * - 必須使用自定義或內類的 Stack 資料結構來實作。
 * - 空間複雜度需求 O(n) (用於儲存 Stack 中的字元)。
 * - 時間複雜度需求 O(n) (遍歷字串兩次：一次推入，一次彈出)。
 * <p>
 * 範例：
 * - Input: "hello"
 * Process:
 * 1. Push 'h', 'e', 'l', 'l', 'o' into Stack.
 * 2. Pop/Append: 'o' -> 'l' -> 'l' -> 'e' -> 'h'
 * - Output: "olleh"
 * <p>
 * 思路:
 * 1.建立一個存放 Character 的 Stack
 * 2.遍歷輸入字串的首個字元到最後一個字元，依序 push 進 Stack 中
 * 3.建立一個 StringBuilder 或空的 String
 * 4.只要 Stack 不為空，就執行 pop 操作並將得到的字元附加到結果字串中
 * 5.回傳反轉後的字串
 */
public class reverseString {

    public String reverseString(String str) {
        if (str == null || str.length() < 2) return str;
        var stack = new ImplementStackUsingArrayList<Character>();
        //push
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
        //pop
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
