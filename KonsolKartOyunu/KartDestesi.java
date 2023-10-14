package kartdestesi;
import java.util.Arrays;
import java.util.Scanner;
public class KartDestesi {
    
        final String[] gruplar={"KIRMIZI","MAVI","YESIL","SARI","TURUNCU"};
        final String[] sayilar={"0","1","2","3","4","6","7","8","9"};
        
        int sayilar_gruplar=sayilar.length*gruplar.length;
        int indexSayilar=sayilar.length;
        int indexEldekiKart=sayilar_gruplar/2;
        int[] deste=new int[sayilar_gruplar];
        
        int indexParcalama,indexBilgisayar,indexOrtaKart=1;
        boolean oyunKontrol=true;
        
        String[] kartlar=new String[sayilar_gruplar];
        
        String[] bilgBir=new String[indexEldekiKart];
        String[] bilgBirS=new String[indexEldekiKart];
        String[] bilgBirD=new String[indexEldekiKart];
        
        String[] bilgIki=new String[indexEldekiKart];
        String[] bilgIkiS=new String[indexEldekiKart];
        String[] bilgIkiD=new String[indexEldekiKart];
        
        String[] bilgUc=new String[indexEldekiKart];
        String[] bilgUcS=new String[indexEldekiKart];
        String[] bilgUcD=new String[indexEldekiKart];
        
        String[] oyuncu=new String[indexEldekiKart];
        String[] oyuncuS=new String[indexEldekiKart];
        String[] oyuncuD=new String[indexEldekiKart];
        
        String[] ortaKart=new String[sayilar_gruplar];
        String[] ortaKartD=new String[1];
        String[] ortaKartS=new String[1];
            
    void fixNull(){
        for(int i=0;i<indexEldekiKart;i++){
            bilgBir[i]="-";
            bilgIki[i]="-";
            bilgUc[i]="-";
            oyuncu[i]="-";}
        for(int i=0;i<sayilar_gruplar;i++){
            ortaKart[i]="-";
        }         
    }
    
    void elemanSilme(){
        String[] digerDizi = new String[kartlar.length];
        for(int i=0;i<kartlar.length;i++){
            if(i!=kartlar.length-1){
                digerDizi[i]=kartlar[i+1];
                kartlar[i]=digerDizi[i];
            }
            else{
                kartlar[i]="-";
            }
        }
    }
    
    void desteAyarla(){
        for(int i=0;i<deste.length;i++){
            deste[i]=i;
        }
        for(int i=0;i<deste.length;i++){
            int random = (int)(Math.random()*deste.length);
            int temp = deste[i];
            deste[i]=deste[random];
            deste[random]=temp;
        }
        for(int i=0;i<kartlar.length;i++){
            kartlar[i]=gruplar[deste[i]/indexSayilar]+sayilar[deste[i]%indexSayilar];
        }
    }
    
    void kartDagit(String[] kisi,int i){
        kisi[i]=kartlar[0];
        elemanSilme();
    }
    
    void kartAyarla(){
        for(int i=0;i<indexEldekiKart/3;i++){
            kartDagit(oyuncu,i);
            kartDagit(bilgBir,i);
            kartDagit(bilgIki,i);
            kartDagit(bilgUc,i);
        }
    }
    
    void kartKes(){
        indexParcalama=0;
        while(indexParcalama<indexEldekiKart){
            kesmeIslemi(bilgBir,bilgBirS,bilgBirD,indexParcalama);
            kesmeIslemi(bilgIki,bilgIkiS,bilgIkiD,indexParcalama);    
            kesmeIslemi(bilgUc,bilgUcS,bilgUcD,indexParcalama);
            kesmeIslemi(oyuncu,oyuncuS,oyuncuD,indexParcalama);
            indexParcalama++;
        }
    }
    
