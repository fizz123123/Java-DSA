package datastructures.linkedlist.leetcode;
/**
 * 題目：Middle of the Linked List
 * 目標：給訂一個單向鏈結串列的 "頭節點-head"，請回傳該鏈結串列的中間節點
 * 規則：如果有兩個中間節點(即該串列為偶數)，請回傳第二個中間節點
 * - 範例：
 * - input：[1, 2, 3, 4, 5] / expected：3
 * - input：[1, 2, 3, 4, 5, 6] / expected：4
 * <p>
 * 思路：快慢指針
 */

public class FindMiddleNode {
    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
    //--------作答1----------
    public Node findMiddleNode() {
        if (head == null) return null;
        Node fast = head;
        Node slow = head;

        while (fast.next != null){
            fast = fast.next;
            if(fast.next != null) fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //--------作答2(優化版)----------
    public Node findMiddleNode2(){
        if (head == null) return null;
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}


