package ogrencikayituygulamasi;

import java.util.Scanner;

public class Tree {
    Node root;
    
    public Tree(){
        this.root = null;
    }
    
    Node newNode(int no, String ad, int not){
        this.root = new Node(no, ad, not);
        return this.root;
    }
    
    Node insert(Node root, int no, String ad, int not){
        if(root != null){
            if(no < root.no){
                root.left = insert(root.left, no, ad ,not);
            }
            else{
                root.right = insert(root.right, no, ad, not);
            }
        }
        else{
            root = newNode(no, ad, not); 
        }
        return root;
    }
    
    Node delete(Node root, int no){
        Node t1, t2;
        if(root == null){
            return null;
        }
        if(root.no == no){
            if(root.left == root.right){
                root =null;
                return root;
            }
            else if(root.left == null){
                t1 = root.right;
                return t1;
            }
            else if(root.right == null){
                t1 = root.left;
                return t1;
            }
            else{
                t1 = t2 = root.right;
                while(t1.left != null){
                    t1 = t1.left;
                }
                t1.left = root.left;
                return t2;
            }
        }
        else{
            if( no < root.no){
                root.left = delete(root.left, no);
            }
            else{
                root.right = delete(root.right, no);
            }
        }
        return root;
    }
    
    void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.no + "\t" + root.ad + "\t" + root.not);
            inOrder(root.right);
        }
    }
    
    void run() {
        Scanner input = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            try {
                System.out.println("------------------------------------");
                System.out.println("\tYapmak İstediğiniz İşlem");
                System.out.println("------------------------------------");
                System.out.println("1-) Yeni öğrenci ekle");
                System.out.println("2-) Tüm öğrenci bilgilerini listele");
                System.out.println("3-) Öğrenci kaydı sil");
                System.out.println("0-) Çıkış");
                System.out.println("------------------------------------");
                System.out.print("İşlem numarası: ");
                int secim = input.nextInt();

                switch (secim) {
                    case 1:
                        System.out.print("Öğrenci No: ");
                        int no = input.nextInt();
                        input.nextLine();  // Enter tuşu sonrası boş satırı temizle
                        System.out.print("Öğrenci Adı: ");
                        String ad = input.nextLine();
                        System.out.print("Not: ");
                        int not = input.nextInt();
                        root = insert(root, no, ad, not);
                        break;
                    case 2:
                        System.out.println("Tüm Öğrenciler:");
                        inOrder(root);
                        break;
                    case 3:
                        System.out.print("Kaydı silinexek öğrenci: ");
                        no = input.nextInt();
                        root = delete(root, no);
                        break;
                    case 0:
                        System.out.println("Programdan çıkılıyor...");
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Geçersiz numara, Lütfen tekrar deneyiniz.");
                        break;
                }
            }catch (Exception e) {
                System.out.println(e);
                input.nextLine();
            }
        }
    }
}
