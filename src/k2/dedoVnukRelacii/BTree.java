package k2.dedoVnukRelacii;

public class BTree<E> {
    public BNode<E> head;

    public BTree() {
        head = new BNode<E>(null);
        // po definicija ako nema koren, t.e. ako stebloto e prazno
        head.left = head;
        head.ltag = '-';
        // kaj vodacot sekogas desnata vrska pokazuva kon samiot sebe
        head.right = head;
        head.rtag = '+';
    }

    public BNode<E> makeRoot(E elem) {
        BNode<E> tmp = new BNode<E>(elem);
        head.left = tmp;
        head.ltag = '+';

        tmp.left = head;
        tmp.ltag = '-';
        tmp.right = head;
        tmp.rtag = '-';

        return tmp;
    }

    public BNode<E> makeRootNode(BNode<E> tmp) {
        head.left = tmp;
        head.ltag = '+';

        tmp.left = head;
        tmp.ltag = '-';
        tmp.right = head;
        tmp.rtag = '-';

        return tmp;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {

            if (node.ltag == '+') // veke postoi element
            {
                return null;
            }

            tmp.left = node.left;
            tmp.ltag = '-';
            tmp.right = node;
            tmp.rtag = '-';
            node.left = tmp;
            node.ltag = '+';
        } else {

            if (node.rtag == '+') // veke postoi element
            {
                return null;
            }

            tmp.right = node.right;
            tmp.rtag = '-';
            tmp.left = node;
            tmp.ltag = '-';
            node.right = tmp;
            node.rtag = '+';
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {

            if (node.ltag == '+') // veke postoi element
            {
                return null;
            }

            tmp.left = node.left;
            tmp.ltag = '-';
            tmp.right = node;
            tmp.rtag = '-';
            node.left = tmp;
            node.ltag = '+';
        } else {

            if (node.rtag == '+') // veke postoi element
            {
                return null;
            }

            tmp.right = node.right;
            tmp.rtag = '-';
            tmp.left = node;
            tmp.ltag = '-';
            node.right = tmp;
            node.rtag = '+';
        }

        return tmp;
    }

    public BNode<E> insertRight(BNode<E> parent, E info) {

        BNode<E> child = new BNode<E>(info);

        child.ltag = '-';
        child.left = parent;
        child.rtag = parent.rtag;
        child.right = parent.right;

        parent.right = child;
        parent.rtag = '+';

        if (child.rtag == '+') {
            BNode<E> temp = child.right;
            while (temp.ltag == '+') {
                temp = temp.left;
            }
            temp.left = child;
        }

        return child;
    }

    public BNode<E> predecessorInorder(BNode<E> node) {

        if (node.ltag == '-') {
            return node.left;
        }

        BNode<E> p = node.left;
        while (p.rtag == '+') {
            p = p.right;
        }

        return p;
    }

    public BNode<E> successorInorder(BNode<E> node) {

        if (node.rtag == '-') {
            return node.right;
        }

        BNode<E> p = node.right;
        while (p.ltag == '+') {
            p = p.left;
        }

        return p;
    }

    public int getNumberOfRelations() {
        int a = 0;

        BNode<E> node = head;

        while (node != null) {


            node = successorInorder(node);
        }

        return a;
    }
}