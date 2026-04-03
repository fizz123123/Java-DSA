package linkedlist.leetcode;

/**
 * 題目：Reverse Linked List II (反轉鏈結串列 II) / Reverse Between
 * 目標：給定單向鏈結串列的頭節點 head 以及兩個整數 left 和 right (left <= right)，
 *      請反轉從位置 left 到 right 的鏈結節點，並返回修改後的串列。
 *
 * 規則：
 * - 索引從 1 開始計數。
 * - 原地 (In-place) 修改，只需遍歷一次。
 *
 * 範例：
 * - Input: head = 1 -> 2 -> 3 -> 4 -> 5, left = 2, right = 4
 * - Process:
 *   我們要反轉區間 [2, 4]，即數值為 2, 3, 4 的這一段。
 *   1. 初始: 1 -> [2 -> 3 -> 4] -> 5
 *   2. 第一步: 1 -> [3 -> 2 -> 4] -> 5 (把 3 移到 2 前面)
 *   3. 第二步: 1 -> [4 -> 3 -> 2] -> 5 (把 4 移到 3 前面)
 * - Output: 1 -> 4 -> 3 -> 2 -> 5
 *
 * 思路(頭插法)：
 * 1. 使用 Dummy Node 處理 left = 1 的邊界情況
 * 2. 找到 left 前一個節點，稱為 prev (在範例中是 1)
 * 3. 定義 current 為區間的第一個節點 (在範例中是 2)
 * 4. 在區間內重複執行：
 *    - 將 current 的下一個節點 (nextNode) 取出
 *    - 將 nextNode 插入到 prev 的後面 (即區間的最前端)
 *    - 調整 current.next 指向
 */
public class ReverseBetween {

    private Node head;
    private Node tail; // 簡易維護 tail 以便 append 測試

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //---------------作答------------------
    public void reverseBetween(int left, int right) {
        if (head == null || left == right) return;

        //1.建立 Dummy Node 並指向 head
        Node dummy = new Node(0);
        dummy.next = head;

        //2.移動 prev 指針到 left 位置的前一個節點
        Node prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        //3.current 指向 left 位置的節點(也是此次反轉區間的"原始"第一個節點)
        Node current = prev.next;

        //4.開始執行反轉(執行次數為 right - left)
        for (int i = 0; i < right - left;i++){
            //刪除 nextNode 並插入到 prev 後面
            Node toMove = current.next;
            current.next = toMove.next;
            toMove.next = prev.next;
            prev.next = toMove;
        }
        //5.更新真正的 head(如果 left = 1，head會被改變)
        head = dummy.next;
    }
}
