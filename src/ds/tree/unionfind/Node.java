package ds.tree.unionfind;

public class Node {
	int parent;		// 부모 노드의 레퍼런스 저장  
	int rank;		// 랭크 - 초기에는 0으로 설정 
	
	// 생성자
	public Node(int parent, int rank) {
		super();
		this.parent = parent;
		this.rank = rank;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
