package binarysearchtree.leetcode;

import java.util.ArrayList;

/**
 * 題目：Validate Binary Search Tree (驗證二元搜尋樹)
 * <p>
 * 題目內容：
 * 實作一個方法 isValidBST() 來判斷當前的二元樹是否為一棵合法的二元搜尋樹 (BST)
 * <p>
 * BST 的合法條件 (BST Properties)：
 * 1. 節點的左子樹只包含「小於」該節點值的節點
 * 2. 節點的右子樹只包含「大於」該節點值的節點
 * 3. 所有的左、右子樹也必須皆為合法的二元搜尋樹
 * <p>
 * 思路(中序遍歷)：
 * 1. 利用先前完成的 中序遍歷 (DFS In-Order Traversal) 方法，將樹的所有節點值收集到一個 ArrayList 中
 * 2. 核心觀念：一棵合法的 BST，其「中序遍歷」的結果必定是一個「嚴格遞增 (Strictly Ascending)」的序列
 * 3. 遍歷這個 ArrayList，自第二個元素開始比較其與前一個元素的大小
 * 4. 如果發現任何一個元素「小於或等於」它的前一個元素，就表示違反了 BST 的規則，立即回傳 false
 * 5. 如果完整檢查完整個陣列都沒有發現違規，則回傳 true
 */
public class ValidateBST {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //-------------作答1--------------
    public boolean isValidBST() {
        ArrayList<Integer> treeNodeValues = dfsInOrder();

        for (int i = 0; i < treeNodeValues.size() - 1; i++) {
            if (treeNodeValues.get(i) >= treeNodeValues.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> dfsInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        if (root == null) {
            return results;
        }
        traverseInOrder(root, results);
        return results;
    }

    private void traverseInOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }
        traverseInOrder(currentNode.left, results);
        results.add(currentNode.value);
        traverseInOrder(currentNode.right, results);
    }


    //--------作答2：設定上下界(min/max boundaries)----------
    public boolean isValidBST2() {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(Node currentNode, long min, long max) {
        if (currentNode == null) {
            return true;
        }

        if (currentNode.value <= min || currentNode.value >= max) {
            return false;
        }
        //左子樹 & 右子樹 都是合法二元樹時，才回傳true
        return validate(currentNode.left, min, currentNode.value) &&
                validate(currentNode.right, currentNode.value, max);
    }


    //--------作答3：維護prev節點----------
    private Node prev = null; //class層級變數

    public boolean isValidBST3() {
        prev = null;
        return validateInOrder(root);
    }

    private boolean validateInOrder(Node currentNode) {
        if (currentNode == null) {
            return true;
        }

        if (!validateInOrder(currentNode.left)) {
            return false;
        }

        if (prev != null && currentNode.value <= prev.value) {
            return false;
        }

        prev = currentNode;
        return validateInOrder(currentNode.right);
    }
}

