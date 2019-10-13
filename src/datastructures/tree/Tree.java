package datastructures.tree;

import java.util.*;

public class Tree {
    Node root;
    int numberOfNodes = 0;

    public Tree(String s) {
        this.root = new Node(3);
        Node r1 = new Node(5);
        Node l1 = new Node(1);
        Node ll = new Node(0);
        Node lr = new Node(2);
        Node rl = new Node(4);
        Node rr = new Node(6);
        root.left = l1;
        root.left.left = ll;
        root.left.right = lr;
        root.right = r1;
        root.right.left = rl;
        root.right.right = rr;
    }

    public Tree() {
    }

    public void add(int data) {
        Node curr = root;
        Node temp = null;
        while (curr != null) {
            temp = curr;
            if (data > curr.data) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        if (temp == null) {
            root = new Node(data);
        } else if (data < temp.data) {
            temp.left = new Node(data);
        } else {
            temp.right = new Node(data);
        }
        numberOfNodes++;
    }

    public List<Integer> traverseInOrderRecursively() {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public List<Integer> traverseInOrder() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node current = root;
        boolean done = false;
        while (!done) {
            if (current != null) {
                nodeStack.push(current);
                current = current.left;
            } else {
                if (nodeStack.empty()) {
                    done = true;
                } else {
                    current = nodeStack.pop();
                    list.add(current.data);
                    current = current.right;

                }
            }

        }
        return list;
    }

    public List<Integer> traversePreOrder() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node current = root;
        nodeStack.push(current);
        while (!nodeStack.empty()) {
            current = nodeStack.pop();
            list.add(current.data);
            if(current.right!=null) {
                nodeStack.push(current.right);
            }
            if(current.left!=null) {
                nodeStack.push(current.left);
            }
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> traverseLevelOrder() {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offerFirst(root);
        queue.offerFirst(null);
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node current = queue.pollLast();
            if(current != null) {
                temp.add(current.data);
                if(current.left!=null) {
                    queue.offerFirst(current.left);
                }
                if(current.right!=null) {
                    queue.offerFirst(current.right);

                }
            } else {
                result.add(new ArrayList<>(temp));
                temp.clear();
                if(!queue.isEmpty()){
                    queue.offerFirst(null);
                }
            }
        }
        return result;
    }

    private void inOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }
}
