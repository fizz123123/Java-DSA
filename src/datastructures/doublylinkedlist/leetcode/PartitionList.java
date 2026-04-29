package datastructures.doublylinkedlist.leetcode;

/**
 * 題目：Partition List (分隔雙向鏈結串列)
 * 目標：給定一個雙向鏈結串列的首節點 head 和一個數值 x，請對串列進行重新排列，
 * 使得所有「小於 x」的節點都出現在「大於或等於 x」的節點之前。
 * <p>
 * 規則：
 * - 必須保留原始串列中各節點的相對順序 (Stable Partition)。
 * - 必須正確維護雙向鏈結串列的 next 與 prev 指標。
 * - 執行完畢後必須正確更新全域的 head 與 tail 參照。
 * <p>
 * 範例：
 * - Input: head <-> 1 <-> 4 <-> 3 <-> 2 <-> 5 <-> 2 <-> tail, x = 3
 * - Process:
 * - 小於 3 的節點: 1, 2, 2
 * - 大於等於 3 的節點: 4, 3, 5
 * - Output: head <-> 1 <-> 2 <-> 2 <-> 4 <-> 3 <-> 5 <-> tail
 * <p>
 * 思路：
 * - 創建兩個 dummy 節點，當作暫時的頭：
 * 1. dummy1 (用於串接小於 x 的節點)
 * 2. dummy2 (用於串接大於等於 x 的節點)
 * - 建立指標 (例如 prev1, prev2) 來輔助串接，並遍歷原始串列。
 * - 根據 currentNode 的值添加到對應的 dummy list，此時記得一併設定 currentNode.prev 指向對應的 prev 節點。
 * - 遍歷結束後，將 dummy1 的尾部與 dummy2 的有效頭部 (dummy2.next) 進行雙向連接。
 * - 確保處理 dummy2 可能為空的情況。
 * - 將最後一個節點的 next 設為 null，並更新物件的 tail 與 head。
 */
public class PartitionList {
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
    public void partitionList(int x) {
        if (length == 0) return;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node current = head;
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                current.prev = prev1;
                prev1 = current;
            } else {
                prev2.next = current;
                current.prev = prev2;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;

        prev1.next = dummy2.next;
        //防禦檢查：如果整個串列中都沒有value >= x 的節點，dummy2.next 會是 null
        if (dummy2.next != null) {
            dummy2.next.prev = prev1;
        }

        //更新head
        head = dummy1.next;
        head.prev = null;
        //更新tail，如果dummy2串列是空的，就把尾巴設為prev1
        tail = (dummy2.next != null) ? prev2 : prev1;
    }
}