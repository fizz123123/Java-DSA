package binarysearchtree.leetcode;

/**
 * 題目: Invert Binary Tree
 * <p>
 * 題目摘要：
 * 撰寫一個方法來反轉（或稱鏡像）一棵二元樹，這意味著對於二元樹中的每一個節點，你必須交換它的左子節點和右子節點
 * <p>
 * 方法簽名：
 * private Node invertTree(Node node)
 * <p>
 * 參數 (Input)：
 * - node: 代表這棵二元樹根節點 (Root) 的 Node 物件
 * <p>
 * 回傳 (Output)：
 * - 返回反轉過後（左右鏡像互換）的二元樹的根節點
 * <p>
 * 實作要求與限制：
 * 1. 必須是遞迴 (Recursive)：藉由走訪整棵樹，並在遇到的每個節點上交換其左、右子節點
 * 2. 終止條件 (Base Case)：如果輸入的樹是空的（即傳入的 node 為 null），則直接回傳 null
 * 3. 原地修改 (In-place)：反轉操作必須在原有的樹結構上進行，不能創建出一棵全新的樹
 * 4. 適用性：必須能處理任何大小跟結構的二元樹，確保每個節點的左右子節點都確實被交換
 * <p>
 * 思路：樹結構走訪操作
 * 1. 用一個暫存變數 (temp) 來交換它的左、右子節點
 * 2. 對交換後的左子樹呼叫遞迴繼續反轉，也對右子樹呼叫遞迴繼續反轉
 * 3. 全部反轉完畢後，把當前節點回傳回去
 */
public class InvertBinaryTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void invertTree() {
        root = invertTree(root);
        //root = invertTree2(root);
    }

    //--------作答1-----------
    private Node invertTree(Node node){
        if(node == null){
            return null;
        }

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertTree(node.left);
        invertTree(node.right);

        return node;
    }


    //---------作答2：簡潔版-----------
    private Node invertTree2(Node node) {
        if (node == null) {
            return null;
        }

        Node temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);

        return node;
    }
}
