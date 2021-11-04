package lab2.spojListiNajizmenicno;

import java.util.Iterator;

public class SLL implements Iterable<Integer> {
    private SLLNode first;
    private SLLNode last;

    public SLL() {
        this.first = null;
        this.last = null;
    }

    public static SLL specialJoin(SLL list1, SLL list2) {
        SLL newList = new SLL();

        while (list1.first != null && list1.first.succ != null && list2.first != null && list2.first.succ != null) {
            newList.insertLast(list1.first.element);
            list1.deleteFirst();
            newList.insertLast(list1.first.element);
            list1.deleteFirst();

            newList.insertLast(list2.first.element);
            list2.deleteFirst();
            newList.insertLast(list2.first.element);
            list2.deleteFirst();
        }

        while (list1.first != null) {
            newList.insertLast(list1.first.element);
            list1.deleteFirst();
        }

        while (list2.first != null) {
            newList.insertLast(list2.first.element);
            list2.deleteFirst();
        }

        return newList;
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

    public void deleteFirst() {
        first = first.succ;
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