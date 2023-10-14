package otoparkkayituygulamasi;
public class OtoNode {
    String plaka;
    long dakika;
    long ucret;
    
    OtoNode next;
    OtoNode prev;

    public OtoNode(String plaka, long dakika, long ucret) {
        this.plaka = plaka;
        this.dakika = dakika;
        this.ucret = ucret;
        next=null;
        prev=null;
    }
}
