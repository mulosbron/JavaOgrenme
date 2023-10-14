package hashtable;
public class Node {
    int key;
    Object data;
    Node next;
    
    public Node(){
        next=null;
    }
    
    public Node(int key, Object data) {
        this.key = key;
        this.data = data;
        next=null;
    }
}
