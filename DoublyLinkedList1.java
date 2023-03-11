package lab6;

public class DoublyLinkedList1<T> implements Cloneable {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // DoublyLinkedList implementation...

    @SuppressWarnings("unchecked")
    @Override
    public DoublyLinkedList<T> clone() {
        DoublyLinkedList<T> clonedList;
        try {
            clonedList = (DoublyLinkedList<T>) super.clone();
            clonedList.head = null;
            clonedList.tail = null;
            ((DoublyLinkedList<T>) clonedList).size = 0;
            Node<T> curr = this.head;
            while (curr != null) {
                clonedList.addLast(curr.data);
                curr = curr.next;
            }
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
        return clonedList;
    }

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
}

