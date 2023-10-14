package linkedlist;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args){
        IkiYonluDairesel list=new IkiYonluDairesel();
        Scanner scanner=new Scanner(System.in);
        boolean exit=true;
        int num, panel;
        do{
            System.out.println("1 - Başa veya sona ekle");
            System.out.println("2 - Ortaya ekle");
            System.out.println("3 - Baştan veya sondan sil");
            System.out.println("4 - Ortadan sil");
            System.out.println("0 - Çık");
            System.out.print("Seçiminiz: ");
            panel=scanner.nextInt();
            switch(panel){
                case 0: exit=false; break;
                case 1: 
                    System.out.print("Sayı: ");
                    num=scanner.nextInt();
                    System.out.print("Head veya Tail (h/t): ");
                    char head_tail=scanner.next().charAt(0);
                    if(head_tail=='h'){
                        list.add(false, num);
                    }
                    else{
                        list.add(true, num);
                    }
                    list.show();
                    break;
                case 2:
                    System.out.print("Sayı: ");
                    num=scanner.nextInt();
                    System.out.print("İndis: ");
                    int index=scanner.nextInt();
                    list.add(index, num);
                    list.show();
                    break;
                case 3:
                    System.out.print("Head veya Tail (h/t): ");
                    head_tail=scanner.next().charAt(0);
                    if(head_tail=='h'){
                        list.remove(false);
                    }
                    else{
                        list.remove(true);
                    }
                    list.show();
                    break;
                case 4:
                    System.out.print("İndis: ");
                    index=scanner.nextInt();
                    list.remove(index);
                    list.show();
                    break;
            }
        }while(exit);
        
    }
}
