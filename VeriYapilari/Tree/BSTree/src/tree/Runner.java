package tree;
public class Runner {
    public static void main(String[] args) {
        // Binary Search Tree
        // preOrder(önce kök)       (10),8,5,9,15,12,20
        // inOrder(ortada kök)      5,8,9,(10),12,15,20
        // postOrder(sonda kök)     5,9,8,12,20,15,(10)
        BTree bt=new BTree();
        bt.root=bt.insert(bt.root, 10);
        bt.root=bt.insert(bt.root, 8);
        bt.root=bt.insert(bt.root, 15);   
        bt.root=bt.insert(bt.root, 5);   
        bt.root=bt.insert(bt.root, 12);   
        bt.root=bt.insert(bt.root, 20);
        bt.root=bt.insert(bt.root, 9);
        
        bt.preOrder(bt.root);
        System.out.println();
        bt.inOrder(bt.root);
        System.out.println();
        bt.postOrder(bt.root);
        System.out.println();
    }
}
