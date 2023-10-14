package kurskayituygulamasi;
import java.util.Scanner;
public class KursKayitUygulamasi {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        boolean continueProgram=true;
        int stackSize=-1;
        do {
            try {
                System.out.print("Kontenjan boyutu: ");
                stackSize = input.nextInt();
                if(stackSize>0){
                    KursStack stack = new KursStack(stackSize);
                    stack.run();
                }
                continueProgram=false;
            } catch (Exception e) {
                System.out.println("An error occurred: " + e);
                input.nextLine();
            }
        } while (continueProgram&&stackSize<0);
    }
}
