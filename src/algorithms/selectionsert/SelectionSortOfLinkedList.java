package algorithms.selectionsert;

/**
 * 題目：Selection Sort of Linked List(單向鏈結串列選擇排序)
 * <p>
 * 題目摘要：
 * 撰寫一個方法，將一個單向鏈結串列中的節點，依照內部儲存的整數數值進行「升序」排序
 * 需使用選擇排序法 (Selection Sort)，將串列分為已排序與未排序區間，反覆從未排序區間中尋找最小值，並將其與未排序區間的起始節點交換，直到整個鏈結串列排序完成
 * 必須原地(In-place)進行修改，也就是直接交換節點之間的值，而不是創建一個新的鏈結串列或更動節點本身的連結
 * <p>
 * 方法簽名：
 * public void selectionSort()
 * <p>
 * 參數(Input)：
 * - 無參數 (直接操作當前實體內的物件屬性)
 * <p>
 * 回傳(Output)：
 * - void (原地修改鏈結串列本身的節點數值)
 * <p>
 * 思路：
 * 1. edge case：如果鏈結串列的長度小於 2，代表已經處於排序好的狀態，直接 return
 * 2. 外層迴圈：初始化 current 指標指向 head，只要 current.next 不為 null，就繼續執行迴圈
 * 3. 記錄最小值指標：宣告 smallest 指標指向 current，並宣告 innerCurrent 指標從 current.next 開始
 * 4. 內層迴圈：使用 innerCurrent 遍歷剩餘未排序的節點，若 innerCurrent 的值小於 smallest 的值，
 * 則將 smallest 更新為 innerCurrent，接著向後推進 innerCurrent
 * 5. 交換數值：內層迴圈結束後，若 smallest 與 current 不指向同一個節點，則交換兩節點的 value
 */
public class SelectionSortOfLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //--------作答--------
    public void selectionSort() {
        if (length < 2) {
            return;
        }

        Node current = head;

        while (current.next != null) {
            Node smallest = current;
            Node innerCurrent = current.next;

            while (innerCurrent != null) {
                if (innerCurrent.value < smallest.value) {
                    smallest = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }

            if (smallest != current) {
                int temp = current.value;
                current.value = smallest.value;
                smallest.value = temp;
            }
            current = current.next;
        }
    }
}