    void kesmeIslemi(String[] dizi,String[] diziS,String[] diziD,int sayi){
        if(Arrays.equals(dizi, ortaKart)){
            diziS[0]=dizi[sayi].replaceAll("[a-zA-Z]","");
            diziD[0]=dizi[sayi].replaceAll("[0-9]","");
        }
        else{
            diziS[sayi]=dizi[sayi].replaceAll("[a-zA-Z]","");
            diziD[sayi]=dizi[sayi].replaceAll("[0-9]","");
        }
    }
    
    void bilgisayarEslesme(){
        indexBilgisayar=0;
        while(indexBilgisayar<bilgBir.length&&oyunKontrol){
            if(ortaKartD[0].equals(bilgBirD[indexBilgisayar])
             ||ortaKartS[0].equals(bilgBirS[indexBilgisayar])){
                ortaKart[indexOrtaKart]=bilgBir[indexBilgisayar];
                kesmeIslemi(ortaKart,ortaKartS,ortaKartD,indexOrtaKart);
                bilgBir[indexBilgisayar]="-";
                indexOrtaKart++;
                break;
            }
            else if(indexBilgisayar==(bilgBir.length-1)){
                for(int kartI=0;kartI<bilgBir.length;kartI++){
                    if(bilgBir[kartI].equals("-")){
                    kartDagit(bilgBir,kartI);
                    break;
                    }
                }indexBilgisayar=bilgBir.length;
            }
            else{
            indexBilgisayar++;
            }
        } 
        indexBilgisayar=0;
        while(indexBilgisayar<bilgIki.length&&oyunKontrol){
            if(ortaKartD[0].equals(bilgIkiD[indexBilgisayar])
             ||ortaKartS[0].equals(bilgIkiS[indexBilgisayar])){
                ortaKart[indexOrtaKart]=bilgIki[indexBilgisayar];
                kesmeIslemi(ortaKart,ortaKartS,ortaKartD,indexOrtaKart);
                bilgIki[indexBilgisayar]="-";
                indexOrtaKart++;
                break;
            }
            else if(indexBilgisayar==(bilgIki.length-1)){
                for(int kartI=0;kartI<bilgIki.length;kartI++){
                    if(bilgIki[kartI].equals("-")){
                    kartDagit(bilgIki,kartI);
                    break;
                    }
                }indexBilgisayar=bilgIki.length;
            }
            else{
            indexBilgisayar++;
            }
        }    
        indexBilgisayar=0;
        while(indexBilgisayar<bilgUc.length&&oyunKontrol){
            if(ortaKartD[0].equals(bilgUcD[indexBilgisayar])
             ||ortaKartS[0].equals(bilgUcS[indexBilgisayar])){
                ortaKart[indexOrtaKart]=bilgUc[indexBilgisayar];
                kesmeIslemi(ortaKart,ortaKartS,ortaKartD,indexOrtaKart);
                bilgUc[indexBilgisayar]="-";
                indexOrtaKart++;
                break;
            }
            else if(indexBilgisayar==(bilgUc.length-1)){
                for(int kartI=0;kartI<bilgUc.length;kartI++){
                    if(bilgUc[kartI].equals("-")){
                        kartDagit(bilgUc,kartI);
                        break;
                    }
                }indexBilgisayar=bilgUc.length;
            }
            else{
            indexBilgisayar++;
            }
        }
    }
    
    void bilgisayarKontrol(){
        int sayac;
        if(oyunKontrol){
            sayac=1;
            for (String bilgisayar0 : bilgBir) {
                if (bilgisayar0.equals("-")) {
                    sayac++;
                    if(sayac==(bilgBir.length+1)){
                        System.out.println("Oyunu bilgisayar1 kazandı!");
                        oyunKontrol=false;
                    }
                }
            }      
        }
        if(oyunKontrol){
            sayac=1;
            for (String bilgisayar1 : bilgIki) {
                if (bilgisayar1.equals("-")) {
                    sayac++;
                    if(sayac==(bilgIki.length+1)){
                        System.out.println("Oyunu bilgisayar2 kazandı!");
                        oyunKontrol=false;
                    }
                }
            }
        }
        if(oyunKontrol){
            sayac=1;
            for (String bilgisayar2 : bilgUc) {
                if (bilgisayar2.equals("-")) {
                    sayac++;
                    if(sayac==(bilgUc.length+1)){
                        System.out.println("Oyunu bilgisayar3 kazandı!");
                        oyunKontrol=false;
                    }      
                
                }
            }
        }
    }
    
