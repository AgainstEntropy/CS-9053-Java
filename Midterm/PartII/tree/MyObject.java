package tree;

public class MyObject implements Comparable<MyObject> {

    @Override
    public int compareTo(MyObject o) {
        return hashCode() - o.hashCode();
    }

    public String toString() {
        return String.format("MyObject [hashCode=%d]", hashCode());
    }
    
}
