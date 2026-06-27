// ============================================================
//  CIRCULAR DOUBLE LINKED LIST (CDLL)
//  Operations: Insert (Begin/End), Delete (Begin/End),
//              Search, Traverse
//  Key: Each node has prev AND next; last node's next = head,
//       head's prev = tail (forms a complete circle both ways)
//  Reference: https://www.geeksforgeeks.org/linked-list-in-java/
// ============================================================

public class CircularDoubleLinkedList {

    // ----------------------------------------------------------
    // Node class
    // ----------------------------------------------------------
    static class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    // ----------------------------------------------------------
    // Circular DLL
    // ----------------------------------------------------------
    static class CDLL {
        Node head = null;
        Node tail = null;

        // 1. Insert at Beginning
        void insertAtBegin(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
                node.next = node; // points to itself
                node.prev = node;
            } else {
                node.next = head;
                node.prev = tail;
                head.prev = node;
                tail.next = node;
                head = node;
            }
        }

        // 2. Insert at End
        void insertAtEnd(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
                node.next = node;
                node.prev = node;
            } else {
                node.next = head;
                node.prev = tail;
                tail.next = node;
                head.prev = node;
                tail = node;
            }
        }

        // 3. Delete at Beginning
        void deleteAtBegin() {
            if (head == null) return;
            if (head == tail) { head = tail = null; return; }
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }

        // 4. Delete at End
        void deleteAtEnd() {
            if (tail == null) return;
            if (head == tail) { head = tail = null; return; }
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }

        // 5. Search
        boolean search(int key) {
            if (head == null) return false;
            Node temp = head;
            do {
                if (temp.value == key) return true;
                temp = temp.next;
            } while (temp != head);
            return false;
        }

        // 6. Display Forward
        void displayForward() {
            if (head == null) { System.out.println("Empty list"); return; }
            Node temp = head;
            System.out.print("Forward:  ");
            do {
                System.out.print(temp.value + " <-> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("(back to HEAD:" + head.value + ")");
        }

        // 7. Display Backward
        void displayBackward() {
            if (tail == null) return;
            Node temp = tail;
            System.out.print("Backward: ");
            do {
                System.out.print(temp.value + " <-> ");
                temp = temp.prev;
            } while (temp != tail);
            System.out.println("(back to TAIL:" + tail.value + ")");
        }
    }

    // ----------------------------------------------------------
    // MAIN
    // ----------------------------------------------------------
    public static void main(String[] args) {

        CDLL list = new CDLL();

        System.out.println("=== Insert at End ===");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.displayForward();
        list.displayBackward();

        System.out.println("\n=== Insert at Begin ===");
        list.insertAtBegin(5);
        list.displayForward();

        System.out.println("\n=== Delete at Begin ===");
        list.deleteAtBegin();
        list.displayForward();

        System.out.println("\n=== Delete at End ===");
        list.deleteAtEnd();
        list.displayForward();

        System.out.println("\n=== Search ===");
        System.out.println("Found 20: " + list.search(20));
        System.out.println("Found 99: " + list.search(99));
    }
}
