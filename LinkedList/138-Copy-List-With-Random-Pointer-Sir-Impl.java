/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  Map<Node, Node> map;

  public Node copyRandomList(Node head) {
    if (head == null)
      return head;
    map = new HashMap<>();
    Node curr = head;
    Node newCurr = clone(head);
    while (curr != null) {
      newCurr.next = clone(curr.next);
      newCurr.random = clone(curr.random);
      curr = curr.next;
      newCurr = newCurr.next;
    }
    return map.get(head);
  }

  private Node clone(Node node) {
    if (node == null)
      return null;
    if (map.containsKey(node)) {
      return map.get(node);
    }
    Node newNode = new Node(node.val);
    map.put(node, newNode);
    return newNode;
  }
}
