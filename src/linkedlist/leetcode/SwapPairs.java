package linkedlist.leetcode;

/**
 * 題目：Swap Nodes in Pairs (兩兩交換鏈結串列節點)
 * 目標：給定單向鏈結串列的頭節點 head，兩兩交換其中相鄰的節點，並返回交換後的串列。
 * <p>
 * 規則：
 * - 索引從 1 開始計數 (概念上)。
 * - 不能單純改變節點內部的數值 (value)，而是需要實際進行節點交換。
 * - 空間複雜度需求 O(1)。
 * <p>
 * 範例：
 * - Input: head = 1 -> 2 -> 3 -> 4
 * - Process:
 * 1. 初始: dummy -> [1 -> 2] -> 3 -> 4
 * 2. 第一組交換 (1, 2): dummy -> [2 -> 1] -> 3 -> 4
 * 3. 移動指標到下一組 (3, 4): ... -> 2 -> 1 -> [3 -> 4]
 * 4. 第二組交換 (3, 4): ... -> 2 -> 1 -> [4 -> 3]
 * - Output: 2 -> 1 -> 4 -> 3
 * <p>
 * 思路(三步指針)：
 * 1. 使用 Dummy Node 指向 head，處理頭部可能會被交換的情況
 * 2. 定義 prev 指標，初始指向 dummy
 * 3. 當 prev 後面至少還有兩個節點 (first, second) 時，重複執行：
 * - prev.next 指向 second (將第二個拉到最前)
 * - second.next 指向 first (第二個反過來指向第一個，完成互換)
 * - first.next 指向原本 second 後面的節點 (first 承接剩下的隊伍)
 * - 移動 prev 到 first 的位置，準備處理下一對
 */
public class SwapPairs {

    private Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //---------------作答------------------
    public void swapPairs() {
        if (head == null || head.next == null) return;

        //1.建立 Dummy Node 並指向 head
        Node dummy = new Node(0);
        dummy.next = head;

        //2.prev 負責指向「待交換那兩位」的前一個位置
        Node prev = dummy;

        //3.只要後面還有兩個節點，就繼續交換
        while (prev.next != null && prev.next.next != null) {
            Node first = prev.next;
            Node second = prev.next.next;

            //step1:前者指向 second
            prev.next = second;

            //step2:first 接上剩下的隊伍(防止斷鏈)
            first.next = second.next;

            //step3:second 回頭指向 first
            second.next = first;

            //---推進指標---
            //交換後，順序變成 second -> first
            //prev 移動到 first (它現在是這一對的後面)，準備下一輪
            prev = first;
        }

        //4.更新head
        head = dummy.next;
    }
}