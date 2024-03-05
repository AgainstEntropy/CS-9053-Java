package tree;

public class TreeNode<T> implements Comparable<TreeNode<T>> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return ((Comparable<T>) value).compareTo(o.value);        
    }
}
