package linkedlist;
public class TekYonluDairesel {
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
            tail.next=head;
        }
        else if(bool){
            tail.next=node;
            tail=node;
            tail.next=head;
        }
        else{
            node.next=head;
            head=node;
            tail.next=head;
        }
    }
    
    void add(int index, int data){
        Node node=new Node(data);
        if(head==null&&index==0){
            head=node;
            tail=node;
            tail.next=head;
        }
        else if(head!=null&&index==0){
            node.next=head;
            head=node;
            tail.next=head;
        }
        else{
            int i=1;
            Node temp=head;
            Node temp2=head;
            while(temp!=tail){
                temp=temp.next;
                i++;
            }
            System.out.println("index "+index);
            System.out.println("i "+i);
            if(index==i){
                tail.next=node;
                tail=node;
                tail.next=head;
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
                node.next=temp;
            }
        }
    }
    
    void remove(boolean bool){
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
        }
        else{
            head=head.next;
            tail.next=head;
        }
    }
    
    void remove(int index){
        if(head==tail&&index==0){
            head=null;
            tail=null;
        }
        else if(head!=tail&&index==0){
            head=head.next;
            tail.next=head;
        }
        else{
            Node temp=head;
            Node temp2=temp;
            int i=0;
            while(i<index){
                temp2=temp;
                temp=temp.next;
                i++;
            }
            if(i==index&&temp==tail){
                tail=temp2;
            }
            temp2.next=temp.next;
        }
    }
}
