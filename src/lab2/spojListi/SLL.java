package lab2.spojListi;

import java.util.Iterator;

public class SLL implements Iterable<Integer> {
    private SLLNode first;
    private SLLNode last;

    public SLL() {
        this.first = null;
        this.last = null;
    }

    public void insertFirst(int e) {
        first = new SLLNode(e, first);

        if (first.succ == null) {
            last = first;
        }
    }

    public void insertLast(int e) {
        if (first == null) {
            insertFirst(e);
        } else {
            last.succ = new SLLNode(e, null);
            last = last.succ;
        }
    }

    public void safeInsertLast(int e) {
        if (last == null || last.element != e) {
            insertLast(e);
        }
    }

    public void deleteFirst() {
        first = first.succ;
    }

    public SLL joinLists(SLL list) {
        SLL newList = new SLL();

        while (first != null && list.first != null) {
            if (first.element > list.first.element) {
                newList.safeInsertLast(list.first.element);
                list.deleteFirst();
            } else {
                newList.safeInsertLast(first.element);
                deleteFirst();
            }
        }

        while (first != null) {
            newList.safeInsertLast(first.element);
            first = first.succ;
        }

        while (list.first != null) {
            newList.safeInsertLast(list.first.element);
            list.first = list.first.succ;
        }

        return newList;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return first != null;
            }

            @Override
            public Integer next() {
                Integer a = first.element;
                first = first.succ;

                return a;
            }
        };
    }
}