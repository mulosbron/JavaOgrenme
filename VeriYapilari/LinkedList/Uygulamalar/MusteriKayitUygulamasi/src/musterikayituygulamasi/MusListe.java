package musterikayituygulamasi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MusListe {
    MusNode head=null;
    MusNode tail=null;
    
    void ekle(int id, String ad, String soyad, String tel, 
            String adres, String urun){
        MusNode musNode=new MusNode(id, ad, soyad, tel, adres, urun);
        if(head==null){
            head=musNode;
            tail=musNode;
        }
        else{
            tail.next=musNode;
            musNode.prev=tail;
            tail=musNode;
        }
    }
    
    void sil(int id){
        MusNode temp=head;boolean areEqual=false;
        while(temp!=null){
            if(temp.id==id) {areEqual=true; break;}
            temp=temp.next;
        }
        if(head!=null&&areEqual){
            if(temp.next==null&&temp.prev==null){
                head=null;
                tail=null;
            }
            else if(temp==head){
                head=head.next;
                head.prev=null;
            }
            else if(temp==tail){
                tail=tail.prev;
                tail.next=null;
            }
            else{
                temp.next.prev=temp.prev;
                temp.prev.next=temp.next;
            }
        }
    }
    
    void guncelle(int id, String urun){
        if(head!=null){
        MusNode temp=head;
            while(temp!=null){
                if(temp.id==id){
                    temp.urun=urun;
                    break;
                } 
                temp=temp.next;
            }
        }
    }
    
    void ara(int id){
        if(head!=null){
        MusNode temp=head;
            while(temp!=null){
                if(temp.id==id){
                    System.out.println("Müşterinin ID'si: "+temp.id);
                    System.out.println("Müşterinin adı: "+temp.ad);
                    System.out.println("Müşterinin soyadı: "+temp.soyad);
                    System.out.println("Müşterinin tel. numarası: "+temp.tel);
                    System.out.println("Müşterinin adresi: "+temp.adres);
                    System.out.println("Müşterinin ürünü: "+temp.urun);
                    break;
                } 
                temp=temp.next;
            }
        }
    }
    
    void ekleMetin(){
        Scanner input=new Scanner(System.in);
        int id; String ad; String soyad; String tel; String adres; String urun;
        try{
            System.out.print("Müşterinin ID'si: ");
            id=input.nextInt();
            System.out.print("Müşterinin adı: ");
            ad=input.next();
            System.out.print("Müşterinin soyadı: ");
            soyad=input.next();
            System.out.print("Müşterinin tel. numarası: ");
            tel=input.next();
            System.out.print("Müşterinin adresi: ");
            adres=input.next();
            System.out.print("Müşterinin ürünü: ");
            urun=input.next();
            ekle(id, ad, soyad, tel, adres, urun);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    void silMetin(){
        Scanner input=new Scanner(System.in);
        int id;
        try{
            System.out.print("Bilgilerini silmek istediğiniz müşterinin"
                    + "ID'si: ");
            id=input.nextInt();
            sil(id);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    void guncelleMetin(){
        Scanner input=new Scanner(System.in);
        int id; String urun;
        try{
            System.out.print("Müşteri ID'si: ");
            id=input.nextInt();
            System.out.print("Ürünün güncel adı: ");
            urun=input.next();
            guncelle(id, urun);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    void araMetin(){
        Scanner input=new Scanner(System.in);
        int id;
        try{
            System.out.print("Müşterinin ID'si: ");
            id=input.nextInt();
            ara(id);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    void calistirMetin(){
        System.out.println("------------------------------------------------");
        System.out.println("\tYapmak İstediğiniz İşlem");
        System.out.println("------------------------------------------------");
        System.out.println("1-) Müşteri ekle");
        System.out.println("2-) Müşteri sil");
        System.out.println("3-) Kayıtları listele");
        System.out.println("4-) Müşteri ara");
        System.out.println("5-) Müşteri ürün bilgisini güncelle");
        System.out.println("0-) Çıkış yap");
        System.out.println("------------------------------------------------");
        System.out.print("Yapmak istediğiniz işlem numarası: ");
    }
    
    void calistir(){
        Scanner input=new Scanner(System.in);
        boolean continueLoop = true;
        int secim;
        while(continueLoop){
            calistirMetin();
            try{
                secim=input.nextInt();
                switch(secim){
                    case 1: ekleMetin(); break;
                    case 2: silMetin(); break;
                    case 3: goster(); break;
                    case 4: araMetin(); break;
                    case 5: guncelleMetin(); break;
                    case 0: continueLoop=false; break;
                    default:
                    System.out.println("Geçersiz seçim, "
                            + "lütfen tekrar deneyin.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Geçersiz giriş, lütfen tekrar deneyin.");
                input.nextLine();
            }
        }
    }
    
    void goster(){
        MusNode temp=head;
        System.out.printf("|%-8s|%-30s|%-29s|%-13s|%-35s|%-16s|\n",
                        "   ID", "              AD",
                "            SOYAD", "   TELEFON", "               ADRES",
                "      ÜRÜN");
        System.out.println("------------------------------------------------"
                + "---------------------------------------------------------"
                + "---------------------------------");
        while(temp!=null){
            System.out.printf("|%-8s|%-30s|%-29s|%-13s|%-35s|%-16s|\n",
                    temp.id,temp.ad,temp.soyad,
                    temp.tel,temp.adres,temp.urun);
            temp=temp.next;
        }
    }
}
