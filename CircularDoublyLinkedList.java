package lab6;

public class CircularDoublyLinkedList<T>{
    private Node<T> head;
    private int size;


    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public CircularDoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public <T> T first() {
        if (isEmpty()) {
            return null;
        }
        return (T) head.data;
    }

    public T last() {
        if (isEmpty()) {
            return null;
        }
        return head.prev.data;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            head.prev = head;
            head.next = head;
        } else {
            newNode.prev = head.prev;
            newNode.next = head;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            head.prev = head;
            head.next = head;
        } else {
            newNode.prev = head.prev;
            newNode.next = head;
            head.prev.next = newNode;
            head.prev = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T data = head.data;
        if (size == 1) {
            head = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.next;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T data = head.prev.data;
        if (size == 1) {
            head = null;
        } else {
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
        }
        size--;
        return data;
    }

    public void rotate() {
        if (!isEmpty()) {
            head = head.next;
        }
    }

    public void rotateBackward() {
        if (!isEmpty()) {
            head = head.prev;
        }
    }

}
