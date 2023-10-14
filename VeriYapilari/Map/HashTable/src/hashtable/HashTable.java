package hashtable;
public class HashTable {
    Node arr[];
    int size;
    
    public HashTable(int size) {
        this.size = size;
        arr=new Node[size];
        for(int i=0;i<size;i++){
            arr[i]=new Node();
        }
    }
    
    int hash(int key){
        return key%size;
    }
    
    void add(int key, Object data){
        // Tabloda hangi indise denk gelecek onu bulduk
        int index=hash(key); 
        // Ekleyeceğimiz düğümü oluşturduk
        Node current=new Node(key, data);
        // Tabloda denk geldiği indisi tempe atadık
        Node temp=arr[index];
        //İlgili bağlı listenin sonuna ekleme yaptık
        while(temp.next!=null) temp=temp.next;
        temp.next=current;
        System.out.println(current.data+" added.");
    }
    
    void remove(int key){
        int index=hash(key);
        Node temp=arr[index];
        Node temp2=arr[index];
        if(temp.next==null){
            System.out.println(key+" numaralı kayıt yok.");
        }
        else if(temp.next.next==null&&temp.next.key==key){
            temp.next=null;
            System.out.println(key+" numaralı kayıt silindi.");
        }
        else{
            while(temp.next!=null){
                if(temp.key==key){
                    temp2.next=temp.next;
                }
                temp2=temp;
                temp=temp.next;
            }
            System.out.println(key+" numaralı kayıt silindi.");
        }
    }
    
    void display(){
        Node temp;
        for(int i=0;i<size;i++){
            temp=arr[i];
            System.out.printf("|%s|-->|",i);
            while(temp.next!=null){
                temp=temp.next;
                System.out.printf(" %-20s|-->|",temp.data);
            }
            System.out.println();
        }
    }
}
