package queue;
public class Queue {
    Node front; //head
    Node rear; //tail
    int counter;
    private final int size;
    public Queue(int size){
        this.size=size;
        counter=0;
        front=null;
        rear=null;
    }
    
    private boolean isEmpty(){
        return counter==0;
    }
    
    private boolean isFull(){
        return counter==size;
    }
    
    void enqueue(int data){
        if(!isFull()){
            Node current=new Node(data);
            if(isEmpty()){
                front=current;
                rear=current;
                 
            }
            else{
                rear.next=current;
                rear=rear.next;
            }
            counter++;
            System.out.println(rear.data+" has been added to the queue.");
        }
        else{
            System.out.println("Queue is full.");
        }
    }
    
    void dequeue(){
        if(!isEmpty()){
            System.out.println(front.data+" has been removed to the queue.");
            front=front.next;
            counter--;
        }
        else{
            System.out.println("Queue is empty.");
        }
    }
    
    void display(){
        if(!isEmpty()){
            Node temp=front;
            System.out.print("Front<-");
            do{
                System.out.print(temp.data+"<-");
                temp=temp.next;
            }while(temp!=null);
            System.out.println("Rear");
        }
        else{
            System.out.println("Queue is empty.");
        }
    }
}
