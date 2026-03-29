package Stack.leetcode;

import java.util.ArrayList;

/**
 * 題目：Implement Stack using ArrayList (使用 ArrayList 實作堆疊)
 * 目標：使用 Java 的 ArrayList 作為底層容器，實作一個支援泛型 <T> 的 Stack 類別。
 * <p>
 * 核心方法：
 * - push(T value): 將元素推入堆疊頂端
 * - pop(): 移除並回傳堆疊頂端元素
 * - peek()：回傳頂部元素
 * <p>
 * 規則：
 * - 必須使用 ArrayList 的 add() 方法來模擬堆疊的「推入」。
 * - 堆疊頂端 (Top) 定義為 ArrayList 的最後一個索引位置 (size - 1)。
 * - 時間複雜度：push 均攤為 O(1)。
 */
public class ImplementStackUsingArrayList<T> {
    //底層資料結構(Array List)
    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) return null;
        return stackList.get(stackList.size() - 1);
    }

    //--------Push---------
    //將ArrayList的"末端" 當作Stack的"頂端"
    public void push(T data) {
        stackList.add(data);
    }

    //--------Pop----------
    public T pop() {
        if (isEmpty() == true) return null;
        int size = stackList.size();
        return stackList.remove(size - 1);
    }
}
