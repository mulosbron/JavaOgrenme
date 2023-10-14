package findapalindromeword;

public class QueueStructure {
    Node front;
    Node rear;
    int size;
    int counter;

    public QueueStructure(int size) {
        this.size = size;
        this.front = null;
        this.rear = null;
        this.counter = 0;
    }
    
    void enQueue(char letter){
        if(isFull()){
            System.out.println("Kuyruk sırası dolu.");
        }
        else{
            Node current= new Node(letter);
            if(isEmpty()){
                front = rear = current;
            }
            else{
                rear.next = current;
                rear = current;
            }
            counter++;
        }
    }
    
    char deQueue(){
        if(isEmpty()){
            System.out.println("Kuyruk boş.");
            return 0;
        }
        else{
            char temp = front.letter;
            front = front.next;
            counter--;
            return temp;
        }
    }
    
    boolean isEmpty(){
        return counter == 0;
    }
    
    boolean isFull(){
        return counter == size;
    }
}
