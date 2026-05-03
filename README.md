# Java DSA 學習指南 (Java Data Structures and Algorithms)

這是我在學習基於 Java 的資料結構與演算法課程時所建立的專案，本專案的主要目的在於**使用 Java 語法從零實作各種基礎資料結構**，並配合完成對應的**經典演算法面試題目**

可以將此專案 clone 到本地端，依照自己的需求進行練習，並請 AI 幫你進行 Code Review，或者透過程式碼中留下的「題目摘要」與「思路註解」，幫助自己更好地理解解題邏輯與脈絡

##  專案特色

- **手寫資料結構**：不單純依賴 Java 內置函式庫，從零建構 LinkedList、BST、Graph 等底層結構，幫助你深度理解原理
- **實作**：實作中包含常見的面試題與演算法題（放置於各結構的 `leetcode` 等子套件中）
- **註解與筆記**：
  - **題目摘要**：每個演算法檔案開頭都會清楚說明題目要求、輸入/輸出參數，以及預期結果
  - **思路解析**：程式碼中附有解題的推導過程與步驟註解，並不是單純丟出最終答案
  - **學習筆記**：針對每個不同的資料結構與主題，專案隨附了 Markdown 筆記（如 ` LinkedList筆記.md`、`漸進符號與時間複雜度.md` 等），歸納核心理論

## 包含的篇章與主題

### 資料結構實作與練習 (`src/datastructures`)
- **Array (陣列)**: 包含 Max Subarray, Remove Element, Rotate 等經典操作題
- **Linked List (單向鏈結串列)**: 包含反轉、找尋中間節點、檢查迴圈等實作
- **Doubly Linked List (雙向鏈結串列)**
- **Stack (堆疊)** & **Queue (佇列)**: 手寫實作與雙互相轉換應用
- **Binary Search Tree (二元搜尋樹)**: 含樹的遍歷（BFS、DFS）及高度驗證等
- **Hash Table (雜湊表)**: 探討 HashMap / HashSet 底層邏輯與相關經典題（Two Sum, Item In Common）
- **Graph (圖)**: 頂點與邊的新增及移除實作
- **Heap (堆積)**: Max Heap/Min Heap 的插入 (insert) 與下沉 (sink down) 邏輯

### 演算法 (`src/algorithms`)
- **Bubble Sort (氣泡排序)**
- **Selection Sort (選擇排序)**
- **Insertion Sort (插入排序)**
- **Merge Sort (合併排序)**
- **Quick Sort (快速排序)**

*Note：部分演算法有特別實作於 Linked List 上的版本（如 `BubbleSortOfLinkedList.java`）*

## 使用方式

無論你是想要從頭練習，還是只是想參考思路，都可以透過此專案來學習：

1. **Clone 專案到本地工作區**
   ```bash
   git clone https://github.com/fizz123123/Java-DSA.git
   cd Java-DSA
   ```

2. **閱讀筆記與題目**
   你可以先閱讀各個 package 下的 Markdown 筆記來預習觀念。接著打開特定的 Java 檔案，檔案開頭的多行註解會為你說明 "這題要解什麼"

3. **清空實作，親手嘗試**
   如果你想要把它當作刷題工具，可以把方法內部的程式碼刪除（只保留宣告），自己從零將邏輯寫出來，嘗試跑通大腦裡的思路

4. **對照思路與註解**
   當你遇到卡關，或者寫完想看其他實作方式時，可以還原並參考我留下來的程式碼與中文註釋，相信那些思考軌跡能給你很直接的幫助

## 開發環境需求

- 本專案使用 **Java 21** 開發（大多數結構與語法仍可向下相容至較早期的 Java 版本）
- 推薦使用帶有優良支援的 IDE（如 IntelliJ IDEA 或 Eclipse）來開啟以此能獲得最佳閱讀與跳轉體驗

---

*Happy Coding！*
