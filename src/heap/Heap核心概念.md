# Heap (堆積) 核心概念與筆記

## 1. 基本定義
- Heap 是一種特殊的「**完全二元樹 (Complete Binary Tree)**」
- 因為是完全二元樹，資料會由上而下、由左至右緊密排列，不會有空隙
- 實務上「不會」使用 Node 和指標來建立，而是直接使用連續記憶體結構 Array 或 ArrayList 來實作

## 2. 常見分類
- **Max-Heap (最大堆積)**：父節點的值永遠「大於或等於」子節點。Root 永遠是整棵樹的最大值 (本專案實作的類型)
- **Min-Heap (最小堆積)**：父節點的值永遠「小於或等於」子節點。Root 永遠是整棵樹的最小值
- *Note：兄弟節點 (左子與右子) 之間「沒有」任何大小順序關係，這點與 BST (二元搜尋樹) 完全不同*

## 3. 陣列索引對應公式 (以 0-based Indexing 為例)
若目前節點的索引為 `i`：
- **左子節點 (Left Child)** = `i * 2 + 1`
- **右子節點 (Right Child)** = `i * 2 + 2`
- **父節點 (Parent)** = `(i - 1) / 2` (整數除法，無條件捨去小數)

## 4. 核心操作與時間複雜度

### 4.1. 插入元素 Insert：`O(log N)`
- **步驟 1**：先將新元素加入到 ArrayList 的「最尾端」
- **步驟 2**：不斷與父節點比較，若比父節點大就交換 (Swap)，一路向上浮動到正確位置 (Bubble Up)

### 4.2. 移除元素 Remove (通常是取出最大值/最小值)：`O(log N)`
- **步驟 1**：取出 Root (索引 `0`) 的值作為回傳結果
- **步驟 2**：將 ArrayList 的「最後一個元素」移到 Root 的位置 (索引 `0`)，並將最後一個位置刪除
- **步驟 3**：將新的 Root 不斷與左右子節點比較，找出三者中的「最大值」進行交換，一路向下沉降到正確位置 (Sink Down)

### 4.3. 取得最大值 Peek：`O(1)`
- 永遠只需要拿 ArrayList 索引 `0` 的資料

## 5. 應用場景
- **優先佇列 (Priority Queue)** 的底層實作
- 找出陣列中第 K 大/第 K 小的元素 (Top K elements)
- 堆積排序法 (Heap Sort)
- 適合需要頻繁「取得當前最大/最小值」，但不要求整體資料完全排序的情境

## 6. Heap vs. BST
雖然兩者都是「樹狀結構」，但設計目的與規則完全不同：

### 6.1. 節點的順序規則 (Ordering)
- **Heap**：只有「上下」關係，父節點必定大於/小於子節點，但左子與右子之間「沒有」大小關係
- **BST**：有嚴格的「左右」關係，`左子節點 < 父節點 < 右子節點`

### 6.2. 結構的要求 (Structure)
- **Heap**：必須是「完全二元樹 (Complete Binary Tree)」，資料一定是從上到下、左到右填滿
- **BST**：沒有形狀限制，如果資料長得像竹竿，可能會退化成 `O(N)` 時間複雜度 (除非使用 AVL 或 Red-Black Tree 來平衡)

### 6.3. 搜尋能力 (Searching)
- **Heap 不適合搜尋**：因為左右子節點沒規則，如果要在 Heap 中尋找一個特定的值，需要遍歷全部 `O(N)`。它只擅長找最大/最小值
- **BST 專為搜尋設計**：尋找特定值的時間複雜度為 `O(log N)`

### 6.4. 資料遍歷 (Traversal)
- **Heap**：無法透過簡單的走訪直接得到完全排序的陣列 (必須依序 remove 才能完成 Heap Sort)
- **BST**：透過「中序走訪 (In-Order Traversal)」，立刻就能得到從小到大排序好的資料

## 7. Priority Queue (優先佇列)

### 7.1. 什麼是優先佇列？
- 一般的 Queue 是「先進先出 (FIFO)」
- 優先佇列 (Priority Queue) 則是「權重高/優先級高的先出」

### 7.2. 為什麼 Priority Queue 底層要用 Heap 來實作？
如果你用一般的 Array 或是 LinkedList 來實作優先佇列：
- **Array**：插入很快 `O(1)`，但要找出優先級最高的需要掃描全部 `O(N)`；或是讓陣列保持排序 `O(N)`，效率不佳
- **Heap**：插入 (Insert) 只要 `O(log N)`，移除 (Remove) 也是 `O(log N)`

### 7.3. Java 中的 Priority Queue
- Java 標準庫提供了 `java.util.PriorityQueue` 類別
- Java 預設的 Priority Queue 底層是一個「**Min-Heap (最小堆積)**」
- 也就是說，預設情況下「數字越小，優先級越高」(會最先被 remove 出來)
- 如果想在 Java 中作一個 **Max-Heap** (數字越大的先出)，可以在宣告時傳入反轉的 Comparator：

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());