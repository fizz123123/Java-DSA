package datastructures.queue;

//FIFO先進先出(如：排隊隊伍)
public class MyQueue {
    Node first;
    Node last;
    int length;

    public MyQueue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printMyQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    //增
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    //刪
    public Node dequeue() {
        if (length == 0) return null;

        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = temp.next;
            temp.next = null;
        }
        length--;
        return temp;
    }


}
