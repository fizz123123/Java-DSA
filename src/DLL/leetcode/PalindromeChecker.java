package DLL.leetcode;

/**
 * 題目：Palindrome Checker (回文檢查)
 * 目標：撰寫一個方法，判斷給定的雙向鏈結串列 (DLL) 中的節點數值序列是否為「回文」。
 * <p>
 * 規則：
 * - 回文定義：序列「從左往右讀」和「從右往左讀」是完全相同的。
 * - 時間複雜度需求 O(n)。
 * - 空間複雜度需求 O(1)。
 * - 應善用雙向鏈結串列擁有 head 與 tail 的特性。
 * <p>
 * 範例：
 * - Case 1: head -> 1 <-> 2 <-> 2 <-> 1 <- tail
 * Output: true
 * - Case 2: head -> 1 <-> 2 <-> 3 <- tail
 * Output: false
 * <p>
 * 思路:(Two Pointers)
 */
public class PalindromeChecker {
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
    public boolean palindromeChecker() {
        if (length <= 1) return true;
        Node leftPointer = head;
        Node rightPointer = tail;

        //當兩個指針不在同一個節點上，且兩個指針沒有穿過彼此
        while (leftPointer != rightPointer && leftPointer.prev != rightPointer) {

            if (leftPointer.value != rightPointer.value) {
                return false;
            }
            leftPointer = leftPointer.next;
            rightPointer = rightPointer.prev;
        }
        return true;
    }

    //---------------作答2(優化版)------------------
    public boolean palindromeChecker2() {
        if (length <= 1) return true;
        Node left = head;
        Node right = tail;

        //只需要比較length的一半(如：長度5、4都比較兩次，6、7都比較3次)
        for (int i = 0; i < length / 2; i++) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
    }
}
