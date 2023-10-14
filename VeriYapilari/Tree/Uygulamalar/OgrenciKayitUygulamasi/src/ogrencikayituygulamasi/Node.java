package ogrencikayituygulamasi;
public class Node {
    int no, not;
    String ad;
    Node left;
    Node right;
    
    Node(){
        this.no = 0;
        this.not = 0;
        this.ad = "";
        this.left = null;
        this.right = null;
    }
    
    public Node(int no, String ad, int not) {
        this.no = no;
        this.not = not;
        this.ad = ad;
        this.left = null;
        this.right = null;
    }
}
