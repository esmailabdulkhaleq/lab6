package lab6;

import org.w3c.dom.Node;

public class Ex6_2 {
    public int size() {
        int count = 0;
        Node head = null;
        Node current;
        current = head;
        while (current != null) {
            count++;


            current = current.getNextSibling();
        }
        return count;
    }

}
