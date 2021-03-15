package ds.tree.unionfind;

public class Node {
	int parent;
	int rank;
	
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
