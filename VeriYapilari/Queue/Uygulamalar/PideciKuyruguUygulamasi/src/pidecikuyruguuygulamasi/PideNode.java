package pidecikuyruguuygulamasi;
public class PideNode {
    String isim;
    int adet;
    int ucret;
    PideNode next;
    PideNode(String isim, int adet){
        this.isim = isim;
        this.adet = adet;
        this.ucret = adet * 4;
        this.next = null;
    }
}
