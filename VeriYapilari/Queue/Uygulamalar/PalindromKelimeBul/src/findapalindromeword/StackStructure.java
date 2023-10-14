package findapalindromeword;

public class StackStructure {
    
    Node top;
    int size;
    int counter;

    public StackStructure(int size) {
        this.size = size;
        this.top = null;
        this.counter = 0;
    }
    
    void push(char letter){
        if(isFull()){
            System.out.println("Stack is full."); 
        }
        else{
            Node current = new Node(letter);
            if(isEmpty()){
                top = current;
            }
            else{
                current.next = top;
                top = current;
            }
            counter++;
        }
    }
    
    char pop(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return 0;
        }
        else{
            char temp = top.letter;
            top = top.next;
            counter--;
            return temp;
        }
    }
    
    char top(){
        return top.letter;
    }
    
    boolean isEmpty(){
        return counter == 0;
    }
    
    boolean isFull(){
        return counter == size;
    }
}
