package tree;

import java.util.Comparator;

import pair.Pair;

public class BinarySearchTree<T extends Comparable<T>> {
	private TreeNode<T> root;
	private Comparator<T> comparator;

	public BinarySearchTree() {
		root = null;
		comparator = null;
	}

	public BinarySearchTree(Comparator<T> comparator) {
		root = null;
		this.comparator = comparator;
	}

	// Insert value into the BST
	public void insert(T val) {
		root = insertRec(root, val);
	}

	private TreeNode<T> insertRec(TreeNode<T> root, T value) {
		if (root == null) {
			root = new TreeNode<T>(value);
			return root;
		}

		if (comparator != null) {
			if (comparator.compare(value, root.value) < 0) {
				root.left = insertRec(root.left, value);
			} else if (comparator.compare(value, root.value) > 0) {
				root.right = insertRec(root.right, value);
			}
		} else {
			if (value.compareTo(root.value) < 0) {
				root.left = insertRec(root.left, value);
			} else if (value.compareTo(root.value) > 0) {
				root.right = insertRec(root.right, value);
			}
		}

		return root;
	}

	// Search for a value in the BST
	public boolean search(T value) {
		return searchRec(root, value);
	}

	private boolean searchRec(TreeNode<T> root, T value) {
		if (root == null) {
			return false;
		}

		if (value.compareTo(root.value) == 0) {
			return true;
		}

		if (value.compareTo(root.value) < 0) {
			return searchRec(root.left, value);
		} else {
			return searchRec(root.right, value);
		}
	}

	// Method to call inorder traversal of the BST
	public void inorder() {
		inorderRec(root);
		System.out.println();
	}

	private void inorderRec(TreeNode<T> root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.value + " ");
			inorderRec(root.right);
		}
	}

	public static void main(String[] args) {

		TreeNode tn = new TreeNode(5);
		if (tn instanceof Comparable<?>) {
			Comparable<?> c = (Comparable<?>) tn;
		}
		/* this is how it works now: */
		BinarySearchTree bst0 = new BinarySearchTree();
		for (int i = 0; i < 10; i++) {
			int val = (int) (Math.random() * 100);
			System.out.println("inserting " + val);
			bst0.insert(val);
		}
		bst0.inorder();

		/* this is how it should be able to work : */
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < 10; i++) {
			int val = (int) (Math.random() * 100);
			System.out.println("inserting " + val);
			bst.insert(val);
		}
		bst.inorder();

		/*
		 * this will fail during the insert or constructor call
		 * because Objects are not Comparable,
		 * unless I pass in a Comparator into the constructor
		 */
		BinarySearchTree<MyObject> bst2 = new BinarySearchTree<>(
			(o1, o2) -> {
				return o1.hashCode() - o2.hashCode();
			}
		);
		for (int i = 0; i < 10; i++) {
			MyObject val = new MyObject();
			bst2.insert(val);
		}
		bst2.inorder();

		/*
		 * Assume I have a BST named bst3 that takes Pair objects
		 * where the Pair objects have Key,Value pairs of
		 * Integer and String, and the ordering I have chosen
		 * for the binary search tree is to be order by the keys
		 * in ascending order (that is to say, Integers).
		 * In this case, after creating the BST
		 * (code not included here), we this should work:
		 * 
		 * Pair<Integer, String> p1 = new Pair(5, "John");
		 * bst3.insert(p1);
		 * Pair<Integer, String> p2 = new Pair(3, "Bob");
		 * bst3.insert(p2);
		 * Pair<Integer, String> p3 = new Pair(9, "Alice");
		 * bst3.insert(p3);
		 * Pair<Integer, String> p4 = new Pair(13, "Mallory");
		 * bst3.insert(p4);
		 * Pair<Integer, String> p5 = new Pair(7, "Larry");
		 * bst3.insert(p5);
		 * 
		 * And the output of:
		 * bst3.inorder();
		 * 
		 * will be:
		 * 
		 * Pair[key=3, value=Bob] Pair[key=5, value=John] \
		 * Pair[key=7, value=Larry] Pair[key=9, value=Alice] \
		 * Pair[key=13, value=Mallory]
		 * 
		 */

		BinarySearchTree<Pair<Integer, String>> bst3 = new BinarySearchTree<>(
				(p1, p2) -> {
					return -p1.getKey() + p2.getKey();
				});

		Pair<Integer, String> p1 = new Pair<>(5, "John");
		bst3.insert(p1);
		Pair<Integer, String> p2 = new Pair<>(3, "Bob");
		bst3.insert(p2);
		Pair<Integer, String> p3 = new Pair<>(9, "Alice");
		bst3.insert(p3);
		Pair<Integer, String> p4 = new Pair<>(13, "Mallory");
		bst3.insert(p4);
		Pair<Integer, String> p5 = new Pair<>(7, "Larry");
		bst3.insert(p5);

		bst3.inorder();
	}
}