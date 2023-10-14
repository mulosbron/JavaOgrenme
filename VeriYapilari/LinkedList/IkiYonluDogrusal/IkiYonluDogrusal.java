package linkedlist;
public class IkiYonluDogrusal {
    Node head=null;
    Node tail=null;
    
    //Başa ve sona düğüm ekleme
    void add(boolean bool, int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
            tail=node;
        }
        else if(bool){
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
        }
    }
    
    //Ortaya düğüm ekleme
    void add(int index, int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
            tail=node;
        }
        else if(head!=null&&index==0){
            node.next=head;
            head.prev=node;
            head=node;
        }
        else{
            Node temp=head;
            int i=0;
            while(temp!=null){
                temp=temp.next;
                i++;
            } 
            temp=head;
            if(index>i){
                tail.next=node;
                node.prev=tail;
                tail=node;
            }
            else{
                i=0;
                while(i!=index){
                    temp=temp.next;
                    i++;
                }
                node.prev=temp.prev;
                temp.prev.next=node;
                node.next=temp;
                temp.prev=node;
            }
        }
    }
    
    //Baştan veya sondan düğüm silme
    void remove(boolean bool){
        if(head!=null){
            if(head.next==null){
                head=null;
                tail=null;
            }
            else if(bool){
                tail=tail.prev;
                tail.next=null;
            }
            else{
                head=head.next;
                head.prev=null;
            }
        }
    }
    
    //Ortadan düğüm silme
    void remove(int index){
        if(head!=null){
            if(head.next==null&&index<=0){
                head=null;
                tail=null;
            }
            else if(head.next!=null&&index<=0){
                head=head.next;
                head.prev=null;
            }
            else{
                int i=0;
                Node temp=head;
                while(temp!=null){
                    temp=temp.next;
                    i++;
                }
                if(index>=(i-1)){
                    tail=tail.prev;
                    tail.next=null;
                }
                else{
                    temp=head;
                    int j=0;
                    while(j<index){
                        temp=temp.next;
                        j++;
                    }
                    temp.next.prev=temp.prev;
                    temp.prev.next=temp.next;
                }
            }
        }
    }
                
    void show(){
        Node temp=head;
        System.out.print("[");
        while(temp!=null){
            if(temp.next==null){
                System.out.print(temp.data);
            }
            else{
                System.out.print(temp.data+", ");
            }
            temp=temp.next;
        }
        System.out.println("]");
    }
}
