package hashtable;
public class Runner {
    public static void main(String[] args) {
        // 0, 10, 3, 4, 2, 22, 15, 9
        HashTable table=new HashTable(5);
        table.add(0, "Duejof Sekrahk");
        table.add(10, "Zezan Shahun");
        table.add(3, "Norkal Battlestar");
        table.add(4, "Min Him");
        table.add(2, "Frornabre Hindoso");
        table.add(22, "Er Hearthorn");
        table.add(15, "Henkil Truthsorrow");
        table.add(9, "Dindac Novonge");
        System.out.println();
        table.display();
        System.out.println();
        table.remove(0);
        table.remove(10);
        table.remove(3);
        table.remove(4);
        table.remove(2);
        table.remove(22);
        table.remove(15);
        table.remove(9);
        System.out.println();
        table.display();
    }
}
