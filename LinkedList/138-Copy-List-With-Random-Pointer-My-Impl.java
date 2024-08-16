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
    Map<Node, Node> map = new HashMap<>();
    Node curr = head;
    while (curr != null) {
      if (!map.containsKey(curr)) {
        map.put(curr, new Node(curr.val));
      }
      Node newCurr = map.get(curr);
      if (map.containsKey(curr.next)) {
        newCurr.next = map.get(curr.next);
      } else {
        if (curr.next == null) {
          newCurr.next = null;
        } else {
          map.put(curr.next, new Node(curr.next.val));
          newCurr.next = map.get(curr.next);
        }
      }
      if (map.containsKey(curr.random)) {
        newCurr.random = map.get(curr.random);
      } else {
        if (curr.random == null) {
          newCurr.random = null;
        } else {
          map.put(curr.random, new Node(curr.random.val));
          newCurr.random = map.get(curr.random);
        }
      }
      curr = curr.next;
    }
    return map.get(head);
  }
}
