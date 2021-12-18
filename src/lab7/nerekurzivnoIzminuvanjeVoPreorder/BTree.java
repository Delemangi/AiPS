package lab7.nerekurzivnoIzminuvanjeVoPreorder;

public class BTree<E> {
    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public void PreorderNonRecursive() {
        ArrayStack<BNode<E>> stack = new ArrayStack<>(100);

        stack.push(root);

        while (!stack.isEmpty()) {
            BNode<E> current = stack.pop();

            if (current == null) {
                continue;
            }

            System.out.print(current.info + " ");
            stack.push(current.right);
            stack.push(current.left);
        }

        System.out.println();
    }
}