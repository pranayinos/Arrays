package datastructures;

import java.util.HashMap;

public class LRUCacheRunner {

}

class LRUCache<K,V>{

    private class Node<K,V>{
        K key;
        V value;
        Node next;
        Node previous;

        public Node(K key, V value, Node next, Node previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    Node head, tail;
    HashMap<K, Node> nodeLookupTable;
    int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        nodeLookupTable = new HashMap<>(maxSize);
    }

    private Node removeFromEnd(){
        Node temp = tail;
        if(tail!=null){
            tail = tail.previous;
        }
        return temp;
    }

    private Node addAtBegining(K key, V value){
        Node newNode = new Node(key, value, head, null);
        head = newNode;
        return newNode;
    }

    private Node addAtBegining (Node newNode){
        Node temp = head;
        head = newNode;
        newNode.next = temp;
        temp.previous = head;
        return newNode;
    }

    public void put(K key, V value) {
        if(nodeLookupTable.containsKey(key)){
            Node existingNode = nodeLookupTable.get(key);
            existingNode.previous.next=existingNode.next;
            existingNode.next.previous=existingNode.previous;
            addAtBegining(existingNode);
        }
        if(nodeLookupTable.size()>=maxSize){
            Node removedNode = removeFromEnd();
            nodeLookupTable.remove(removedNode.key);
        }
        nodeLookupTable.put(key, addAtBegining(key, value));
    }


}
