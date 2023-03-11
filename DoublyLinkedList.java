package lab6;


import java.util.Iterator;

public class DoublyLinkedList<E> {


    public E head;
    private final Node<E> sentinel; // sentinel node
    public E tail;
    public int size;
    private int size1; // number of elements in the list

    public Iterator<lab6.E> iterator() {
        Iterator<lab6.E> o = null;
        return o;
    }

    // nested Node class
        private static class Node<E> {
            private E element;
            private Node<E> prev;
            private Node<E> next;

            public Node(E e, Node<E> p, Node<E> n) {
                element = e;
                prev = p;
                next = n;
            }
        }

        // constructor
        public DoublyLinkedList() {
            sentinel = new Node<>(null, null, null);
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size1 = 0;
        }

        // accessor methods
        public int size() {
            return size1;
        }

        public boolean isEmpty() {
            return size1 == 0;
        }

        public E first() {
            if (isEmpty()) return null;
            return sentinel.next.element;
        }

        public E last() {
            if (isEmpty()) return null;
            return sentinel.prev.element;
        }

        // mutator methods
        public void addFirst(E e) {
            addBetween(e, sentinel, sentinel.next);
        }

        public void addLast(E e) {
            addBetween(e, sentinel.prev, sentinel);
        }

        public E removeFirst() {
            if (isEmpty()) return null;
            return remove(sentinel.next);
        }

        public E removeLast() {
            if (isEmpty()) return null;
            return remove(sentinel.prev);
        }

        // private update methods
        private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
            Node<E> newest = new Node<>(e, predecessor, successor);
            predecessor.next = newest;
            successor.prev = newest;
            size1++;
        }

        private E remove(Node<E> node) {
            Node<E> predecessor = node.prev;
            Node<E> successor = node.next;
            predecessor.next = successor;
            successor.prev = predecessor;
            size1--;
            return node.element;
        }
    }