    int kartSay(String[] arr){
        int i=0;
        int x=indexEldekiKart-1;
        while(x>=0){
            if(!arr[x].matches("-")){
                i++;
            }
            x--;
        }
    return i;}
    
    void oyuncuEslesme(){
        Scanner scanner=new Scanner(System.in);
        
        System.out.printf("\n\nbilgisayar1'in kart sayısı: %s\n"
                + "bilgisayar2'in kart sayısı: %s\n"
                + "bilgisayar3'in kart sayısı: %s\n"
                + "------------------------------\n"
                ,kartSay(bilgBir),kartSay(bilgIki),kartSay(bilgUc));
        
        System.out.println("\n\nortadaki kartlar");
        System.out.println("------------------------");
        System.out.println(Arrays.toString(ortaKart));
        System.out.println("------------------------");
        System.out.print("En üstteki kart:***"+ortaKart[indexOrtaKart-1]+"***\n");
        System.out.println("------------------------");
        
        System.out.println("\n\noyuncu el");
        System.out.println("------------------------");
        System.out.println(Arrays.toString(oyuncu));
        System.out.println("------------------------");
        
        boolean oyuncuKontrol=true;
        while(oyuncuKontrol){
            int temp=0;
            int temp2=0;
            for(int kartI=0;kartI<oyuncu.length;kartI++){
                if(!ortaKartD[0].equals(oyuncuD[kartI])
                    &&!ortaKartS[0].equals(oyuncuS[kartI])&&!oyuncu[kartI].equals("-")){
                     temp++;
                }
                if(!oyuncu[kartI].equals("-")){
                temp2++;
                }
            }
            if(temp2==temp){
                System.out.println("-----------------------------------------");
                System.out.println("***********Oyuncu Kart Çekiyor***********");
                System.out.println("-----------------------------------------");
                kartDagit(oyuncu,temp);
                oyuncuKontrol=false;
            }
            
            if(oyuncuKontrol){
                System.out.print("Atmak istediğin kartın sırası: ");
                int secilenKart =scanner.nextInt();
                secilenKart--;
                if(ortaKartD[0].equals(oyuncuD[secilenKart])
                    ||ortaKartS[0].equals(oyuncuS[secilenKart])){
                    ortaKart[indexOrtaKart]=oyuncu[secilenKart];
                    kesmeIslemi(ortaKart,ortaKartS,ortaKartD,indexOrtaKart);
                    oyuncu[secilenKart]="-";
                    indexOrtaKart++;
                    break;
                }
                else{
                    System.out.println("Başka bir kart seç");
                }
                System.out.println("\n\n");
            }
        }
    }
    
    void oyuncuKontrol(){
        int sayac;
        if(oyunKontrol){
            sayac=1;
            for (String oync : oyuncu) {
                if (oync.equals("-")) {
                    sayac++;
                    if(sayac==(oyuncu.length+1)){
                        System.out.println("Oyunu oyuncu kazandı!");
                        oyunKontrol=false;
                    }
                }
            }      
        }
    }
    
    void oyunuBaslat(){
        fixNull();
        //desteyi olustur
        desteAyarla();
        //ortaKartıolustur
        kartDagit(ortaKart,0);
        //ortadaki kartı parçalama
        kesmeIslemi(ortaKart,ortaKartS,ortaKartD,0);
        //oyuncuya ve bilgisayara kart dagit
        kartAyarla();
        while(oyunKontrol){
            //bilgisayar ve oyuncu kart parçalama
            kartKes();
            //bilgisayarın eli ve ortadaki kart karşılaştırma
            bilgisayarEslesme();
            //bilgisayarın elindeki kartlar biterse
            bilgisayarKontrol();
            //oyuncu
            if(oyunKontrol){
                oyuncuEslesme();
                oyuncuKontrol(); 
            }
        }
    }
}