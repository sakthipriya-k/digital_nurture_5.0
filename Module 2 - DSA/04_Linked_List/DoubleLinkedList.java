// ============================================================
//  DOUBLE LINKED LIST (DLL)
//  Operations: Insert (Begin/End/Position), Delete (Begin/End/Position),
//              Search, Traverse (Forward & Backward)
//  Key: Each node has both next AND prev pointer
//  Reference: https://www.geeksforgeeks.org/linked-list-in-java/
// ============================================================

public class DoubleLinkedList {

    // ----------------------------------------------------------
    // Node class — has prev AND next
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
    // DLL class
    // ----------------------------------------------------------
    static class DLL {
        Node head = null;
        Node tail = null;

        // 1. Insert at Beginning
        void insertAtBegin(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        // 2. Insert at End
        void insertAtEnd(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        // 3. Insert at Position (0-based)
        void insertAtPosition(int value, int index) {
            if (index == 0) { insertAtBegin(value); return; }

            Node temp = head;
            for (int i = 0; i < index - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null || temp.next == null) { insertAtEnd(value); return; }

            Node node = new Node(value);
            node.next = temp.next;
            node.prev = temp;
            if (temp.next != null) temp.next.prev = node;
            temp.next = node;
        }

        // 4. Delete at Beginning
        void deleteAtBegin() {
            if (head == null) return;
            if (head == tail) { head = tail = null; return; }
            head = head.next;
            head.prev = null;
        }

        // 5. Delete at End
        void deleteAtEnd() {
            if (tail == null) return;
            if (head == tail) { head = tail = null; return; }
            tail = tail.prev;
            tail.next = null;
        }

        // 6. Delete at Position (0-based)
        void deleteAtPosition(int index) {
            if (head == null) return;
            if (index == 0) { deleteAtBegin(); return; }

            Node temp = head;
            for (int i = 0; i < index && temp != null; i++)
                temp = temp.next;

            if (temp == null) return;
            if (temp == tail) { deleteAtEnd(); return; }

            temp.prev.next = temp.next;
            if (temp.next != null) temp.next.prev = temp.prev;
        }

        // 7. Search
        boolean search(int key) {
            Node temp = head;
            while (temp != null) {
                if (temp.value == key) return true;
                temp = temp.next;
            }
            return false;
        }

        // 8. Display Forward
        void displayForward() {
            Node temp = head;
            System.out.print("Forward:  ");
            while (temp != null) {
                System.out.print(temp.value + " <-> ");
                temp = temp.next;
            }
            System.out.println("NULL");
        }

        // 9. Display Backward
        void displayBackward() {
            Node temp = tail;
            System.out.print("Backward: ");
            while (temp != null) {
                System.out.print(temp.value + " <-> ");
                temp = temp.prev;
            }
            System.out.println("NULL");
        }
    }

    // ----------------------------------------------------------
    // MAIN
    // ----------------------------------------------------------
    public static void main(String[] args) {

        DLL list = new DLL();

        System.out.println("=== Insert at End ===");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.displayForward();
        list.displayBackward();

        System.out.println("\n=== Insert at Begin ===");
        list.insertAtBegin(5);
        list.displayForward();

        System.out.println("\n=== Insert at Position 2 (value=15) ===");
        list.insertAtPosition(15, 2);
        list.displayForward();

        System.out.println("\n=== Delete at Begin ===");
        list.deleteAtBegin();
        list.displayForward();

        System.out.println("\n=== Delete at End ===");
        list.deleteAtEnd();
        list.displayForward();

        System.out.println("\n=== Search 20 ===");
        System.out.println("Found 20: " + list.search(20));
        System.out.println("Found 99: " + list.search(99));
    }
}
