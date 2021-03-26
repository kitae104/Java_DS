package ds.hash;

/**
 * 해시 - 이차 조사 
 * @author 김기태
 *
 * @param <K>
 * @param <V>
 */
public class QuadProbing<K, V> {
	private int M = 11;  // 테이블 크기
	private K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] d = (V[]) new Object[M]; // key관련 데이터 저장
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
		int initialpos = hash(key);   	// 초기 위치
        int i = initialpos, j = 1;
        do {
            if (a[i] == null){  		// 삽입 위치 발견
            	a[i]  = key;    		// key를 해시테이블에 저장
            	d[i] = data;    		// key관련 데이터를 동일한 인덱스하에 저장
                  return;
            }
            if (a[i].equals(key)) {  	// 이미 key 존재
                d[i] = data;         	// data데이터만 갱신
            }            
            i = (initialpos + j * j++) % M; // i = 다음 위치 (제곱을 사용)          
        } while (i != initialpos);    
	}
	
	/**
	 * 탐색 연산
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int initialPos = hash(key);
		int i = initialPos, j = 1;
		while(a[i] != null) {			// a[i]가 empty가 아니면
			if(a[i].equals(key)) {
				return d[i];			// 탐색 성공 
			}
			i = (initialPos + j * j++) % M;	// i = 다음 위치 
		}
		return null;					// 탐색 실패 
	}

}
