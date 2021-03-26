package ds.hash;

public class LinearProbingTest {
	
	public static void main(String[] args) {
		LinearProbing t = new LinearProbing();

		t.put(71, "grape");
		t.put(23, "apple");
		t.put(73, "bananna");
		t.put(49, "cherry");
		t.put(54, "mango");
		t.put(89, "lime");
		t.put(39, "orange");

		System.out.println("해시 테이블:");
		for (int i = 0; i < t.getM(); ++i) {
			System.out.printf("\t%2d", i);
		}
		System.out.println();
		for (int i = 0; i < t.getM(); ++i) {
			System.out.print("\t" + t.getA()[i]);
		}
		System.out.println();
	}

}
