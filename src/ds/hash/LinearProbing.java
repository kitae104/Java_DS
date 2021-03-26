package ds.hash;

public class LinearProbing<K, V> {
	
	private int M = 11; 					// 테이블 크기 
	private K[] a = (K[]) new Object[M];	// 해시테이블
	private V[] d = (V[]) new Object[M];	// key관련 데이터 저장
	
	/**
	 * 해시 코드 
	 * @param key
	 * @return
	 */
	public int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;	// 나눗셈 함수
	}
	
	/**
	 * 삽입 연산
	 * @param key
	 * @param data
	 */
	public void put(K key, V data) {
		int initialPos = hash(key);    	// 초기 위치
		int i = initialPos, j = 1;
		do {
			if(a[i] == null) {			// 삽입 위치 발견
				a[i] = key;				// key를 해시테이블에 저장
				d[i] = data;			// key관련 데이터를 동일한 인덱스하에 저장
				return;
			}
			if(a[i].equals(key)) {		// 이미 key 존재
				d[i] = data;			// 데이터만 갱신
				return;
			}
			i = (initialPos + j++) % M;	// i = 다음 위치 
		} while(i != initialPos);		// 현재 i가 초기위치와 같게되면 루프 종료  		
	}
	
	/**
	 * 탐색 연산
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int initialPos = hash(key);
		int i = initialPos, j = 1;
		while(a[i] == null) {			// a[i]가 empty가 아니면
			if(a[i].equals(key)) {
				return d[i];			// 탐색 성공 
			}
			i = (initialPos + j++) % M;	// i = 다음 위치 
		}
		return null;					// 탐색 실패 
	}

	public int getM() {
		return M;
	}

	public void setM(int m) {
		M = m;
	}

	public K[] getA() {
		return a;
	}

	public void setA(K[] a) {
		this.a = a;
	}

	public V[] getD() {
		return d;
	}

	public void setD(V[] d) {
		this.d = d;
	}	
}
