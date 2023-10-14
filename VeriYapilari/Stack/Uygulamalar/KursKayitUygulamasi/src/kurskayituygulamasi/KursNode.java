package kurskayituygulamasi;
public class KursNode {
    int tc;
    String ad;
    String soyad;
    String mezunBolum;
    KursNode next;

    public KursNode(int tc, String ad, String soyad, String mezunBolum) {
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.mezunBolum = mezunBolum;
        next=null;
    }
}
