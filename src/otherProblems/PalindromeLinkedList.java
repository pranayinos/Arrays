package otherProblems;

import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {
//pagashe@opentable.com
//sghule@opentable.com
//pranaykumarsoni@gmail.com
        Node head = fromArray(new char[]{'a','a','b','a','a'});
        print(head);
        System.out.println("");
        System.out.println(palindromeCheck(head));


        head = fromArray(new char[]{});
        print(head);
        System.out.println("");
        System.out.println(palindromeCheck(head));
        System.out.println("");

        head = fromArray(new char[]{'a','a','b', 'c'});
        print(head);
        System.out.println("");
        System.out.println(palindromeCheck(head));
        System.out.println("");

        head = fromArray(new char[]{'a','b','b','a'});
        print(head);
        System.out.println("");
        System.out.println(palindromeCheck(head));
    }

    private static Node fromArray(char[] input){
        Node prev = null;

        //Creating backwards
        for(int i = input.length-1; i>=0; i--){
            Node current = new Node(input[i], prev);
            prev = current;
        }
        return prev;
    }

    private static void print (Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data);
            current = current.next;
        }
    }

    private static boolean palindromeCheck(Node head){
        if(head == null){
            return false;
        }
        Node traversalPtr = head;
        int size = 0;
        while(traversalPtr!=null){
            traversalPtr =traversalPtr.next;
            size++;
        }

        traversalPtr = head;
        Stack<Character> characterStack = new Stack<>();
        for(int i = 0; i < size/2; i++){
             characterStack.push(traversalPtr.data);
             traversalPtr = traversalPtr.next;
        }

        if(size%2==1){
            traversalPtr =traversalPtr.next;
        }
        while(traversalPtr!=null){
            if(traversalPtr.data != characterStack.pop()){
                return false;
            }
            traversalPtr =traversalPtr.next;
        }
        return true;
    }

    static class Node{
        char data;
        Node next;

        public Node(char data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
