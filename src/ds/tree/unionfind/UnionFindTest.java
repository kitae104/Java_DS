package ds.tree.unionfind;

public class UnionFindTest {

	public static void main(String[] args) {
		int NUM = 10;
		Node[] nodeArr = new Node[NUM];

		for (int i = 0; i < NUM; i++) { // 10개 Node 객체 생성
			nodeArr[i] = new Node(i, 0);
		}

		UnionFind uf = new UnionFind(nodeArr); // UnionFind 객체 생성

		uf.union(2, 1);
		uf.union(2, 6);
		uf.union(7, 3);
		uf.union(4, 5);
		uf.union(9, 5);
		uf.union(7, 2);
		uf.union(7, 8);
		uf.union(0, 4);
		
		System.out.print("8회의 union 연산 수행 후\n(i:parent,rank):");
		for(int i = 0; i < NUM; i++) {
			System.out.print("("+i+":"+uf.getArr()[i].getParent()+","+uf.getArr()[i].getRank()+") ");
		}
		
		uf.union(9, 1);
		System.out.print("\n\nunion(9,1) 수행 후\n(i:parent,rank):");
		for(int i = 0; i < NUM; i++) {
			System.out.print("("+i+":"+uf.getArr()[i].getParent()+","+uf.getArr()[i].getRank()+") ");
		}
		System.out.println();		
	}

}
