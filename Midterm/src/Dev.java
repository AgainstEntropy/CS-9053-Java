import java.util.ArrayList;

public class Dev {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());

        ArrayList<Object> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        
        System.out.println(list);

        list.sort((o3, o4) -> o3.hashCode() - o4.hashCode());

        System.out.println(list);
    }
}
