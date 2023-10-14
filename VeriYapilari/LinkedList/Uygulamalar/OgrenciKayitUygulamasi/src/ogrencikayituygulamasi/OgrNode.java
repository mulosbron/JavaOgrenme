package ogrencikayituygulamasi;
public class OgrNode {
    int numara;
    String ad;
    String soyad;
    double vize;
    double fin;
    double ortalama;
    boolean durum;
    
    OgrNode next;

    public OgrNode(int numara, String ad, String soyad, double vize, double fin) {
        this.numara = numara;
        this.ad = ad;
        this.soyad = soyad;
        this.vize = vize;
        this.fin = fin;
        ortalama=(vize*0.4)+(fin*0.6);
        if(ortalama>=50) durum=true;
        else durum=false;
        next=null;
    }
}
