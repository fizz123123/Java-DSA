package Stack.leetcode;

/**
 * 題目：Parentheses Balanced (括號平衡檢查)
 * 目標：給定一個僅包含小括號 '(' 與 ')' 的字串，判斷其括號是否成對且順序正確。
 * <p>
 * 規則：
 * - 每個左括號 '(' 必須有一個對應的右括號 ')'。
 * - 括號必須以正确的順序關閉（必須先有左括號，才能有右括號）。
 * - 範例：
 * - "((()))" -> true (平衡)
 * - "(()" -> false (左括號過多)
 * - "())" -> false (右括號過多)
 * - ")(" -> false (順序錯誤)
 * <p>
 * 規則限制：必須使用 Stack 資料結構。
 * <p>
 * 思路：
 * 1.建立一個存放 Character 的 Stack
 * 2.遍歷字串中的每個字元：
 * - 如果遇到左括號 '('：將其推入 (push) Stack 中，表示「期待」後續有一個右括號來匹配
 * - 如果遇到右括號 ')'：
 * a.先檢查 Stack 是否為空。如果為空，表示目前的右括號沒有對應的左括號，直接回傳 false
 * b.如果不為空，從 Stack 中彈出 (pop) 一個左括號，表示成功匹配一對
 * 3.遍歷結束後，檢查 Stack 是否為空
 * - 若為空：代表所有左括號都找到了匹配的右括號，回傳 true
 * - 若不為空：代表有剩餘的左括號未被匹配，回傳 false
 */
public class ParenthesesBalanced {

    public boolean isValidParentheses(String str) {
        if (str == null || str.length() % 2 != 0) return false;
        var stack = new ImplementStackUsingArrayList<Character>();

        char[] chars = str.toCharArray();
        for (char c : chars) {

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
