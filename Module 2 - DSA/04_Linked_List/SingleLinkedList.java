// ============================================================
//  SINGLE LINKED LIST
//  Operations: Insert (Begin/End/Position), Delete (Begin/End/Position),
//              Search, Traverse, Reverse (Iterative & Recursive),
//              Find Middle, Detect Loop, Remove Loop, Palindrome Check
//  Reference: https://www.geeksforgeeks.org/linked-list-in-java/
// ============================================================

public class SingleLinkedList {

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
    // LinkedList class with all operations
    // ----------------------------------------------------------
    static class LinkedList {
        Node head;
        Node tail;
        int size = 0;

        // 1. Insert at Beginning
        void insertAtBegin(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        // 2. Insert at End
        void insertAtEnd(int value) {
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        // 3. Insert at Position (0-based index)
        void insertAtPosition(int value, int index) {
            if (index == 0) { insertAtBegin(value); return; }
            if (index == size) { insertAtEnd(value); return; }

            Node node = new Node(value);
            Node temp = head;
            for (int i = 1; i < index; i++) temp = temp.next;
            node.next = temp.next;
            temp.next = node;
            size++;
        }

        // 4. Delete at Beginning
        void deleteAtBegin() {
            if (head == null) return;
            head = head.next;
            if (head == null) tail = null;
            size--;
        }

        // 5. Delete at End
        void deleteAtEnd() {
            if (head == null) return;
            if (head.next == null) { head = tail = null; size--; return; }

            Node temp = head;
            while (temp.next != tail) temp = temp.next;
            temp.next = null;
            tail = temp;
            size--;
        }

        // 6. Delete at Position (0-based index)
        void deleteAtPosition(int index) {
            if (head == null) return;
            if (index == 0) { deleteAtBegin(); return; }

            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                if (temp.next == null) return;
                temp = temp.next;
            }
            if (temp.next == tail) tail = temp;
            temp.next = temp.next.next;
            size--;
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

        // 8. Reverse (Iterative) - O(n)
        void reverse() {
            Node prev = null, curr = head, next = null;
            tail = head;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }

        // 9. Reverse (Recursive)
        Node reverseRecursive(Node head) {
            if (head == null || head.next == null) return head;
            Node newHead = reverseRecursive(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        // 10. Find Middle (Floyd's Slow-Fast Pointer)
        Node findMiddle() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // 11. Detect Loop (Floyd's Cycle Detection)
        boolean detectLoop() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }

        // 12. Find Length of Loop
        int loopLength() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    // count loop length
                    int count = 1;
                    Node temp = slow.next;
                    while (temp != slow) { count++; temp = temp.next; }
                    return count;
                }
            }
            return 0;
        }

        // 13. Remove Loop
        void removeLoop() {
            if (head == null || head.next == null) return;
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) break;
            }
            if (slow != fast) return; // no loop

            slow = head;
            if (slow == fast) {
                while (fast.next != slow) fast = fast.next;
            } else {
                while (slow.next != fast.next) { slow = slow.next; fast = fast.next; }
            }
            fast.next = null; // remove loop
        }

        // 14. Check Palindrome
        boolean isPalindrome() {
            if (head == null || head.next == null) return true;
            Node slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // reverse second half
            Node prev = null, curr = slow.next;
            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node first = head, second = prev;
            while (second != null) {
                if (first.value != second.value) return false;
                first = first.next;
                second = second.next;
            }
            return true;
        }

        // Display
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }
    }

    // ----------------------------------------------------------
    // MAIN
    // ----------------------------------------------------------
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("=== Insert at Begin ===");
        list.insertAtBegin(30);
        list.insertAtBegin(20);
        list.insertAtBegin(10);
        list.display();     // 10 -> 20 -> 30 -> END

        System.out.println("\n=== Insert at End ===");
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.display();     // 10 -> 20 -> 30 -> 40 -> 50 -> END

        System.out.println("\n=== Insert at Position 2 (value=25) ===");
        list.insertAtPosition(25, 2);
        list.display();     // 10 -> 20 -> 25 -> 30 -> 40 -> 50 -> END

        System.out.println("\n=== Delete at Begin ===");
        list.deleteAtBegin();
        list.display();

        System.out.println("\n=== Delete at End ===");
        list.deleteAtEnd();
        list.display();

        System.out.println("\n=== Delete at Position 1 ===");
        list.deleteAtPosition(1);
        list.display();

        System.out.println("\n=== Search 30 ===");
        System.out.println("Found: " + list.search(30));

        System.out.println("\n=== Reverse (Iterative) ===");
        list.reverse();
        list.display();

        System.out.println("\n=== Find Middle ===");
        System.out.println("Middle: " + list.findMiddle().value);

        System.out.println("\n=== Detect Loop ===");
        System.out.println("Loop exists: " + list.detectLoop());

        System.out.println("\n=== Palindrome Check ===");
        LinkedList palList = new LinkedList();
        palList.insertAtEnd(1);
        palList.insertAtEnd(2);
        palList.insertAtEnd(3);
        palList.insertAtEnd(2);
        palList.insertAtEnd(1);
        System.out.print("List: "); palList.display();
        System.out.println("Is palindrome: " + palList.isPalindrome());
    }
}
