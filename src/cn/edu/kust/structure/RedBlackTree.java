package cn.edu.kust.structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RedBlackTree {

    public static final Node NIL = new Node(null, null, null, null, Color.BLACK);

    enum Color { RED, BLACK }

    static class Node {
        private static Long count = 0L;

        final Long NODE_ID;

        Integer val;
        Node left;
        Node right;
        Node parent;
        Color color;

        public Node(Integer val) {
            this(val, NIL, NIL, NIL, Color.RED);
        }

        public Node(Integer val, Node left, Node right, Node parent, Color color) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.color = color;

            if (count == 1) {
                NIL.left = NIL;
                NIL.right = NIL;
                NIL.parent = NIL;
            }

            NODE_ID = count;
            count++;
        }
    }

    public Node root;

    public RedBlackTree() {
        this.root = NIL;
    }

    public static RedBlackTree insert(RedBlackTree tree, int val) {
        if (tree == null) {
            return tree;
        }

        Node y = NIL;
        Node x = tree.root;
        while (x != NIL) {
            y = x;
            if (x.val < val) {
                x = x.right;
            } else if (x.val == val) {
                // 相同则不插入
                return tree;
            } else {
                x = x.left;
            }
        }

        Node newNode = new Node(val);

        if (y == NIL) {
            tree.root = newNode;
        } else if (y.val < val) {
            y.right = newNode;
        } else {
            y.left = newNode;
        }

        newNode.parent = y;

        insertFixUp(tree, newNode);

        return tree;
    }

    public Integer min() {
        Node y = NIL;
        Node x = root;

        while (x != NIL) {
            y = x;
            x = x.left;
        }

        return y.val;
    }

    public Integer max() {
        Node y = NIL;
        Node x = root;

        while (x != NIL) {
            y = x;
            x = x.right;
        }

        return y.val;
    }

    public void inorder() {
        if (this.root != null || this.root != NIL) {
            inorder(this.root);
        }
    }

    public void levelOrder() {
        LinkedList<LinkedList<Node>> levelNodes = new LinkedList<>();

        Queue<Node> nodesQueue = new LinkedList<>();

        nodesQueue.offer(root);

        int count;
        int nodeNum;

        while (!nodesQueue.isEmpty()) {
            nodeNum = nodesQueue.size();
            count = 0;

            LinkedList<Node> nodes = new LinkedList<>();
            while (count < nodeNum) {
                Node current = nodesQueue.poll();
                nodes.add(current);

                if (current.left != NIL) {
                    nodesQueue.offer(current.left);
                }
                if (current.right != NIL) {
                    nodesQueue.offer(current.right);
                }

                count++;
            }
            levelNodes.add(nodes);
        }

        for (LinkedList<Node> nodes : levelNodes) {
            for (Node node : nodes) {
                System.out.print("(");
                System.out.print(node.val);
                System.out.print(", ");
                System.out.print(node.color);
                System.out.print(", P:");
                System.out.print(node.parent.val);
                System.out.print(") ");
            }
            System.out.println();
        }
    }

    private void inorder(Node root) {
        if (root != NIL) {
            inorder(root.left);
            System.out.print(root.val);
            System.out.print(" ");
            inorder(root.right);
        }
    }

    private static RedBlackTree insertFixUp(RedBlackTree tree, Node x) {
        Node z = x;

        while (z.parent.color == Color.RED) {
            if (z.parent == z.parent.parent.left) {
                // z的父节点是左节点

                Node y = z.parent.parent.right;

                if (y.color == Color.RED) {
                    // 情况1： 叔节点为红色 (父节点为红色)

                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;

                    z = z.parent.parent;
                    continue;
                }

                if (z == z.parent.right) {
                    // 情况2： 叔节点为黑色，z节点为右节点

                    z = z.parent;
                    tree = leftRotate(tree, z);
                }

                // 情况3： 叔节点为黑色，z节点为左节点
                if (z.parent.parent != NIL) {
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    tree = rightRotate(tree, z.parent.parent);
                } else {
                    tree = rightRotate(tree, z);
                }

            } else {
                // z的父节点是右节点

                Node y = z.parent.parent.left;

                if (y.color == Color.RED) {
                    // 情况1： 叔节点为红色，节点为红色

                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;

                    z = z.parent.parent;
                    continue;
                }

                if (z == z.parent.left) {
                    //

                    z = z.parent;
                    tree = rightRotate(tree, z);
                }

                //
                if (z.parent.parent != NIL) {
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    tree = leftRotate(tree, z.parent.parent);
                } else {
                    tree = leftRotate(tree, z);
                }

            }
        }

        tree.root.color = Color.BLACK;
        return tree;
    }

    private static RedBlackTree leftRotate(RedBlackTree tree, Node x) {
        if (x.right == NIL) {
            return tree;
        }

        Node y = x.right;
        x.right = y.left;

        if (y.left != NIL) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == NIL) {
            tree.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;

        return tree;
    }

    private static RedBlackTree rightRotate(RedBlackTree tree, Node x) {
        if (x.left == NIL) {
            return tree;
        }

        Node y = x.left;
        x.left = y.right;

        if (y.right != NIL) {
            y.right.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == NIL) {
            tree.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.right = x;
        x.parent = y;

        return tree;
    }


    public static void test1(int[] arr) {
        RedBlackTree tree = new RedBlackTree();

        for (int i = 0; i < arr.length; i++) {
            tree = RedBlackTree.insert(tree, arr[i]);

            tree.inorder();
            System.out.println();
            tree.levelOrder();
            System.out.println();
        }

        System.out.println("================ inorder ================");
        tree.inorder();

        System.out.println();
        System.out.println("================ level order ================");
        tree.levelOrder();

        System.out.println();
        System.out.println("The min node: " + tree.min());
        System.out.println("The max node: " + tree.max());

    }

    public static void test2(int nums) {
        Random rnd = new Random();
        int[] tmp = new int[nums];

        for (int i = 0; i < nums; i++) {
            tmp[i] = rnd.nextInt(1000);
            System.out.print(tmp[i]);
            System.out.print(", ");
        }
        System.out.println();
        test1(tmp);
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        int[] arr1 = {3, 4, 45, 67, 23, 13, 65};
        int[] arr2 = {479, 349, 150, 154, 462, 422, 139, 278, 39, 21, 434, 324, 143, 16, 155, 146, 3, 253, 163, 325};
        int[] arr3 = {37, 458, 259, 53, 486};
        int[] arr4 = {301, 112, 116, 304, 389, 131, 467, 217, 244, 234, 245, 320, 321, 367, 409, 208, 434, 238, 93, 463, 112, 301};
        int[] arr5 = {48, 279, 491, 127, 135, 4, 65, 29, 271, 356, 113, 418, 114, 242, 82, 26, 444, 487, 384, 339, 48, 279};

        int[] arr6 = {1, 1, 1, 1, 1, 1, 1};

        int[] arr7 = {339, 143, 42, 141, 340, 268, 25, 380, 303, 246, 285, 328, 68, 277, 282, 127, 79, 225, 435, 88};

        // test1(arr6);
        test2(10);
    }
}
