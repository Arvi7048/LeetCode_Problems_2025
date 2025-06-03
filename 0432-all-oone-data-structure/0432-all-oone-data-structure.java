import java.util.*;

class AllOne {
    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Node> keyToNode;
    private Node head, tail;

    public AllOne() {
        keyToNode = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (keyToNode.containsKey(key)) {
            Node curr = keyToNode.get(key);
            Node next = curr.next;
            if (next == tail || next.count > curr.count + 1) {
                Node newNode = new Node(curr.count + 1);
                insertAfter(curr, newNode);
                next = newNode;
            }
            next.keys.add(key);
            keyToNode.put(key, next);
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) {
                remove(curr);
            }
        } else {
            if (head.next == tail || head.next.count > 1) {
                Node newNode = new Node(1);
                insertAfter(head, newNode);
            }
            head.next.keys.add(key);
            keyToNode.put(key, head.next);
        }
    }

    public void dec(String key) {
        if (!keyToNode.containsKey(key)) return;
        Node curr = keyToNode.get(key);
        if (curr.count == 1) {
            keyToNode.remove(key);
        } else {
            Node prev = curr.prev;
            if (prev == head || prev.count < curr.count - 1) {
                Node newNode = new Node(curr.count - 1);
                insertAfter(prev, newNode);
                prev = newNode;
            }
            prev.keys.add(key);
            keyToNode.put(key, prev);
        }
        curr.keys.remove(key);
        if (curr.keys.isEmpty()) {
            remove(curr);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void insertAfter(Node prev, Node newNode) {
        newNode.prev = prev;
        newNode.next = prev.next;
        prev.next.prev = newNode;
        prev.next = newNode;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
