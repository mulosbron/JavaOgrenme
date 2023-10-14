package lifo;

import java.util.Scanner;

public class Stack {
    int size;
    int counter;
    Node top;
    
    public Stack(int size) {
        this.size = size;
        counter=0;
        top=null;
    }
    
    int size(){
        System.out.print("Size: ");
        return counter;
    }
    
    void push(int data){
        if(isFull()){
            System.out.println("Stack is full");
        }
        else{
            Node current=new Node(data);
            if(isEmpty()){
                top=current;
            }
            else{
                current.next=top;
                top=current;
            }
            System.out.println("Push: "+top.data);
            counter++;
        }
    }
    
    void printPush(){
        System.out.print("Enter the value you want to add: ");
        Scanner input = new Scanner(System.in);
        int data = input.nextInt();
        push(data);
    }
    
    int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty ");
            return -1;
        }
        else{
            int temp=top.data;
            top=top.next;
            counter--;
            return temp;
        }
    }
    
    void printPop(){
        int poppedValue = pop();
        if (poppedValue != -1) {
            System.out.println("Popped value: " + poppedValue);
        }
    }
    
    int top(){
       if(isEmpty()){
            System.out.print("Stack is empty ");
            return -1;
        }
        else{
            System.out.print("Top: ");
            return top.data;
        } 
    }
    
    boolean isEmpty(){
        return counter==0;
    }
    
    boolean isFull(){
        return counter==size;
    }
    
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        else {
            System.out.println("Stack elements:");
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    
    void run(){
        Scanner input=new Scanner(System.in);
        boolean continueProgram=true;
        int operationNum;
        while(continueProgram){
            try{ 
                do{
                    System.out.println("------------------------------------");
                    System.out.println("\tSelect an Operation");
                    System.out.println("------------------------------------");
                    System.out.println("1-) Add");
                    System.out.println("2-) Remove");
                    System.out.println("3-) Show top element");
                    System.out.println("4-) List all");
                    System.out.println("0-) Exit");
                    System.out.println("------------------------------------");
                    System.out.print("Enter the number of the operation "
                            + "you want to perform: ");
                    operationNum=input.nextInt();
                    switch(operationNum){
                        case 1:
                            printPush();
                            break;
                        case 2:
                            printPop();
                            break;
                        case 3:
                            System.out.println(top());
                            break;
                        case 4:
                            display();
                            break;
                        case 0:
                            System.out.println("Exiting the program...");
                            continueProgram=false;
                            break;
                        default:
                            System.out.println("Invalid operation number. "
                                + "Please try again.");
                            break;
                    }
                }while(operationNum!=0);
            }
            catch(Exception e){
                System.out.println(e);
                input.nextLine();
            }   
        }
    }
}
