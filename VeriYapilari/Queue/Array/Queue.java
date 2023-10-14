package queue;
public class Queue {
    private final int[] arr;
    private final int size;
    private final int front; // dizinin baştaki elemanı
    private int rear; // dizideki son elemanı

    public Queue(int size) {
        this.size = size;
        arr=new int[size];
        front=0;
        rear=-1;
    }

    public int getFront() {
        System.out.println("Front element in the queue is: "+arr[front]);
        return arr[front];
    }

    public int getRear() {
        System.out.println("Rear element in the queue is: "+arr[rear]);
        return arr[rear];
    }
    
    void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full.");
        }
        else{
            rear++;
            arr[rear]=data;
            System.out.println(arr[rear]+" has been added to the queue.");
        }
    }
    
    void dequeque(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
        }
        else{
            int temp=arr[front];
            for(int i=1;i<=rear;i++){
                arr[i-1]=arr[i];
            }
            rear--;
            System.out.println(temp + " has been removed from the queue.");
        }
    }
    
    private boolean isEmpty(){
        return rear==-1;
    }
    
    private boolean isFull(){
        return size-1==rear;
    }
    
    void getElementCount() {
        System.out.println("Number of elements in the queue: "+(rear+1));
    }
    
    void display(){
        if(!isEmpty()){
            int i=rear;
            System.out.print("rear->");
            while(i>=0){
                System.out.print(arr[i]+"->");
                i--;
            }
            System.out.println("front");
        }
        else{
            System.out.println("Queue is empty.");
        }
    }
}