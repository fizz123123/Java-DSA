package binarysearchtree.leetcode;

/**
 * 題目：Convert Sorted Array to Balanced BST
 * <p>
 * 題目摘要：
 * 撰寫一個方法，將一個已按升序（從小到大）排列的整數陣列，轉換成一棵「高度平衡」的二元搜尋樹 (Height-Balanced BST)
 * 高度平衡的定義：樹中任意節點的左子樹和右子樹的深度相差不能超過 1。這能確保 BST 保留最佳的搜尋、新增與刪除效率
 * <p>
 * 方法簽名：
 * private Node sortedArrayToBST(int[] nums, int left, int right)
 * <p>
 * 參數 (Input)：
 * - nums: 升序排列的整數陣列
 * - left: 當前陣列區段的左邊界索引
 * - right: 當前陣列區段的右邊界索引
 * <p>
 * 回傳 (Output)：
 * - 返回構建好的高度平衡 BST 的根節點 (Root Node)
 * <p>
 * 思路(Divide and Conquer)：
 * 1. 取中間值為 Root：為了保持高度平衡，必須選擇當前陣列區段「正中間」的元素作為根節點
 * 2. 遞迴建構左子樹：陣列中間點「左半邊」的元素，全都小於中間點，因此遞迴將它們轉為左子樹
 * 3. 遞迴建構右子樹：陣列中間點「右半邊」的元素，全都大於中間點，因此遞迴將它們轉為右子樹
 * 4. 終止條件 (Base Case)：當 left > right 時，代表該區段已經沒有元素，回傳 null
 */
public class ConvertSortedArrayToBalancedBST {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void sortedArrayToBST(int[] nums) {
        root = sortedArrayToBST(nums, 0, nums.length - 1);
    }

    //-----------作答-------------
    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;

    }

}
