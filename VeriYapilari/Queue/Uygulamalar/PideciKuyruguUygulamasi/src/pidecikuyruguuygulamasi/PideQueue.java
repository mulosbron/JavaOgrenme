package pidecikuyruguuygulamasi;

import java.util.Scanner;

public class PideQueue {
    String isim;
    int adet;
    int toplamGelir = 0;
    PideNode front; 
    PideNode rear;
    int size;
    int counter;

    public PideQueue(int size) {
        this.size = size;
        this.counter = 0;
        this.front = null;
        this.rear = null;
    }
    
    void enQueue(){
        if(isFull()){
            System.out.println("Kuyruk sırası dolu.");
        }
        else{
            Scanner input=new Scanner(System.in);
            System.out.print("Kuyruğa eklenecek kişinin ismi: ");
            this.isim = input.nextLine();
            System.out.print("Kuyruğa eklenecek kişinin aldığı pide sayısı: ");
            this.adet = input.nextInt();
            PideNode current= new PideNode(isim, adet);
            if(isEmpty()){
                front = rear = current;
                System.out.println("Kuyruk yapısı oluşturuldu. İlk müşteri sıraya girdi.");
            }
            else{
                rear.next = current;
                rear = current;
                System.out.println(rear.isim + " müşteri sıraya girdi.");
            }
            counter++;
        }
    }
    
    void deQueue(){
        if(isEmpty()){
            System.out.println("Kuyruk boş.");
        }
        else{
            this.toplamGelir += front.ucret;
            System.out.println(front.isim + " " + front.adet + " adet pide aldı.");
            System.out.println("Toplam borcu: " + front.ucret + " TL");
            front = front.next;
            counter--;
        }
    }
    
    boolean isEmpty(){
        return counter==0;
    }
    
    
    boolean isFull(){
        return counter==size;
    }
    
    void toplamGelir(){
        System.out.println("Toplam Gelir: " + this.toplamGelir);
    }
    
    void print(){
        PideNode temp = front;
        while(temp!=null){
            System.out.println(temp.isim);
            temp = temp.next;
        }
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
                    System.out.println("1-) Yeni müşteri al");
                    System.out.println("2-) Satış yap");
                    System.out.println("3-) Kuyruktaki kişileri görüntüle");
                    System.out.println("4-) Toplam geliri görüntüle");
                    System.out.println("0-) Çıkış");
                    System.out.println("------------------------------------");
                    System.out.print("İşlem numarası: ");
                    secim=input.nextInt();
                    switch(secim){
                        case 1:
                            enQueue();
                            break;
                        case 2:
                            deQueue();
                            break;
                        case 3:
                            print();
                            break;
                        case 4:
                            toplamGelir();
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
