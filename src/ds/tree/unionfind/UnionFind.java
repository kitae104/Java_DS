package ds.tree.unionfind;

public class UnionFind {

	private Node[] arr;

	/**
	 * 생성자 
	 * @param a
	 */
	public UnionFind(Node[] arr) {
		super();
		this.arr = arr;
	}
	
	// i가 속한 집합의 루트 노드를 재귀적으로 찾고 최종적으로 경로상의 각 원소의 부모를 루트 노드로 만든다.
	// 경로 압축 수행 
	protected int find(int i) {
		if(i != arr[i].getParent()) {
			
			// 리턴하며 경로상의 각 노드의 부모가 루트가되도록 만든다.
			// 동일한 루트로드로 갱신됨
			arr[i].setParent(find(arr[i].getParent())); 
		}
		
		return arr[i].getParent();
	}
	
	// Union 연산
	public void union(int i, int j) {
		int iRoot = find(i);
		int jRoot = find(j);
		
		if(iRoot == jRoot) {
			return;				// 루트 노드가 동일하면 더이상의 수행없이 그대로 리턴
		}
		
		// rank가 높은 루트 노드가 승자가 된다.
		if(arr[iRoot].getRank() > arr[jRoot].getRank()) {
			arr[jRoot].setParent(iRoot);
		} else if(arr[iRoot].getRank() < arr[jRoot].getRank()) {
			arr[iRoot].setParent(jRoot);
		} else {
			arr[jRoot].setParent(iRoot);		// 둘중에 하나 임의로 승자
			int t = arr[iRoot].getRank() + 1;
			arr[iRoot].setRank(t);				// iRoot의 rank 1증가
		}
	}

	public Node[] getArr()
	{
		return arr;
	}

	public void setArr(Node[] arr)
	{
		this.arr = arr;
	}
	
}
