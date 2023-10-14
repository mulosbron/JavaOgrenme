package linkedlist;
public class IkiYonluDairesel {
    Node head=null;
    Node tail=null;
    
    void show(){
        if(head==null){
            System.out.println("[]");
        }
        else{
            Node temp=head;
            System.out.print("[");
            while(temp!=tail){
                System.out.print(temp.data+", ");
                temp=temp.next;
            }
            System.out.println(temp.data+"]");
        }
    }
    
    void add(boolean bool, int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
            tail=node;
            head.next=tail;
            tail.prev=head;
            head.prev=tail;
            tail.next=head;
        }
        else if(bool){
            tail.next=node;
            node.prev=tail;
            tail=node;
            tail.next=head;
            head.prev=tail;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
            tail.next=head;
            head.prev=tail;
        }
    }
    
    void add(int index, int data) {
        Node node=new Node(data);
        if(head==null&&index==0){
            head=node;
            tail=node;
            head.next=tail;
            tail.prev=head;
            head.prev=tail;
            tail.next=head;
        }
        else if(head!=null&&index==0){
            node.next=head;
            head.prev=node;
            head=node;
            tail.next=head;
            head.prev=tail;
        }
        else{
            int i=1;
            Node temp=head;
            Node temp2=temp;
            while(temp!=tail){
                temp=temp.next;
                i++;
            }
            if(index==i){
                tail.next=node;
                node.prev=tail;
                tail=node;
                tail.next=head;
                head.prev=tail;
            }
            else{
                temp=head;
                int j=0;
                while(j<index){
                    temp2=temp;
                    temp=temp.next;
                    j++;
                }
                temp2.next=node;
                node.prev=temp2;
                node.next=temp;
                temp.prev=node;
            }
        }
    }
    
    void remove(boolean bool){
        if(head!=null){
            if(head==tail){
                head=null;
                tail=null;
            }
            else if(bool){
                Node temp=head;
                while(temp.next!=tail){
                    temp=temp.next;
                }
                tail=temp;
                tail.next=head;
                head.prev=tail;
            }
            else{
                head=head.next;
                head.prev=tail;
                tail.next=head;
            }
        }
    }
    
    void remove(int index){
        if(head!=null){
            if(head==tail&&index==0){
                head=null;
                tail=null;
            }
            else if(head!=tail&&index==0){
                head=head.next;
                head.prev=tail;
                tail.next=head;
            }
            else{
                Node temp=head;
                int i=0;
                while(temp!=tail){
                    temp=temp.next;
                    i++;
                }
                if(index==i){
                    tail=tail.prev;
                    tail.next=head;
                    head.prev=tail;
                }
                else{
                    temp=head;
                    Node temp2=temp;
                    int j=0;
                    while(j<index){
                        temp2=temp;
                        temp=temp.next;
                        j++;
                    }
                    temp2.next=temp.next;
                    temp.next.prev=temp2;
                }
            }  
        }
    }
}
