package algorithms.mergesort;

/**
 * 題目：Merge Two Sorted Lists(合併兩個已排序的單向鏈結串列)
 * <p>
 * 題目摘要：
 * 撰寫一個方法，將傳入的另一個鏈結串列 (otherList) 與當前的鏈結串列接合合併
 * 假設兩個鏈結串列內部的節點都已經處於升序排序的狀態（若未排序則結果可能不符合預期）
 * 此方法不需將結果組合成新的鏈結串列來回傳，而是原地(In-place)修改當前的鏈結串列以包含合併後的所有結果
 * <p>
 * 方法簽名：
 * public void merge(LinkedList otherList)
 * <p>
 * 參數(Input)：
 * - LinkedList otherList: 準備與當前鏈結串列合併的另一個鏈結串列實例
 * <p>
 * 回傳(Output)：
 * - void (直接原地修改當前鏈結串列的 head、tail 與 length 屬性)
 * <p>
 * 思路：
 * 1. 取出起始節點：取得另一個鏈結串列的頭部節點，並把它設為變數 otherHead；同時標記當前鏈結串列的頭部 thisHead 準備進行比較
 * 2. 建立虛擬節點：創建一個數值為 0 的 dummy 節點，這將作為合併後鏈結串列的虛擬開頭
 * 3. 建立current指標：創建一個 current 節點變數並將其指向 dummy 節點，這個變數負責用來走訪並把符合排序的節點一路串接起來
 * 4. 比較與串接：只要兩個待合併的鏈結串列指標都不為 null，便進行迴圈比較。每次選出值較小的那個節點，將它連接到合併串列的尾部，
 * 然後將被選中的串列指標往前推移，接著更新 current 使其永遠位於合併串列的最後一個節點
 * 5. 處理剩餘節點：迴圈結束後，如果其中一個輸入的鏈結串列還有剩餘節點（不為null），直接把他們全體串接到合併串列的尾巴
 * 6. 更新頭尾：將當前鏈結串列的 head 重新設定為真正合併後的第一個節點 (dummy.next)，更新當前鏈結串列的 length 與 tail
 */
public class MergeTwoSortedLists {
    private Node head;
    private Node tail;
    private int length;

    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //-----作答------
    public void merge(MergeTwoSortedLists otherList) {
        Node thisHead = this.head;
        Node otherHead = otherList.head;
        Node dummy = new Node(0);
        Node current = dummy;

        while (thisHead != null && otherHead != null) {
            if (thisHead.value < otherHead.value) {
                current.next = thisHead;
                thisHead = thisHead.next;
            } else {
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            current = current.next;
        }

        if (thisHead != null) {
            current.next = thisHead;
        } else if (otherHead != null) {
            current.next = otherHead;
            this.tail = otherList.tail;
        }

        this.head = dummy.next;
        this.length += otherList.length;
    }
}
