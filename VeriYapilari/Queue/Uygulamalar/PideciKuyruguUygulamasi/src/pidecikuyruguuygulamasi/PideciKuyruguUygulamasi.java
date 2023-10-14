package pidecikuyruguuygulamasi;

import java.util.Scanner;

public class PideciKuyruguUygulamasi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Kuyruk yapısı sınırı: ");
        int n = input.nextInt();
        PideQueue kuyruk = new PideQueue(n);
        kuyruk.run();
    }
}
