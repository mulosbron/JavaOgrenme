package lifo;
public class Stack {
    int arr[]; //stack
    int size;
    int index;

    public Stack(int size) {
        this.size = size;
        arr=new int[size];
        index=-1;
    }
    
    boolean isFull(){
        return index==size-1;
    }
    
    boolean isEmpty(){
        return index==-1;
    }
    
    void push(int data){
        if(isFull()){
            System.out.println("Stack is full");
        }
        else{
            index++;
            arr[index]=data;
            System.out.println("Push: "+arr[index]);
        }
    }
    
    int pop(){
        if(isEmpty()){
            System.out.print("Stack is empty ");
            return -1;
        }
        else{
            System.out.print("Pop: ");
            return arr[index--]; //dizinin indisini bir eksilt ve geriye döndür
        }
    }
    
    int top(){
        if(isEmpty()){
            System.out.print("stack is empty ");
            return -1;
        }
        else{
            System.out.print("Top: ");
            return arr[index]; //en üstteki nesneyi geriye döndür
        }
    }
    
    int size(){
        System.out.print("Size: ");
        return index+1; 
    }
}
