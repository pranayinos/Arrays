public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtFirst("d");
        ll.insertAtFirst("c");
        ll.insertAtFirst("b");
        ll.insertAtFirst("a");
        ll.insertAtLast("e");
        ll.insertAtLast("f");
        ll.insertAtLast("g");
        ll.insertAtIndex(3, "3");
        ll.printList();
    }
}

class LinkedList {

    public class LinkedListNode{
        private String data;
        private LinkedListNode nextNode;

        public LinkedListNode(String data, LinkedListNode nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        public String getData() {
            return data;
        }

        public LinkedListNode getNextNode() {
            return nextNode;
        }
    }

    private LinkedListNode head;
    private int length = 0;

    public LinkedList() {
    }

    public synchronized LinkedListNode getHead() {
        return head;
    }

    public synchronized void insertAtFirst(String data){
        LinkedListNode temp = new LinkedListNode(data, head);
        head = temp;
        length++;
    }

    public synchronized void insertAtLast(String data){
        LinkedListNode runner = head;
        while(runner.nextNode!=null){
            runner = runner.getNextNode();
        }
        LinkedListNode temp = new LinkedListNode(data, null);
        runner.nextNode = temp;
        length++;
    }

    public synchronized void insertAtIndex(int index, String data){
        if (++index>=length){
            System.out.println("cannot insert position doesnot existe");
            return;
        }
        LinkedListNode runner = head;
        int counter = 1;
        while(counter < index-1){
            runner = runner.getNextNode();
            counter++;
        }
        LinkedListNode temp = new LinkedListNode(data, runner.getNextNode());
        runner.nextNode = temp;
        length++;
    }

    public void printList(){
        System.out.println();
        LinkedListNode runner = head;
        while(runner.nextNode!=null){
            System.out.print(runner.data);
            runner = runner.getNextNode();
            System.out.print("->");
        }
        System.out.print(runner.data);
    }
}

