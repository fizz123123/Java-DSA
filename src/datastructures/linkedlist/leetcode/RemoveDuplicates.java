package datastructures.linkedlist.leetcode;

/**
 * 題目：Remove Duplicates from Sorted List (移除已排序鏈結串列中的重複項)
 * 目標：給定一個已排序的單向鏈結串列，刪除所有重複的元素，使每個元素只出現一次。
 * 規則：
 * - 串列已經按升序排列
 * - 必須 "In-Place" (原地) 修改，不需額外空間
 * - 範例：
 * - input：1 -> 1 -> 2 / expected：1 -> 2
 * - input：1 -> 1 -> 2 -> 3 -> 3 / expected：1 -> 2 -> 3
 * <p>
 * 思路：
 * - 使用迭代方式遍歷串列
 * - 比較 current.value 和 current.next.value
 * - 如果相同，則跳過下一個節點 (current.next = current.next.next)
 * - 如果不同，則移動到下一個節點 (current = current.next)
 */
public class RemoveDuplicates {
    private Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //-----------作答-------------
    public void removeDuplicates() {
        if (head == null) return;

        Node current = head;

        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    //----進階(Remove Duplicates From Unsorted LinkedList)
    public void removeDuplicates2() {
        if (head == null) return;
        Node current = head;

        while (current != null) {

            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

}
