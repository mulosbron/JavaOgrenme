package musterikayituygulamasi;
public class MusNode {
    int id;
    String ad;
    String soyad;
    String tel;
    String adres;
    String urun;
    
    MusNode next;
    MusNode prev;

    public MusNode(int id, String ad, String soyad, String tel, 
            String adres, String urun) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.tel = tel;
        this.adres = adres;
        this.urun = urun;
        next=null;
        prev=null;
    }
}
