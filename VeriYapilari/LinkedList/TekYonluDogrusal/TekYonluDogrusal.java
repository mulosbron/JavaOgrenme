package tekyonludogrusal;
//Tek Yönlü Doğrusal Bağlı Liste Yapısı
public class TekYonluDogrusal {
    Node head=null;
    Node tail=null;
    
    //Listedeki Düğümlerin Taşıdığı Verileri Gösterme
    public void show(){
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
    
    //Sona Düğüm Ekleme
    public void add(Object d){
        Node node=new Node();
        node.data=d;
        node.next=null;
        if(head==null){
            head=node;
            tail=node;
            System.out.println("Listeye ilk düğüm eklendi");
        }
        else{
            tail.next=node;
            tail=node;
            System.out.println("Listeye sonuna yeni bir eleman eklendi");
        }
    }
    
    //Başa ve Sona Düğüm Ekleme
    public void add(boolean b, Object d){
        Node node=new Node();
        node.data=d;
        if(head==null){
            head=node;
            tail=node;
            System.out.println("Listeye ilk düğüm eklendi");
        }
        else if(b==false){
            node.next=head;
            head=node;
            System.out.println("Listenin başına yeni bir head eklendi");
        }
        else{
            tail.next=node;
            tail=node;
            System.out.println("Listenin sonuna yeni bir tail eklendi");
        }
    }
    
    //Ortaya Düğüm Ekleme
    public void add(int index, Object d){
        Node node=new Node();
        node.data=d;
        node.next=null;
        if(head==null&&index==0){
            head=node;
            tail=node;
        }
        else if(head!=null&&index==0){
            node.next=head;
            head=node;
        }
        else{
            int counter=0;
            Node temp=head;
            Node temp2=head;
            while(temp.next!=null){
                counter++;
                temp2=temp;
                temp=temp.next;
            }
            if(counter==index){
                temp2.next=node;
                node.next=temp;
                System.out.println("Listeye düğüm eklendi");
            }
            else{
                temp=head;
                temp2=head;
                int counter2=0;
                while(counter2<index){
                    temp2=temp;
                    temp=temp.next;
                    counter2++;
                }
                temp2.next=node;
                node.next=temp;
                System.out.println("Listenin "+index+". indisine eleman eklendi");
            }
        }
    }
    
    //Baştan ve Sondan Düğüm Silme
    public void remove(boolean b){
        if(head.next==null){
            head=null;
            tail=null;
            System.out.println("Listedeki tek eleman silindi");
        }
        else if(b){
            head=head.next;
            System.out.println("Listedeki ilk eleman silindi");
        }
        else{
            Node temp=head;
            Node temp2=head;
            while(temp.next!=null){
                temp2=temp;
                temp=temp.next;
            }
            temp2.next=null;
            tail=temp2;
            System.out.println("Listedeki son eleman silindi");
        }
        
    }
    
    //Verilen İndisteki Elemanı Silme
    public void remove(int index){
        if(head==null&&index==0){
            head=null;
            tail=null;
        }
        else if(head!=null&&index==0){
            head=head.next;
            System.out.println("Listedeki ilk eleman silindi");
        }
        else{
            Node temp=head;
            Node temp2=head;
            int counter=0;
            while(counter<index){
                temp2=temp; //indisten bir önceki düğüm
                temp=temp.next; //indisteki eleman
                counter++;
            }
            temp2.next=temp.next;
            System.out.println("Listenin "+index+". indisindeki eleman silindi");
        }
    }
    
    //Listedeki Tüm Elemanları Temizleme
    public void clear(){
        head=null;
    }
    
    //Verilen Verinin İlk Kez Geçtiği Düğümün İndisini Gösterme
    public void indexOf(Object d){
        int index = 0;
        Node current = head;
        int foundIndex = -1;
        while (current != null) {
            if (current.data.equals(d)) {
                foundIndex = index;
                break;
            }
            index++;
            current = current.next;
        }
        System.out.println(d+" verisinin ilk kez geçtiği düğümün indisi: "+foundIndex);
    }
    //Verilen Verinin Son Kez Geçtiği Düğümün İndisini Gösterme
    public void lastIndexOf(Object d) {
        int lastIndex = -1;
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(d)) {
                lastIndex = index;
            }
            index++;
            current = current.next;
        }
        System.out.println(d+" verisinin son kez geçtiği düğümün indisi: "+lastIndex);
    }
}
