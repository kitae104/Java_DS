package ds.hash;

import java.util.Random;

/**
 * 이중 해싱 
 * @author 김기태
 *
 * @param <K>
 * @param <V>
 */
public class DoubleHashing<K, V> {
	private int SIZE = 13;  					// 테이블 크기
	private K[] a = (K[]) new Object[SIZE]; 	// 해시테이블
	private V[] d = (V[]) new Object[SIZE]; 	// key관련 데이터 저장
	
	public int getSIZE() {
		return SIZE;
	}
	public void setSIZE(int sIZE) {
		SIZE = sIZE;
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
		return (key.hashCode() & 0x7fffffff) % SIZE;	// 나눗셈 함수
	}
	
	/**
	 * 삽입 연산
	 * @param key
	 * @param data
	 */
	public void put(K key, V data) { 
		int initialpos = hash(key);   	// 초기 위치
        int i = initialpos;
        int j = 1;
        int h2 = (7 - (int)key % 7); 	// 두번쨰 해시 함수, d(key)=7-key%7
        do {
            if (a[i] == null){  		// 삽입 위치 발견
            	a[i] = key;	    		// key를 해시테이블에 저장
            	d[i] = data;    		// key관련 데이터를 동일한 인덱스하에 저장
                  return;
            }
            if (a[i].equals(key)) {  	// 이미 key 존재
                d[i] = data;         	// data데이터만 갱신
            }            
            i = (initialpos + j * h2) % SIZE; // i = 다음 위치 (랜덤을 사용)          
        } while (i != initialpos);    
	}
	
	/**
	 * 탐색 연산
	 * @param key
	 * @return
	 */
	public V get(K key) {		 	
		int initialPos = hash(key);
		int i = initialPos;
		int j = 1;
		int h2 = (7 - (int)key % 7);	// 2차 해시 
		while(a[i] != null) {			// a[i]가 empty가 아니면
			if(a[i].equals(key)) {
				return d[i];			// 탐색 성공 
			}
			i = (initialPos + j * h2) % SIZE;	// i = 다음 위치 
		}
		return null;					// 탐색 실패 
	}
}
