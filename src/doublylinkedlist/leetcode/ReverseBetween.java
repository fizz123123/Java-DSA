package doublylinkedlist.leetcode;

/**
 * 有夠難......
 * 題目：Reverse Between (反轉區間內的雙向鏈結串列)
 * 目標：給定一個雙向鏈結串列的首節點 head，以及兩個整數 startIndex 和 endIndex（0-based 索引），
 * 請反轉從 startIndex 到 endIndex 範圍內的所有節點。
 * <p>
 * 規則：
 * - 必須在原串列上進行操作（In-place），不可創建新的連串列或直接修改節點的值。
 * - 必須正確維護雙向鏈結串列的 next 與 prev 指標。
 * - 如果翻轉的區間包含頭部或尾部，請確保全域的 head 與 tail 被正確更新。
 * - 時間複雜度需求 O(n)。
 * - 空間複雜度需求 O(1)。
 * <p>
 * 範例：
 * - Input: head <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> tail, startIndex = 1, endIndex = 3
 * - Process: 反轉區間為 [2, 3, 4]
 * - Output: head <-> 1 <-> 4 <-> 3 <-> 2 <-> 5 <-> tail
 * <p>
 * - Input: head <-> 1 <-> 2 <-> 3 <-> tail, startIndex = 0, endIndex = 2
 * - Output: head <-> 3 <-> 2 <-> 1 <-> tail
 * <p>
 * 思路：
 * 1. 邊界條件檢查：如果鏈結串列為空、長度小於2，或者 startIndex >= endIndex，則無須反轉。
 * 2. 使用 Dummy Node：為了處理 startIndex 為 0（即從頭開始反轉）的邊界情況，建立一個 dummy 節點指向 head。
 * 3. 尋找切入點：找到 startIndex 的前一個節點 (beforeNode) 以及區間的第一個節點 (currentNode)。
 * 4. 區間內反轉：在 [startIndex, endIndex] 的範圍內，使用標準的 Pointer Swapping 技巧來反轉節點內的 prev 與 next。
 * 5. 重新連接前後段：
 * - 將 beforeNode 連結到反轉區間的新頭部。
 * - 將反轉區間的尾部連結到 endIndex 之後的節點。
 * - 確保所有接合處的 prev 指標也都正確指回。
 * 6. 更新 Head & Tail：根據翻轉的位置更新最終的 head（通常是 dummy.next），如果有牽扯到尾部也要更新 tail。
 */
public class ReverseBetween {
    private Node head;
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
    public void reverseBetween(int startIndex, int endIndex) {
        if (endIndex == startIndex || head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node prev = dummy;
        for (int i = 0; i < startIndex - 1; i++) {
            prev = prev.next;
        }

        Node current = prev.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node toMove = current.next;
            current.next = toMove.next;

            if (toMove.next != null) {
                toMove.next.prev = current;
            }

            toMove.next = prev.next;
            if (prev.next != null) {
                prev.next.prev = toMove;
            }

            toMove.prev = prev;
            prev.next = toMove;
        }

        head = dummy.next;
        head.prev = null;


    }
}