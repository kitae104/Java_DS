package basic;

public class SLink
{

	public static void main(String[] args)
	{
		Node head = null;
		Node n1 = new Node("철수", null);
		Node n2 = new Node("영희", null);

		head = n1;
		head.setLink(n2);
		
		
		Node p = null;
		
		System.out.println(head.data);
		System.out.println(head.link.data);
		
		p = head;
		System.out.println(p.getData());
		p = head.getLink();
		System.out.println(p.getData());
		
	}

}
