package algorithms.bubblesort;

/**
 * 題目：Bubble Sort of Linked List(單向鏈結串列氣泡排序)
 * <p>
 * 題目摘要：
 * 撰寫一個方法，將一個單向鏈結串列中的節點，依照內部儲存的整數數值進行「升序」排序
 * 需使用氣泡排序法 (Bubble Sort)，不斷比較相鄰節點並將較大的值往後推，直到整個鏈結串列排序完成
 * 必須原地(In-place)進行修改，也就是直接交換節點之間的值，而不是創建一個新的鏈結串列或更動節點本身的連結
 * <p>
 * 方法簽名：
 * public void bubbleSort()
 * <p>
 * 參數(Input)：
 * - 無參數 (直接操作當前實體內的物件屬性 head 與 length)
 * <p>
 * 回傳(Output)：
 * - void (原地修改鏈結串列本身的節點數值)
 * <p>
 * 思路：
 * 1. edge case：如果鏈結串列的長度小於 2，代表已經處於排序好的狀態，直接 return
 * 2. 設定排序邊界(已排序區間)：建立一個 sortedUntil 指標，用來記錄尚未排序區段的邊界
 * 3. 外層迴圈：只要 sortedUntil 尚未退到鏈結串列的第二個節點(head.next)，就繼續執行迴圈
 * 4. 內層迴圈：從 head 開始，持續比較 current 和 current.next 的 value，若前者的值大於後者，則交換兩節點的值
 * 5. 更新邊界：內層走完後，將 sortedUntil 設為 current
 */
public class BubbleSortOfLinkedList {
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

    // --------作答---------
    public void bubbleSort() {
        if(length < 2){
            return;
        }

        Node sortedUntil = null;

        while (head.next != sortedUntil) {
            Node current = head;

            while (current.next != sortedUntil) {
                if (current.value > current.next.value) {
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                }
                current = current.next;
            }

            sortedUntil = current;
        }
    }
}
