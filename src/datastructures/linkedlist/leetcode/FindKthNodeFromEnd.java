package datastructures.linkedlist.leetcode;

/**
 * 題目：Find Kth Node From End (尋找倒數第 K 個節點)
 * 目標：給定一個單向鏈結串列，找出並回傳倒數第 k 個節點
 * 規則：
 * - 如果 k 大於鏈結串列長度，則回傳 null
 * - 請嘗試使用 "One Pass" (只遍歷一次) 的解法
 * - 範例：
 * - input：1 -> 2 -> 3 -> 4 -> 5, k=2 / expected：Node(4)
 * - input：1 -> 2 -> 3 -> 4 -> 5, k=5 / expected：Node(1)
 * - input：1 -> 2, k=3 / expected：null (因為 k 超過長度)
 * <p>
 * 思路："快慢指針"
 * - 讓快指針(Fast)先單獨走k步，創造一個間距
 * - 接著快慢指針同時移動，當Fast走到null時，Slow正好會在倒數第k個位置
 */
public class FindKthNodeFromEnd {
    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //---------------作答1------------------
    public Node findKthFromEnd(int k) {
        if(k <= 0) return null;

        Node fast = head;
        Node slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
