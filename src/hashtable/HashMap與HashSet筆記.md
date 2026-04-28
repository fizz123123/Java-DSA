# Java HashMap 與 HashSet 實作筆記

## HashMap
- 基於 Hash Table 資料結構實作的 Map 介面
- 以 Key-Value 配對的形式儲存資料
- Key 必須是唯一的，不允許重複，但 Value 可以重複
- 允許存放一個 null 的 Key 以及多個 null 的 Value
- 基本操作如 put 與 get 的時間複雜度平均為 O(1)
- 內部透過雜湊函數計算 Key 的位置，當發生雜湊碰撞時，Java 8 之後會使用鏈結串列 (Linked List) 或紅黑樹 (Red-Black Tree) 來儲存碰撞的元素
- 由於依賴雜湊值來決定存放位置，迭代時無法保證元素的順序
- 內部結合陣列與節點 (Node/Entry) 的結構來儲存資料
- 每個鍵值對 (Key-Value mapping) 在內部被封裝成一個 Map.Entry 物件
- 每個 Entry 包含了 key、value、hash 值以及指向下一個結點的 Reference
- 遍歷 HashMap 的常見方式有三種主要視角：keySet、values、entrySet
- 透過 keySet() 取得所有的 key，再利用迴圈根據 key 取得對應的 value
- 透過 values() 直接取得所有的 value 集合，但無法反推得知對應的 key
- 透過 entrySet() 取得包含所有 Map.Entry 的集合，是同時需要 key 與 value 時最高效的遍歷方式
- 支援 Java 8 引入的 forEach() 方法，搭配 Lambda 運算式能以更簡潔的方式進行遍歷

## HashSet
- 基於 HashMap 實作的 Set 介面
- 專門用來儲存不重複的元素 (Unique Elements)
- 底層實際上是利用 HashMap 來儲存資料，將元素作為 HashMap 的 Key，並使用一個共用的常數 Dummy Object 作為所有 Key 的 Value
- 允許存放一個 null 元素
- 基本操作如 add、remove 與 contains 的時間複雜度平均為 O(1)
- 同樣無法保證迭代時元素的順序

## 兩者的差異與使用時機
- 當需要儲存鍵值對 (Key-Value) 的對應關係時，請選擇使用 HashMap
- 當只關心元素是否存在，且需要確保集合中沒有重複元素時，請選擇使用 HashSet
- 若需要保持元素插入的順序，可改用 LinkedHashMap 或 LinkedHashSet
- 若需要元素保持自動排序的狀態，可改用 TreeMap 或 TreeSet
