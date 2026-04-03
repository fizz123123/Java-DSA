package linkedlist.leetcode;

/**
 * 題目：Binary to Decimal (二進位鏈結串列轉整數)
 * 目標：給定一個單向鏈結串列，每個節點的值為 0 或 1。這些節點按順序代表一個二進位數字。請計算並回傳該二進位數字對應的十進位整數。
 * 規則：
 * - 鏈結串列不為空
 * - 請嘗試使用 "One Pass" (只遍歷一次) 的解法
 * - 範例：
 * - input：1 -> 0 -> 1 (二進位 101) / expected：5
 * - input：1 -> 1 -> 0 -> 1 (二進位 1101) / expected：13
 * - input：0 / expected：0
 * <p>
 * 思路："倍增累加"
 * - 每次讀取一個新的節點，就將目前的總數乘以2(相當於二進位向左移一位)
 * - 然後加上新節點的值
 * - 公式：num = num * 2 + current.value
 */
public class BinaryToDecimal {
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
    //不管是不是0都乘以2，是1就再+1
    public int binaryToDecimal() {
        if (head == null) return 0;
        Node current = head;
        int num = 0;

        while (current != null){
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }
}