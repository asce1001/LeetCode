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
  public Node copyRandomList(Node head) {
    if (head == null)
      return head;
    Node curr = head;
    while (curr != null) {
      Node newNode = new Node(curr.val);
      newNode.next = curr.next;
      curr.next = newNode;
      curr = newNode.next;
    }
    curr = head;
    while (curr != null) {
      if (curr.random != null) {
        curr.next.random = curr.random.next;
      }
      curr = curr.next.next;
    }
    curr = head;
    Node newCurr = head.next;
    Node newCurrHead = head.next;
    while (curr != null) {
      curr.next = curr.next.next;
      if (newCurr.next != null) {
        newCurr.next = newCurr.next.next;
      }
      curr = curr.next;
      newCurr = newCurr.next;
    }
    return newCurrHead;
  }
}
