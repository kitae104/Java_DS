package ds.tree.avl;

public class AVLTreeTest {

	public static void main(String[] args) {
		AVLTree<Integer, String> avl = new AVLTree<Integer, String>();
		avl.put(75, "Apple");
		avl.put(80, "Grape");
		avl.put(85, "Lime");
		avl.put(20, "Mango");
		avl.put(10, "Strawberry");
		avl.put(50, "Banana");
		avl.put(30, "Cherry");
		avl.put(40, "Watermelon");
		avl.put(70, "Melon");
		avl.put(90, "fruit");
		avl.print(avl.getRoot());

		System.out.printf("75와 85 삭제 후:\n");	
	 	avl.delete(75);
	 	avl.delete(85);
	 	avl.print(avl.getRoot());
	}

}
