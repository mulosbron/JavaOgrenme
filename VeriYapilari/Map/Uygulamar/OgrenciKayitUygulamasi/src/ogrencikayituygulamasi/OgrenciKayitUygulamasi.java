package ogrencikayituygulamasi;

import java.util.Scanner;

public class OgrenciKayitUygulamasi {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Kontenjan boyutu: ");
        HashTable ht = new HashTable(input.nextInt());
        ht.run();
    }
}
