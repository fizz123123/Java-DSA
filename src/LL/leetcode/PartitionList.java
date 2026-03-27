package LL.leetcode;

/**
 * 題目：Partition List (分隔鏈結串列)
 * 目標：給定一個單向鏈結串列的首節點 head 和一個數值 x，請對串列進行重新排列，使得所有「小於 x」的節點都出現在「大於或等於 x」的節點之前。
 * 規則：
 * - 必須保留原始串列中各節點的相對順序 (Stable Partition)。
 * - 例如：原始順序中的兩個大於 x 的節點，分隔後它們的前後關係不能變。
 * <p>
 * 範例：
 * - Input: head = 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
 * - Process:
 * - 小於 3 的節點: 1, 2, 2
 * - 大於等於 3 的節點: 4, 3, 5
 * - Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5
 * <p>
 * 思路：
 * - 創建兩個dummy節點，當作暫時的頭：
 * 1. dummy1(用於串接小於 x 的節點)
 * 2. dummy2(用於串接大於等於 x 的節點)
 * - 遍歷原始串列，根據值的大小將節點接到對應的dummy list後面
 * - 最後將 dummy1 的尾巴指向 dummy2 的開頭
 */
public class PartitionList {
    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //---------------作答------------------
    public void partitionList(int x) {
        if (head == null) return;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node current = head;
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        while (current != null) {

            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;

    }
}
