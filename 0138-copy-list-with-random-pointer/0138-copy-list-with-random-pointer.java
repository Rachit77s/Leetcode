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
        Node temp = head;
        Map<Node, Node> oldTonew = new HashMap<>();
        int ind = 0;
        while(temp != null){
            oldTonew.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        //System.out.println(oldTonew);
        temp = head;
        while(temp != null){
            oldTonew.get(temp).next = oldTonew.get(temp.next);
            oldTonew.get(temp).random = oldTonew.get(temp.random);
            temp = temp.next;
        }
        return oldTonew.get(head);
    }
}