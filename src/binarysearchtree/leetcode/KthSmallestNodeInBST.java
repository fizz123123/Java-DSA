package binarysearchtree.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 題目：Kth Smallest Element in a BST (尋找二元搜尋樹中第 K 小的節點)
 * <p>
 * 題目摘要：
 * 實作一個方法 kthSmallest(int k)，用來找出二元搜尋樹 (BST) 中第 k 小的元素
 * 若找到該元素，回傳其值；若超過範圍或不存在則回傳 null
 * 最小的元素即為值最底層最左邊的節點，第二小為第二小的值，依此類推
 * <p>
 * 方法簽名：
 * public Integer kthSmallest(int k)
 * <p>
 * 限制與思路(Iterative In-Order Traversal)：
 * 1. 規定使用 Stack<Node> 來模擬系統底層的 Call Stack，達成迭代遍歷
 * 2. 迴圈執行條件：當 Stack 不為空，或者當前節點 (currentNode) 不為 null 時持續執行
 * 3. 迴圈內部邏輯：
 * a. 若 currentNode 不為 null：
 * 將其推入 (push) Stack 中，並繼續往其「左子節點」移動 (currentNode = currentNode.left)
 * 這代表我們一直往最小的值鑽下去
 * b. 若 currentNode 為 null（代表左邊走到底了）：
 * 從 Stack 中彈出 (pop) 最上面的節點
 * 將 k 減 1（代表我們又經過了一個由小到大的數字）
 * 如果 k 減到 0，代表當前這個彈出的節點就是第 k 小的元素，直接回傳其值
 * 若 k 還沒歸零，則將 currentNode 指向該彈出節點的「右子節點」，準備進行下一輪檢查
 * <p>
 * 範例：
 * 假設 BST 包含節點：[5, 3, 7, 2, 4, 6, 8]
 * - k = 1，應該回傳 2 (最小的元素)
 * - k = 3，應該回傳 4 (第三小的元素)
 * - k = 6，應該回傳 7 (第六小的元素)
 * <p>
 * 前提：
 * - k 必定為正整數，且保證不會大於樹中節點的總數
 * - 呼叫此方法前，確保樹中至少已經 insert 了一個以上的節點
 */
public class KthSmallestNodeInBST {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //--------作答1---------
    public Integer kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;

        while (!stack.isEmpty() || currentNode != null) {

            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;

            } else {
                currentNode = stack.pop();
                k--;

                if (k == 0) {
                    return currentNode.value;
                }

                currentNode = currentNode.right;
            }
        }
        return null;
    }


}
