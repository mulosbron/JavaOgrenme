package ogrencikayituygulamasi;

import java.util.Scanner;

public class HashTable {
    Ogrenci arr[];
    int size;

    public HashTable(int size) {
        this.size = size;
        this.arr = new Ogrenci[size];
        for(int i = 0; i < size; i++){
            this.arr[i] = new Ogrenci(); // nextleri null yapacak
        }
    }
    
    int generateIndex(int numara){
        return numara % size;
    }
    
    void add(int numara, String ad, int ort){
        int index = generateIndex(numara);
        Ogrenci ogr = new Ogrenci(numara, ad, ort);
        Ogrenci temp = arr[index];
        while(temp.next != null){
            temp.next = temp;
        }
        temp.next = ogr;
        System.out.println(ad + " eklendi");
    }
    
    void delete(int numara){
        int index = generateIndex(numara);
        Ogrenci temp = arr[index];
        Ogrenci temp2 = temp;
        boolean sonuc = false; 
        if(temp.next == null){
            sonuc = true;
            System.out.println(numara + " numaralı ogrenci yok.");
        }
        else if(temp.next.next != null && temp.next.numara == numara ){
            sonuc = true;
            temp.next = null;
            System.out.println(numara + " numaralı ogrenci silindi.");
        }
        else{
            while(temp.next!=null){
                temp2 = temp;
                temp = temp.next;
                
                if(temp.numara == numara){
                    sonuc = true;
                    temp2.next = temp.next;
                    System.out.println(numara + " numaralı ogrenci silindi."); 
                }
            }
        }
        if(sonuc == false){
            System.out.println(numara + " numaralı ogrenci kaydına ulaşılamadı.");
        }
    }
    
    void print(){
        System.out.println("Numara\t" + "Ad\t" + "Ortalama\t" + "Durum");
        for(int i = 0; i < size; i++){
            Ogrenci temp = arr[i];
            while(temp.next != null){
                System.out.println(temp.next.numara + "\t" + temp.next.ad + 
                        "\t" +  temp.next.ort + "\t" + temp.next.durum);
                temp=temp.next;
            }
        }
    }
    
    void search(int numara){
        int index = generateIndex(numara);
        Ogrenci temp = arr[index];
        boolean sonuc = false;
        while(temp.next != null){
            if(temp.next.numara == numara){
                sonuc = true;
                System.out.println(numara + " numaralı öğrencinin bilgileri");
                System.out.println("Ad : " + temp.next.ad);
                System.out.println("Ortalama : " + temp.next.ort);
                System.out.println("Durum : " + temp.next.durum);
                break;
            }
            temp = temp.next;
        }
        if(sonuc == false){
            System.out.println(numara + "numaralı ogrenci kaydına ulaşılamadı.");
        }
    }
    void run() {
        Scanner input = new Scanner(System.in);
        boolean devamEt = true;
        while (devamEt) {
            try {
                System.out.println("------------------------------------");
                System.out.println("\tYapmak İstediğiniz İşlemi Seçin");
                System.out.println("------------------------------------");
                System.out.println("1-) Yeni öğrenci ekleyin");
                System.out.println("2-) Tüm öğrenci bilgilerini listele");
                System.out.println("3-) Öğrenci kaydı sil");
                System.out.println("4-) Öğrenci ara");
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
                        add(no, ad, not);
                        break;
                    case 2:
                        System.out.println("Tüm Öğrenciler:");
                        print();
                        break;
                    case 3:
                        System.out.print("Silmek istediğiniz öğrencinin numarasını girin: ");
                        no = input.nextInt();
                        delete(no);
                        break;
                    case 4:
                        System.out.print("Aramak istediğiniz öğrencinin numarasını girin: ");
                        no = input.nextInt();
                        search(no);
                        break;
                    case 0:
                        System.out.println("Programdan çıkılıyor...");
                        devamEt = false;
                        break;
                    default:
                        System.out.println("Geçersiz seçim, Lütfen tekrar deneyin.");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                input.nextLine();
            }
        }
    }
}

