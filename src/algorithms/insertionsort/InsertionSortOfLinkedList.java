package algorithms.insertionsort;

/**
 * 題目：Insertion Sort of Linked List(單向鏈結串列插入排序)
 * <p>
 * 題目摘要：
 * 撰寫一個方法，將一個單向鏈結串列中的節點，依照內部儲存的整數數值進行升序排序
 * 需使用 Insertion Sort，透過將未排序區段的節點逐一取出，並將其連結到已排序區段的正確位置
 * 必須原地(In-place)進行修改
 * <p>
 * 方法簽名：
 * public void insertionSort()
 * <p>
 * 參數(Input)：
 * - 無參數 (直接操作當前實體內的物件屬性)
 * <p>
 * 回傳(Output)：
 * - void (原地修改鏈結串列的節點連結與結構)
 * <p>
 * 思路：
 * 1. edge case：如果鏈結串列的長度小於 2，代表已經處於排序好的狀態，直接 return
 * 2. 初始分割：創建 sortedListHead 變數初始指向 head 的節點 (已排序區段的起點)，
 * 並將 unsortedListHead 變數初始指向第二個節點 (未排序區段的起點)，開始前記得先將已排序區段與未排序區段斷開連結
 * 3. 遍歷未排序節點：當 unsortedListHead 不為空時進行迴圈，逐次取出要插入的節點
 * 4. 頭部插入情況：如果當前取出的節點值小於 sortedListHead 的值，則將該節點連接到 sortedListHead 之前，並讓其成為新的 sortedListHead
 * 5. 中間或尾部插入情況：建立 searchPointer 從 sortedListHead 開始向後尋找，直到找到合適的插入位置，再修改上一節點與當前節點的 next ，完成插入
 * 6. 更新進度與收尾：所有的未排序節點都插入完成後，將原本鏈結串列的 head 指向最新的 sortedListHead，並遍歷找到最後一個節點，將 tail 指向它
 */
public class InsertionSortOfLinkedList {

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

    public InsertionSortOfLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // --------作答---------
    public void insertionSort() {
        if (length < 2) {
            return;
        }

        Node dummy = new Node(0);
        Node unsortedListHead = head;

        while (unsortedListHead != null) {
            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            Node searchPointer = dummy;

            while (searchPointer.next != null && current.value > searchPointer.next.value) {
                searchPointer = searchPointer.next;
            }

            current.next = searchPointer.next;
            searchPointer.next = current;
        }

        head = dummy.next;

        Node temp = head;
        while (temp != null && temp.next != null){
            temp = temp.next;
        }
        tail = temp;
    }

}
