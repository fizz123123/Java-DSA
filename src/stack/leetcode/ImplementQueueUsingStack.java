package stack.leetcode;

/**
 * Note：此實作並不是Queue最有效率的實作方式
 * 題目：Implement Queue using Stacks (使用堆疊實作佇列)
 * 目標：利用兩個堆疊 (Stack) 來模擬佇列 (Queue) 的行為。
 * 請實作 enqueue 方法，將元素加入到佇列的尾端。
 * <p>
 * 規則與限制：
 * - 必須使用你之前建立的 ImplementStackUsingArrayList 作為底層資料結構。
 * - 只能使用 Stack 的基本操作：push(), pop(), peek(), isEmpty()。
 * - 佇列必須滿足 FIFO (First-In-First-Out，先進先出) 的特性。
 * <p>
 * 範例：
 * - 執行 enqueue(1), enqueue(2), enqueue(3) 後，
 * - 為了滿足 FIFO，之後若執行 dequeue() 應該要優先回傳 1。
 * <p>
 * 思路(Two Stacks)：
 * - 需要兩個堆疊：
 * - stack1：專門用來處理加入元素 (入隊)
 * - stack2：專門用來處理移除元素 (出隊) 與反轉順序
 */
public class ImplementQueueUsingStack {
    private ImplementStackUsingArrayList<Integer> stack1;
    private ImplementStackUsingArrayList<Integer> stack2;

    public ImplementQueueUsingStack() {
        stack1 = new ImplementStackUsingArrayList<>();
        stack2 = new ImplementStackUsingArrayList<>();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    //------作法1：入隊O(n)，出隊O(1)------
    //---------------Enqueue------------------
    public void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    //---------------Dequeue------------------
    public Integer dequeue() {
        if (stack1.isEmpty()) return null;
        return stack1.pop();
    }

    //------作法2：入隊O(1)，出隊O(n)------
    //---------------Enqueue------------------
    public void enqueue1(int value) {
        stack1.push(value);
    }

    //---------------Dequeue------------------
    public Integer dequeue1() {
        if (stack1.isEmpty()) return null;
        Integer dequeued;

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        dequeued = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return dequeued;
    }
}
