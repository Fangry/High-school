
public class LinkedList {
    static Node head;
    int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public int countNodes() {
        int counter = 1;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addHead(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public void addEnd(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = temp;
    }

    public void insert(Node previous, int data) {
        if (previous == null) {
            System.out.println("previous node is empty.");
            return;
        }
        Node temp = new Node(data);
        temp.next = previous.next;
        previous.next = temp;
    }

    public void deleteKey(int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) { // if head has that key
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next; // skip that Node
    }

    public void deletePosition(int position) {
        if (head == null) return;
        Node temp = head;
        if (position == 0) { // if head is position
            head = temp.next;
            return;
        }
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            return;
        }
        temp.next = temp.next.next; // skip that node
    }

    public boolean containsData(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    public void swapNodes(int x, int y) { // get the nodes that contain those data, some if statements, then swap
        if (x == y) return;
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
        if (currX == null || currY == null) {
            return;
        }
        if (prevX != null) // if x is not head
            prevX.next = currY;
        else
            head = currY;
        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public int getNode(int index) {
        Node temp = head;
        int counter = 0;
        while (temp != null && counter < index) {
            temp = temp.next;
            counter++;
        }
        return temp.data;
    }

    public int getMid() {
        return getNode(countNodes() / 2);
    }

    public int getNodeFromLast(int indexFromLast) {
        return getNode(countNodes() - indexFromLast - 1);
    }

    void deleteList() {
        head = null;
    }

    public int count(int searchFor) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.data == searchFor) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    void reverse() {
        if (head == null)
            return;

        reverseUtil(null, head);
    }

    void reverseUtil(Node prev, Node node) {
        if (node.next != null)
            reverseUtil(node, node.next); // not at end --> go deeper
        else
            head = node; // at end --> set it as new head

        node.next = prev; // switch references
    }
}
