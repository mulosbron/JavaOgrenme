package kurskayituygulamasi;

import java.util.Scanner;

public class KursStack {
    int counter;
    int kontenjan;
    KursNode top;
    
    public KursStack(int kontenjan) {
        this.kontenjan = kontenjan;
        counter=0;
        top=null;
    }
    
    boolean isEmpty(){
        return counter==0;
    }
    
    boolean isFull(){
        return counter==kontenjan;
    }
        
    void push(int tc, String ad, String soyad, String mezunBolum){
        KursNode current=new KursNode(tc, ad, soyad, mezunBolum);
        if(isEmpty()){
            top=current;
        }
        else{
            current.next=top;
            top=current;
        }
        System.out.println(top.tc+" TC Kimlik NO'lu kişi kontenjana"
                + " eklendi");
        counter++;
    }
    
    void printPush(){
        if(isFull()){
            System.out.println("Kontenjan dolu.");
        }
        else{
            Scanner input = new Scanner(System.in);
            System.out.print("Eklemek istediğiniz kişinin TC'si:  ");
            int tc = input.nextInt();
            System.out.print("Eklemek istediğiniz kişinin adı:  ");
            String ad=input.next();
            System.out.print("Eklemek istediğiniz kişinin soyadı:  ");
            String soyad=input.next();
            System.out.print("Eklemek istediğiniz kişinin bölümü:  ");
            String mezunBolum=input.next();
            push(tc, ad, soyad, mezunBolum);
        }
    }
    
    int pop(){
        int temp=top.tc;
        top=top.next;
        counter--;
        return temp;
    }
    
    void printPop(){
        if(isEmpty()){
            System.out.println("Kontenjan boş.");
        }
        else{
            System.out.println("Silinen kişinin TC'si: " + pop());
        }
    }
    
    int top(){
        if(isEmpty()){
            System.out.println("Kontenjan boş.");
            return -1;
        }
        else{
            System.out.println("En son kayıt olan kişinin TC'si: "+top.tc);
            System.out.println("En son kayıt olan kişinin adı: "+top.ad);
            System.out.println("En son kayıt olan kişinin soyadı: "+top.soyad);
            System.out.println("En son kayıt olan kişinin bölümü: "
                    +""+top.mezunBolum);
            return 0;
        }
    }
    
    void display(){
        if(isEmpty()){
            System.out.println("Kontenjan boş.");
        }
        else{
            System.out.println("---------------------------------"
                    + "----------------------------------------------------"
                    + "--------------");
            KursNode temp=top;
            int i=0;
            System.out.printf("|%-12s|%-30s|%-31s|%-21s|\n","     TC",
                    "              AD","             SOYAD","        BOLUM");
            System.out.println("---------------------------------"
                    + "----------------------------------------------------"
                    + "--------------");
            while(temp!=null){
                System.out.printf("|%-12s|%-30s|%-31s|%-21s|\n",temp.tc,
                        temp.ad,temp.soyad,temp.mezunBolum);
                temp=temp.next;
                i++;
            }
            System.out.println("---------------------------------"
                    + "----------------------------------------------------"
                    + "--------------");
        }  
    }
    
    void kalanKontenjan(){
        System.out.println("Kalan kontenjan: "+(kontenjan-counter));
    }
    
    void run(){
        Scanner input=new Scanner(System.in);
        boolean continueProgram=true;
        int secim;
        while(continueProgram){
            try{ 
                do{
                    System.out.println("------------------------------------");
                    System.out.println("\tYapmak İstediğiniz İşlem");
                    System.out.println("------------------------------------");
                    System.out.println("1-) Kursa yeni kayıt ekle");
                    System.out.println("2-) En son kaydı sil");
                    System.out.println("3-) En son kayıtlı kişinin bilgileri");
                    System.out.println("4-) Kursa kayıtlı kişiler");
                    System.out.println("5-) Kalan kontenjan");
                    System.out.println("0-) Çıkış");
                    System.out.println("------------------------------------");
                    System.out.print("İşlem numarası: ");
                    secim=input.nextInt();
                    switch(secim){
                        case 1:
                            printPush();
                            break;
                        case 2:
                            printPop();
                            break;
                        case 3:
                            top();
                            break;
                        case 4:
                            display();
                            break;
                        case 5:
                            kalanKontenjan();
                            break;
                        case 0:
                            System.out.println("Programdan çıkılıyor...");
                            continueProgram=false;
                            break;
                        default:
                            System.out.println("Geçersiz numara "
                                + "Lütfen tekrar deneyiniz.");
                            break;
                    }
                }while(secim!=0);
            }
            catch(Exception e){
                System.out.println(e);
                input.nextLine();
            }   
        }
    }
}
