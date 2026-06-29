// ============================================================
//  CIRCULAR SINGLE LINKED LIST
//  Operations: Insert (Begin/End), Delete (Begin/End),
//              Traverse, Search
//  Key difference: last node's next points back to head (not null)
//  Reference: https://www.geeksforgeeks.org/linked-list-in-java/
// ============================================================

public class CircularSingleLinkedList {

    // ----------------------------------------------------------
    // Node class
    // ----------------------------------------------------------
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // ----------------------------------------------------------
    // Circular Linked List
    // ----------------------------------------------------------
    static class CircularLL {
        Node head = null;
        Node tail = null;

        // 1. Insert at Beginning
        void insertAtBegin(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
                node.next = head; // points to itself
            } else {
                node.next = head;
                head = node;
                tail.next = head; // tail always points to head
            }
        }

        // 2. Insert at End
        void insertAtEnd(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
                node.next = head;
            } else {
                tail.next = node;
                tail = node;
                tail.next = head; // circular link
            }
        }

        // 3. Delete at Beginning
        void deleteAtBegin() {
            if (head == null) return;
            if (head == tail) { head = tail = null; return; }
            head = head.next;
            tail.next = head; // maintain circular link
        }

        // 4. Delete at End
        void deleteAtEnd() {
            if (head == null) return;
            if (head == tail) { head = tail = null; return; }

            Node temp = head;
            while (temp.next != tail) temp = temp.next;
            temp.next = head;
            tail = temp;
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

        // 6. Display (traverse full circle once)
        void display() {
            if (head == null) { System.out.println("Empty list"); return; }
            Node temp = head;
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("(back to HEAD:" + head.value + ")");
        }
    }

    // ----------------------------------------------------------
    // MAIN
    // ----------------------------------------------------------
    public static void main(String[] args) {

        CircularLL list = new CircularLL();

        System.out.println("=== Insert at End ===");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display();     // 10 -> 20 -> 30 -> (back to HEAD:10)

        System.out.println("\n=== Insert at Begin ===");
        list.insertAtBegin(5);
        list.display();     // 5 -> 10 -> 20 -> 30 -> (back to HEAD:5)

        System.out.println("\n=== Delete at Begin ===");
        list.deleteAtBegin();
        list.display();     // 10 -> 20 -> 30 -> (back to HEAD:10)

        System.out.println("\n=== Delete at End ===");
        list.deleteAtEnd();
        list.display();     // 10 -> 20 -> (back to HEAD:10)

        System.out.println("\n=== Search 20 ===");
        System.out.println("Found 20: " + list.search(20));
        System.out.println("Found 99: " + list.search(99));
    }
}
