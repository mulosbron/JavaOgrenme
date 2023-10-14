package otoparkkayituygulamasi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OtoListe {
    OtoNode head;
    OtoNode tail;
    
    void ekle(String plaka, long dakika, long ucret){
        OtoNode otoNode=new OtoNode(plaka, dakika, ucret);
        if(head==null){
            head=otoNode;
            tail=otoNode;
            head.next=tail;
            tail.prev=head;
            head.prev=tail;
            tail.next=head;
        }
        else{
            otoNode.next=head;
            head.prev=otoNode;
            head=otoNode;
            head.prev=tail;
            tail.next=head;
        }
    }
    
    void sil(String plaka){
        if(head!=null){
            OtoNode temp=head;boolean areEqual=false;
            do{
                if(temp.plaka.equals(plaka)) {
                    areEqual=true;
                    break;
                }
                temp=temp.next;
            }while(temp!=tail.next);
            if(areEqual){
                if(head.next==tail&&tail.prev==head){
                    head=null;
                    tail=null;
                }
                else if(temp==head){
                    head=head.next;
                    head.prev=tail;
                    tail.next=head;
                }else if(temp==tail){
                    tail=tail.prev;
                    tail.next=head;
                    head.prev=tail;
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
            }
        }
        else{
            System.out.println("LİSTE BOŞ");
        }
    }
    
    void toplamGelir(){
        if(head!=null){
            long toplam=0;
            OtoNode temp=tail;
            System.out.println("----------------");
            System.out.printf("|%-14s|\n"," TOPLAM GELİR");
            System.out.println("----------------");
            do{
                toplam+=(temp.dakika*temp.ucret);
                temp=temp.prev;
            }while(temp!=head.prev);
            System.out.printf("|%-14s|\n",toplam);
            System.out.println("----------------");
        }
    }
    
    void ekleMetin(){
        Scanner input=new Scanner(System.in);
        String plaka;long dakika;long ucret;
        try{
            System.out.print("Arabanın plakası: ");
            plaka=input.next();
            System.out.print("Arabanın kalacağı dakika: ");
            dakika=input.nextLong();
            System.out.print("Arabanın ödeyeceği dakika başına ücret: ");
            ucret=input.nextLong();
            ekle(plaka, dakika, ucret);
        }catch(Exception e){
            System.out.println(e);
            calistir();
        }
    }
    
    void silMetin(){
        Scanner input=new Scanner(System.in);
        String plaka;
        try{
            System.out.print("Arabanın plakası: ");
            plaka=input.next();
            sil(plaka);
        }catch(Exception e){
            System.out.println(e);
            calistir();
        }
    }

    void calistirMetin(){
    System.out.println("------------------------------------------------");
        System.out.println("\tYapmak İstediğiniz İşlem");
        System.out.println("------------------------------------------------");
        System.out.println("1-) Arabayı ekle");
        System.out.println("2-) Arabayı sil");
        System.out.println("3-) Kayıtları listele");
        System.out.println("4-) Geliri görüntüle");
        System.out.println("0-) Çıkış yap");
        System.out.println("------------------------------------------------");
        System.out.print("Yapmak istediğiniz işlem numarası: ");    
    }
    
    void goster(){
        if(head!=null){
            OtoNode temp=tail;
            System.out.println("--------------------------------------------");
            System.out.printf("|%-11s|%-10s|%-7s|\n",
                    "   PLAKA", "  DAKIKA", " UCRET");
            System.out.println("--------------------------------------------");
            do{
                System.out.printf("|%-11s|%-10s|%-7s|\n",
                        temp.plaka,temp.dakika,temp.ucret);
                temp=temp.prev;
            }while(temp!=head.prev);
            System.out.println("--------------------------------------------");
        }
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
                    case 4: toplamGelir(); break;
                    case 0: continueLoop=false; break;
                    default: System.out.println("Hatalı giriş"); break;
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
