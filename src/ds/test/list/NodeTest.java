package ds.test.list;

import java.util.LinkedList;

public class NodeTest
{

	public static void main(String[] args)
	{
		Node<String> head = null;
		
		Node<String> n1 = new Node<String>("전우진", null);
		Node<String> n2 = new Node<String>("허유진", null);
		Node<String> n3 = new Node<String>("이인범", null);
		
		n1.setLink(n2);		
		n2.setLink(n3);
		
		head = n1;
		
		while(head != null)
		{
			System.out.println(head.getData());
			head = head.getLink();
		}
		
		Node<Integer> node1 = new Node<Integer>(1, null);
		Node<Integer> node2 = new Node<Integer>(3, null);
		
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		list.add(2, "SSS");
		
		for (String s : list)
		{
			System.out.println(s);
		}
	}

}
