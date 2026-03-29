package DLL.leetcode;

/**
 * 題目：Swap Nodes in Pairs (兩兩交換雙向鏈結串列中的節點)
 * 目標：給定一個雙向鏈結串列，請將相鄰的兩個節點進行交換，並返回交換後的串列。
 *      你必須實際交換節點本身的指標（In-place），不能只單純修改節點內部的值 (value)。
 * <p>
 * 規則：
 * - 必須正確維護每個節點的 next 與 prev 指標。
 * - 如果節點總數是奇數，最後一個節點不需要交換。
 * - 執行完畢後，必須正確更新整個雙向鏈結物件的 head 與 tail。
 * - 時間複雜度需求 O(n)。
 * - 空間複雜度需求 O(1)。
 * <p>
 * 範例：
 * - Case 1: 偶數節點
 *   Input:  head <-> 1 <-> 2 <-> 3 <-> 4 <-> tail
 *   Output: head <-> 2 <-> 1 <-> 4 <-> 3 <-> tail
 * - Case 2: 奇數節點
 *   Input:  head <-> 1 <-> 2 <-> 3 <-> tail
 *   Output: head <-> 2 <-> 1 <-> 3 <-> tail
 * <p>
 * 思路：
 * 1. 建立一個 Dummy Node 指向 head，這樣能簡化第一組節點交換時對 head 的特殊處理。
 * 2. 使用一個指標 (如 prevNode) 停留在「準備要交換的兩個節點」的前一個位置。
 * 3. 每次迴圈確認剩下的節點數至少有 2 個（即 current != null && current.next != null）。
 * 4. 抓出準備交換的兩個節點：firstNode 和 secondNode。
 * 5. 開始指標重定向 (Pointer Rewiring)：
 *    a. prevNode 的 next 指向 secondNode；secondNode 的 prev 指向 prevNode。
 *    b. firstNode 的 next 指向 secondNode 的 next；若後面還有節點，也把它的 prev 指向 firstNode。
 *    c. secondNode 的 next 指向 firstNode；firstNode 的 prev 指向 secondNode。
 * 6. 將 prevNode 往前移動到 firstNode 的位置，準備進行下一組的交換。
 * 7. 迴圈結束後，更新全域的 head 為 dummy.next (記得把 head.prev 設為 null以切斷 dummy)。
 * 8. 如果有需要，也要確保 tail 指向最後一個正確的節點。
 */
public class SwapNodesInPairs {
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
    public void swapPairs() {
        // 在此實作兩兩交換邏輯

    }
}