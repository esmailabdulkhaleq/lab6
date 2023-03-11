package lab6;

import java.util.Iterator;

import static java.util.Spliterators.iterator;
import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

public class Ex6_3 {
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DoublyLinkedList)) {
            return false;
        }
        DoublyLinkedList other = (DoublyLinkedList) o;
        if (size() != other.size()) return false;
        Iterator<E> it1 = iterator();
        Iterator<E> it2 = other.iterator();
        while (it1.hasNext()) {
            E e1 = it1.next();
            E e2 = it2.next();
            if (e1 == null ? e2 != null : !e1.equals(e2)) {
                return false;
            }
        }
        return true;
    }

    private Iterator<E> iterator() {
        Iterator<E> o = null;
        return o;
    }

}
