package HT;

import java.util.ArrayList;

/*
 * Note：HashTable查詢 key 與 value 的時間複雜度不同
 *
 * 1.尋找 Key (例如 myMap.containsKey() 或 mySet.contains()):
 *  - 時間複雜度：O(1)
 *  - 原因：Hash Table 透過雜湊函數 (Hash Function) 算出身分證 (Hash Code)，
 *    能直接對應到陣列的索引 (Index) 位置，不需要逐一檢查，速度極快
 *
 * 2.尋找 Value (例如 myMap.containsValue()):
 *  - 時間複雜度：O(n)
 *  - 原因：Hash Table「沒有」針對 Value 建立任何索引或 Hash
 *    當我們想找某個特定的 Value 時，唯一的辦法就是把整個 Hash Table
 *    裡所有的 Key-Value 配對全部走訪一遍 (就像走訪一般陣列一樣) 直到找到為止
 */
public class MyHashTable {
    private int size = 7;
    private Node[] dataMap;//用來裝Node的reference

    public MyHashTable() {
        dataMap = new Node[size];
    }

    class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //雜湊
    private int hash(String key) {
        int hashValue = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hashValue = (hashValue + asciiValue * 23) % dataMap.length;
        }
        return hashValue;
    }

    //增、改
    public void put(String key, int value) {
        int index = hash(key);

        if (dataMap[index] == null) {
            //該位置是空的，直接放入
            dataMap[index] = new Node(key, value);
        } else {
            Node temp = dataMap[index];
            while (true) {
                //若key相同，就只更新value
                if (temp.key.equals(key)) {
                    temp.value = value;
                    return;
                }
                //都沒有相同的key，跳出迴圈
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = new Node(key, value);
        }
    }

    //查
    public Integer get(String key) {
        int index = hash(key);

        Node temp = dataMap[index];
        while (temp != null) {
            if (key.equals(temp.key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public ArrayList<String> keys() {
        ArrayList<String> keyList = new ArrayList<>();

        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];

            while (temp != null) {
                keyList.add(temp.key);
                temp = temp.next;
            }
        }
        return keyList;
    }
}
