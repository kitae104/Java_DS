package ds.tree.unionfind;

public class UnionFind {

	protected Node[] a;

	public UnionFind(Node[] a) {
		super();
		this.a = a;
	}
	
	//i가 속한 집합의 루트 노드를 재귀적으로 찾고 최종적으로 경로상의 각 원소의 부모를 루트 노드로 만든다.
	protected int find(int i) {
		if(i != a[i].getParent()) {
			a[i].setParent(find(a[i].getParent())); //리턴하며 경로상의 각 노드의 부모가 루트가되도록 만든다.
		}
		return a[i].getParent();
	}
	
	// Union 연산
	public void union(int i, int j) {
		int iRoot = find(i);
		int jRoot = find(j);
		
		if(iRoot == jRoot) {
			return;				// 루트 노드가 동일하면 더이상의 수행없이 그대로 리턴
		}
		
		// rank가 높은 루트 노드가 승자가 된다.
		if(a[iRoot].getRank() > a[jRoot].getRank()) {
			a[jRoot].setParent(iRoot);
		} else if(a[iRoot].getRank() < a[jRoot].getRank()) {
			a[iRoot].setParent(jRoot);
		} else {
			a[jRoot].setParent(iRoot);		// 둘중에 하나 임의로 승자
			int t = a[iRoot].getRank() + 1;
			a[iRoot].setRank(t);			// iRoot의 rank 1증가
		}
	}
}
