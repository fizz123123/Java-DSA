package binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //-----迭代新增(Iterative Insert)-----
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    //-----迭代查詢(Iterative Contains)-----
    public boolean contains(int value) {
        if (root == null) return false;

        Node temp = root;
        while (temp != null) {

            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }

        }
        return false;
    }

    //-----遞迴查詢(Recursive Contains)------
    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.value == value) {
            return true;
        }

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    //-----遞迴新增(Recursive Insert)------
    public void rInsert(int value) {
        root = rInsert(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    //-----遞迴刪除(Recursive Remove)------
    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            //找到目標節點，接下來有三種分支
            //分支1：目標節點是一個leaf(沒有任何子節點)
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            //分支2：目標節點只有一個子節點(左 或 又)
            else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            }
            //分支3：目標節點同時擁有兩個子節點
            else {
                //3.1：在其 "右子樹" 中尋找最小值，來當作繼承節點
                int subTreeMin = minValue(currentNode.right);
                //3.2：將目標節點的值，重新賦值為繼承節點的值
                currentNode.value = subTreeMin;
                //3.3：把原本位置上的繼承節點刪掉
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    //-----helper method：尋找指定樹結構中的最小值------
    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    //------廣度優先搜尋/層序遍歷(Breadth-First Search)-----
    //Note：迭代遍歷 + Queue
    public ArrayList<Integer> bfs() {
        ArrayList<Integer> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        Queue<Node> queue = new LinkedList<>();
        Node currentNode = root;
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            results.add(currentNode.value);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    //------深度優先搜尋：前序遍歷(Depth-First Search：PreOrder)-----
    //Note：適合用來複製或序列化一棵樹
    public ArrayList<Integer> dfsPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        traversePreOrder(root, results);
        return results;
    }

    //執行前序遍歷(順序：中 -> 左 -> 右)
    private void traversePreOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }

        results.add(currentNode.value); //diff
        traversePreOrder(currentNode.left, results);
        traversePreOrder(currentNode.right, results);
    }

    //------深度優先搜尋：後序遍歷(Depth-First Search：PostOrder)-----
    //Note：適合用來刪除整棵樹，因為會從對底層的葉子開始刪
    public ArrayList<Integer> dfsPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        traversePostOrder(root, results);
        return results;
    }

    //執行後序遍歷(順序：左 -> 右 -> 中)
    private void traversePostOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }

        traversePostOrder(currentNode.left, results);
        traversePostOrder(currentNode.right, results);
        results.add(currentNode.value); //diff
    }

    //------深度優先搜尋：中序遍歷(Depth-First Search：InOrder)-----
    //Note：中序遍歷時，results內元素必定 "升序" 排列(用來取得sorted list)
    public ArrayList<Integer> dfsInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        traverseInOrder(root, results);
        return results;
    }

    //執行中序遍歷(順序：左 -> 中 -> 右)
    private void traverseInOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }

        traverseInOrder(currentNode.left, results);
        results.add(currentNode.value); //diff
        traverseInOrder(currentNode.right, results);
    }

}
