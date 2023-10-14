package tekyonludogrusal;
public class Runner {
    public static void main(String args[]){
        TekYonluDogrusal list=new TekYonluDogrusal();
        list.add(33);
        list.add(false,11);
        list.add(true,55);
        list.add(1,22);
        list.add(3,44);
        list.add(0,-1);
        list.remove(false);
        list.remove(true);
        list.remove(2);
        list.add(1,44);
        list.indexOf(44);
        list.lastIndexOf(44);
        list.show();
    }
}
