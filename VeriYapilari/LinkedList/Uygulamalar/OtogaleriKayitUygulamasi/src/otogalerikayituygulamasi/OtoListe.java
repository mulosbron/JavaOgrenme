package otogalerikayituygulamasi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OtoListe {
    OtoNode head=null;
    OtoNode tail=null;
    
    void ekle(String plaka, String marka, String model, String renk, 
            int alisFiyat, int satisFiyat, String aciklama){
        
        OtoNode otoNode=new OtoNode(plaka, marka, model, renk, alisFiyat, 
                satisFiyat, aciklama);
        if(head==null){
            head=otoNode;
            tail=otoNode;
            tail.next=head;
        }
        else{
            tail.next=otoNode;
            tail=otoNode;
            tail.next=head;
        }
    }
    
    void sil(String plaka){
        OtoNode temp=head;OtoNode temp2=head;boolean areEqual=false;
        if(head!=null){
            while(temp.next!=head){
                if(temp.plaka.equals(plaka)) {
                    break;
                } 
                temp2=temp;
                temp=temp.next;
            }
            if(head==tail){
                head=null;
                tail=null;
            }
            else if(temp==head){
                head=head.next;
                tail.next=head;
            }
            else if(temp==tail){
                tail=temp2;
                tail.next=head;
            }
            else{
                temp2.next=temp.next;
            }
        }
    }
    
    void ara(String plaka){
        if(head!=null){
        OtoNode temp=head;
            while(temp!=null){
                if(temp.plaka.equals(plaka)){
                    System.out.println("Arabanın plakası: "+temp.plaka);
                    System.out.println("Arabanın markası: "+temp.marka);
                    System.out.println("Arabanın modeli: "+temp.model);
                    System.out.println("Arabanın renki: "+temp.renk);
                    System.out.println("Arabanın alış fiyatı: "+temp.alisFiyat);
                    System.out.println("Arabanın satış fiyatı"+temp.satisFiyat);
                    System.out.println("Arabanın açıklaması"+temp.aciklama);
                    break;
                } 
                temp=temp.next;
            }
        }
    }
    
    void ekleMetin(){
        Scanner input=new Scanner(System.in);
        String plaka; String marka; String model; String renk; 
        int alisFiyat;int satisFiyat; String aciklama;
        try{
            System.out.print("Arabanın plakası: ");
            plaka=input.next();
            System.out.print("Arabanın markası: ");
            marka=input.next();
            System.out.print("Arabanın modeli: ");
            model=input.next();
            System.out.print("Arabanın renk: ");
            renk=input.next();
            System.out.print("Arabanın alış fiyatı: ");
            alisFiyat=input.nextInt();
            System.out.print("Arabanın satış fiyatı: ");
            satisFiyat=input.nextInt();
            System.out.print("Arabanın açıklaması: ");
            aciklama=input.next();
            ekle(plaka, marka, model, renk, alisFiyat, satisFiyat, aciklama);
        }catch(Exception e){
            System.out.println(e);
            calistir();
        }
    }
    
    void silMetin(){
        Scanner input=new Scanner(System.in);
        String plaka;
        try{
            System.out.print("Öğrencinin numarası: ");
            plaka=input.next();
            sil(plaka);
        }catch(Exception e){
            System.out.println(e);
            calistir();
        }
    }
    
    void araMetin(){
        Scanner input=new Scanner(System.in);
        String plaka;
        try{
            System.out.print("Arabanın plakası: ");
            plaka=input.next();
            ara(plaka);
        }
        catch(Exception e){
            System.out.println(e);
            calistir();
        }
    }
    
    void goster(){
        System.out.printf("|%-30s|\n","     ARABALARIN PLAKALARI");
        if(head!=null){
            OtoNode temp=head;
            do{
                System.out.printf("|%-30s|\n",temp.plaka);
                temp=temp.next;
            }while(temp!=head);
        }
    }
    
    void calistirMetin(){
        System.out.println("------------------------------------------------");
        System.out.println("\tYapmak İstediğiniz İşlem");
        System.out.println("------------------------------------------------");
        System.out.println("1-) Araba ekle");
        System.out.println("2-) Araba sil");
        System.out.println("3-) Kayıtları listele");
        System.out.println("4-) Araba ara");
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
                input.nextLine();
                switch(secim){
                    case 1: ekleMetin(); break;
                    case 2: silMetin(); break;
                    case 3: goster(); break;
                    case 4: araMetin(); break;
                    case 0: continueLoop=false; break;
                    default: System.out.print("Hatalı giriş"); break;
                }
            }catch(InputMismatchException e){
                System.out.println(e);
                input.nextLine();
            }catch(Exception e){
                System.out.println(e);
                input.nextLine();
            }
        }
    }
}
