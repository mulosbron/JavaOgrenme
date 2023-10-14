package lifo;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        boolean continueProgram=true;
        int stackSize=-1;
        do {
            try {
                System.out.print("Enter the size of the Stack: ");
                stackSize = input.nextInt();
                if(stackSize>0){
                    Stack stack = new Stack(stackSize);
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
