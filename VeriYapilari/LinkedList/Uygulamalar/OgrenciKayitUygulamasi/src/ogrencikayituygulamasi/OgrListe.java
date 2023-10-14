package ogrencikayituygulamasi;

import java.util.Scanner;

public class OgrListe {
    OgrNode head=null;
    OgrNode tail=null;
    
    void ekleMetin(){
        Scanner input=new Scanner(System.in);
        int numara; String ad; String soyad; double vize; double fin;
        try{
            System.out.print("Öğrencinin numarası: ");
            numara=input.nextInt();
            System.out.print("Öğrencinin adı: ");
            ad=input.next();
            System.out.print("Öğrencinin soyadı: ");
            soyad=input.next();
            System.out.print("Öğrencinin vize puanı: ");
            vize=input.nextDouble();
            System.out.print("Öğrencinin final puanı: ");
            fin=input.nextDouble();
            ekle(numara, ad, soyad, vize, fin);
        }catch(Exception e){
            System.out.println(e);
            calistir();
        }
        
    }
    
    void ekle(int numara, String ad, String soyad, double vize, double fin){
        OgrNode ogrNode=new OgrNode(numara, ad, soyad, vize, fin);
        if(head==null){
            head=ogrNode;
            tail=ogrNode;
        }
        else{
            tail.next=ogrNode;
            tail=ogrNode;
        }
    }
    
    void silMetin(){
        Scanner input=new Scanner(System.in);
        int numara;
        try{
            System.out.print("Öğrencinin numarası: ");
            numara=input.nextInt();
            sil(numara);
        }catch(Exception e){
            System.out.println(e);
            calistir();
        }
    }
    
    void sil(int numara){
        OgrNode temp=head;OgrNode temp2=head;boolean areEqual=false;
        do{
            if(temp.numara==numara) {
                areEqual=true;
                break;
            } 
            temp=temp.next;
        }while(temp.next!=null);
        if(head!=null){
            temp=head;
            while(temp.next!=null){
                if(temp.numara==numara&&areEqual==true) break;
                temp2=temp;
                temp=temp.next;
            }
            if(temp==head){
                head=head.next;
            }
            else if(temp==tail){
                temp2.next=null;
                tail=temp2;
            }
            else{
                temp2.next=temp.next;
            }
        }
    }
    
    void goster(){
        OgrNode temp=head;
        System.out.printf("|%-10s|%-30s|%-29s|%-10s|%-9s|\n",
                        "  NUMARA", "              AD",
                "            SOYAD", " ORTALAMA", "  DURUM");
        System.out.println("------------------------------------------------"
                + "----------------------------------------------");
        while(temp!=null){
            if(temp.next==null){
                System.out.printf("|%-10s|%-30s|%-29s|%-10s|%-9s|\n",
                        temp.numara,temp.ad,temp.soyad,
                        temp.ortalama,temp.durum);
            }
            else{
                System.out.printf("|%-10s|%-30s|%-29s|%-10s|%-9s|\n",
                        temp.numara,temp.ad,temp.soyad,
                        temp.ortalama,temp.durum);
            }
            temp=temp.next;
        }
        System.out.println();
    }
    
    void enBasarili(){
        OgrNode basariliOgrenci,temp=head,temp2;
        do{
            temp2=temp;
            temp=temp.next;
            if(temp2.ortalama>temp.ortalama){
                basariliOgrenci=temp2;
            }
            else{
                basariliOgrenci=temp;
            }
        }while(temp.next!=null);
        System.out.printf("|%-10s|%-30s|%-29s|%-10s|%-9s|\n",
                        "  NUMARA", "              AD",
                "            SOYAD", " ORTALAMA", "  DURUM");
        System.out.println("------------------------------------------------"
                + "----------------------------------------------");
        System.out.printf("|%-10s|%-30s|%-29s|%-10s|%-9s|\n",
                        basariliOgrenci.numara,basariliOgrenci.ad,
                        basariliOgrenci.soyad,basariliOgrenci.ortalama,
                        basariliOgrenci.durum);
    }
    
    void calistirMetin(){
        System.out.println("------------------------------------------------");
        System.out.println("\tYapmak İstediğiniz İşlem");
        System.out.println("------------------------------------------------");
        System.out.println("1-) Öğrenci ekle");
        System.out.println("2-) Öğrenci sil");
        System.out.println("3-) Kayıtları listele");
        System.out.println("4-) En başarılı öğrenciyi göster");
        System.out.println("0-) Çıkış yap");
        System.out.println("------------------------------------------------");
        System.out.print("Yapmak istediğiniz işlem numarası: ");
    }
    
    void calistir(){
        Scanner input=new Scanner(System.in);
        boolean continueLoop = true;
        byte secim;
        while(continueLoop){
            calistirMetin();
            try{
                secim=input.nextByte();
                switch(secim){
                    case 0: continueLoop=false; break;
                    case 1: ekleMetin(); break;
                    case 2: silMetin(); break;
                    case 3: goster(); break;
                    case 4: enBasarili(); break;
                }
            }catch(Exception e){
                System.out.println(e);
                calistir();
            }
        }
    }
}
