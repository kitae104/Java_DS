package ds.tree.binary;

public class BinaryTreeTest {

	public static void main(String[] args) {
		
		Node<Integer> n1 = new Node<Integer>(100, null, null);
		Node<Integer> n2 = new Node<Integer>(200, null, null);
		Node<Integer> n3 = new Node<Integer>(300, null, null);
		Node<Integer> n4 = new Node<Integer>(400, null, null);
		Node<Integer> n5 = new Node<Integer>(500, null, null);
		Node<Integer> n6 = new Node<Integer>(600, null, null);
		Node<Integer> n7 = new Node<Integer>(700, null, null);
		Node<Integer> n8 = new Node<Integer>(800, null, null);

		n1.setLeft(n2);
		n1.setRight(n3); // n1의 왼쪽 자식-> n2, n1의 오른쪽 자식-> n3
		n2.setLeft(n4);
		n2.setRight(n5); // n2의 왼쪽 자식-> n4, n2의 오른쪽 자식-> n5
		n3.setLeft(n6);
		n3.setRight(n7); // n3의 왼쪽 자식-> n6, n3의 오른쪽 자식-> n7
		n4.setLeft(n8); // n4의 왼쪽 자식-> n8

		BinaryTree<Integer> t = new BinaryTree<Integer>(); // 이진 트리 객체 t 생성
		t.setRoot(n1); // t의 루트 노드를 n1으로

		System.out.print("트리 노드 수  = " + t.size(t.getRoot()) + "\n트리 높이      = " + t.height(t.getRoot()));
		System.out.printf("\n전위 순회:  ");
		t.preOrder(t.getRoot());
		System.out.printf("\n중위 순회:  ");
		t.inOrder(t.getRoot());
		System.out.printf("\n후위 순회:  ");
		t.postOrder(t.getRoot());
		System.out.printf("\n레벨 순회:  ");
		t.levelOrder(t.getRoot());
		System.out.println();

		// 두번째 이진 트리를 만들어 isEqual() 테스트하기 위해
		Node<Integer> n10 = new Node<Integer>(100, null, null);
		Node<Integer> n20 = new Node<Integer>(200, null, null);
		Node<Integer> n30 = new Node<Integer>(300, null, null);
		Node<Integer> n40 = new Node<Integer>(400, null, null);
		Node<Integer> n50 = new Node<Integer>(500, null, null);
		Node<Integer> n60 = new Node<Integer>(600, null, null);
		Node<Integer> n70 = new Node<Integer>(700, null, null);
		Node<Integer> n80 = new Node<Integer>(800, null, null);

		n10.setLeft(n20);
		n10.setRight(n30);
		n20.setLeft(n40);
		n20.setRight(n50);
		n30.setLeft(n60);
		n30.setRight(n70);
		n40.setLeft(n80);

		BinaryTree<Integer> t2 = new BinaryTree<Integer>();
		t2.setRoot(n10);

		System.out.printf("동일성 검사:   " + BinaryTree.isEqual(t.getRoot(), t2.getRoot()));
		System.out.println();

		BinaryTree<Integer> t3 = new BinaryTree<Integer>();
		t3.setRoot(t3.copy(t.getRoot()));
		System.out.printf("copy 테스트: " + BinaryTree.isEqual(t.getRoot(), t3.getRoot()));
		System.out.println();

	}

}
