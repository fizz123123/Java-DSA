package datastructures.linkedlist.leetcode;

/**
 * 題目：Linked List Cycle
 * 目標：檢查給定的單向鏈結串列中是否存在 "環/迴圈" (Loop)
 * 規則：只需要判斷是否有環並回傳布林值 (boolean)，不需要回傳環的具體位置
 * - 範例：
 * - input：[3, 2, 0, -4], pos=1 (尾端連回 index 1) / expected：true
 * - input：[1, 2], pos=0 (尾端連回 index 0) / expected：true
 * - input：[1], pos=-1 (無環) / expected：false
 * <p>
 * 思路："快慢指針"
 * - 如果快指針(Fast)最終能追上慢指針(Slow)，代表有環
 * - 如果快指針遇到null，代表走到終點，則無環
 */
public class HasLoop {
    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
    //------作答-------
    public boolean hasLoop() {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

}
