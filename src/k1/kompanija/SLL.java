package k1.kompanija;

public class SLL {
    private SLLNode first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    public void insertFirst(int id, int plata) {
        SLLNode ins = new SLLNode(id, plata, first);
        first = ins;
    }

    public void insertLast(int id, int plata) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id, plata, null);
            tmp.succ = ins;
        } else {
            insertFirst(id, plata);
        }
    }

    public SLLNode getFirst() {
        return first;
    }

    public SLL brisi_pomali_od(int iznos) {
        while (first != null && first.plata < iznos) {
            first = first.succ;
        }

        SLLNode node = first;

        if (node != null) {
            while (node.succ != null) {
                if (node.succ.plata < iznos) {
                    node.succ = node.succ.succ;
                } else {
                    node = node.succ;
                }
            }
        }

        return this;
    }

    public SLL sortiraj_opagacki() {
        SLL newList = new SLL();
        SLLNode node;
        SLLNode min;

        for (int i = 0; i < length(); i++) {
            node = first;
            min = null;

            while (node != null) {
                if ((min == null || node.id < min.id) && (newList.first == null || node.id > newList.first.id)) {
                    min = node;
                }

                node = node.succ;
            }

            newList.insertFirst(min.id, min.plata);
        }

        return newList;
    }

    public void pecati(SLL lista) {
        SLLNode p = lista.first;
        if (p == null) {
            System.out.println("nema");
        }
        while (p != null) {
            System.out.println(p.id + " " + p.plata);
            p = p.succ;
        }
    }
}