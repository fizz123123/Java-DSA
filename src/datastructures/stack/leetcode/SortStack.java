package datastructures.stack.leetcode;

/**
 * 題目：Sort Stack (使用輔助堆疊對堆疊進行排序)
 * 目標：撰寫一個方法 sortStack，接收一個 Stack 物件作為參數，並將其內部元素以升序排序。
 * 排序完成後，最小值必須位於堆疊的頂端 (Top)。
 * <p>
 * 規則與限制：
 * - 只能使用 1 個額外的輔助 Stack (Additional Stack) 來完成排序。
 * - 只能使用標準的 Stack 操作：push(), pop(), peek(), isEmpty()。
 * - 不可使用陣列、List 或其他資料結構來暫存元素。
 * - 時間複雜度：O(n^2) (因為在尋找正確位置時需要不斷在兩個 Stack 之間搬運元素)。
 * - 空間複雜度：O(n) (使用了一個額外的 Stack)。
 * <p>
 * 思路 (Insertion Sort)：
 * 1. 建立一個新的空堆疊 `sortedStack`，用來存放排序好的元素（越上面的值越大，這樣最後倒回原堆疊時，最小值才會在頂端）。
 * 2. 只要「原始堆疊」不為空，就進入迴圈：
 * a. 從原始堆疊 pop 出最頂端的元素，存入變數 `temp` 中。
 * b. 檢查 `sortedStack` 是否為空，且其頂端元素 (peek) 是否「大於」 `temp`。
 * c. 如果大於 `temp`，代表 `temp` 應該放在更下面的位置。此時將 `sortedStack` 頂端的元素 pop 出來，並 push 回「原始堆疊」中，直到找到適合 `temp` 的位置。
 * d. 將 `temp` push 進入 `sortedStack`。
 * 3. 當原始堆疊為空時，代表所有元素都已依照順序放入 `sortedStack`（此時 `sortedStack` 頂端是最大值）。
 * 4. 最後，將 `sortedStack` 中的所有元素逐一 pop 出來，並 push 回「原始堆疊」。這樣原本最大的值會先進入底部，最小值會最後進入而停留在頂端，完成升序排序。
 */
public class SortStack {

    public void sortStack(ImplementStackUsingArrayList<Integer> stack) {
        if (stack.isEmpty()) return;

        var sortedStack = new ImplementStackUsingArrayList<Integer>();

        while (!stack.isEmpty()) {
            Integer temp = stack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        while (!sortedStack.isEmpty()) {
            stack.push(sortedStack.pop());
        }
    }
}
