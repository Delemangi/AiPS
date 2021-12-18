package lab7.windowsExplorer;

import java.io.*;

public class WindowsExplorer {
    public static void main(String[] args) throws Exception {
        int i, j, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String commands[] = new String[N];

        for (i = 0; i < N; i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<String>();
        tree.makeRoot("c:");

        SLLNode<String> root;
        SLLNode<String> child;

        for (String str : commands) {
            String[] command = str.split("\\s+");

            switch (command[0]) {
                case "CREATE":
                    boolean flag = false;
                    root = (SLLNode<String>) tree.root();
                    child = root.firstChild;

                    // no children
                    if (child == null) {
                        root.firstChild = new SLLNode<>(command[1]);
                        root.firstChild.parent = root;

                        break;
                    }

                    // first child lexicographically bigger
                    if (child.getElement().compareTo(command[1]) > 0) {
                        root.firstChild = new SLLNode<>(command[1]);
                        root.firstChild.parent = child.parent;
                        root.firstChild.sibling = child;

                        break;
                    }

                    // default case
                    while (child.sibling != null) {
                        if (child.sibling.getElement().compareTo(command[1]) > 0) {
                            SLLNode<String> node = new SLLNode<>(command[1]);
                            node.sibling = child.sibling;
                            child.sibling = node;
                            node.parent = child.parent;

                            flag = true;
                            break;
                        }

                        child = child.sibling;
                    }

                    if (flag) {
                        break;
                    }

                    // last child lexicographically smaller
                    child.sibling = new SLLNode<>(command[1]);
                    child.sibling.parent = child.parent;

                    break;
                case "OPEN":
                    root = (SLLNode<String>) tree.root();
                    child = root.firstChild;

                    while (child != null) {
                        if (child.getElement().equals(command[1])) {
                            tree.root = child;
                            break;
                        }

                        child = child.sibling;
                    }

                    break;
                case "BACK":
                    tree.root = tree.root.parent;

                    break;
                case "PATH":
                    root = (SLLNode<String>) tree.root();
                    ArrayStack<String> path = new ArrayStack<>(100);

                    while (root != null) {
                        path.push(root.element);
                        root = root.parent;
                    }

                    while (!path.isEmpty()) {
                        System.out.print(path.pop());
                        System.out.print("\\");
                    }
                    System.out.println();

                    break;
                case "DELETE":
                    root = (SLLNode<String>) tree.root();
                    child = root.firstChild;

                    while (child != null) {
                        if (child.getElement().equals(command[1])) {
                            break;
                        }

                        child = child.sibling;
                    }

                    tree.remove(child);

                    break;
                case "PRINT":
                    root = (SLLNode<String>) tree.root();

                    while (root.parent != null) {
                        root = root.parent;
                    }

                    tree.printTreeRecursive(root, 0);

                    break;
            }
        }
    }
}