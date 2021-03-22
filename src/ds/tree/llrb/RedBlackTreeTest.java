package ds.tree.llrb;

public class RedBlackTreeTest {

	public static void main(String[] args) {
		RedBlackTree<Integer, String> redBlackTree = new RedBlackTree<Integer, String>();
		redBlackTree.put(700, "strawberry");
		redBlackTree.put(250, "eggplant");
		redBlackTree.put(100, "apple");
		redBlackTree.put(500, "raspberry");
		redBlackTree.put(150, "cherry");
		redBlackTree.put(300, "honeydew");
		redBlackTree.put(900, "watermelon");
		redBlackTree.put(400, "mango");
		redBlackTree.put(450, "pear");
		redBlackTree.put(350, "lime");

		redBlackTree.print();
		redBlackTree.delete(400);
		redBlackTree.print();
	}

}
