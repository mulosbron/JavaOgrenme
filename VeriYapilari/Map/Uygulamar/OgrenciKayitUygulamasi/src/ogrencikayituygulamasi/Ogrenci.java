
package ogrencikayituygulamasi;

public class Ogrenci { // Node
    
    int numara; // key
    String ad;
    int ort;
    String durum;
    Ogrenci next;
    
    public Ogrenci(){
        this.next = null;
        
    }
    
    public Ogrenci(int numara, String ad, int ort) {
        this.numara = numara;
        this.ad = ad;
        this.ort = ort;
        this.durum = ort < 50 ?  "Kaldı" : "Geçti";
        this.next = null;
    }
}
