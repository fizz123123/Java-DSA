package doublylinkedlist.leetcode;

/**
 * 題目：Reverse Doubly Linked List (反轉雙向鏈結串列)
 * 目標：撰寫一個方法，將給定的雙向鏈結串列 (DLL) 反轉。使得原來的 head 變成 tail，原來的 tail 變成 head，並且所有節點的 next 與 prev 指針方向顛倒。
 * <p>
 * 規則：
 * - 必須在原串列上進行操作（In-place），不可創建新的節點或新的串列。
 * - 時間複雜度需求 O(n)。
 * - 空間複雜度需求 O(1)。
 * - 反轉後需要正確更新 head 和 tail 的參照。
 * <p>
 * 範例：
 * - Case 1: head -> 1 <-> 2 <-> 3 <-> 4 <- tail
 * Output: head -> 4 <-> 3 <-> 2 <-> 1 <- tail
 * - Case 2: head -> 1 <- tail
 * Output: head -> 1 <- tail
 * <p>
 * 思路:(Pointer Swapping)
 * 交換每個節點的前後指標，最後再把頭、尾交換
 */
public class Reverse {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    //---------------作答------------------
    public void reverse() {
        if (length <= 1) return;

        Node current = head;
        Node temp = null;

        while (current != null) {
            //先把 current.prev 暫存起來
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        Node tempHead = head;
        head = tail;
        tail = tempHead;
    }
}
