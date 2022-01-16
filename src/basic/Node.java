package basic;

public class Node
{
	String data;
	Node link;
	
	public Node(String data, Node link)
	{
		super();
		this.data = data;
		this.link = link;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public Node getLink()
	{
		return link;
	}

	public void setLink(Node link)
	{
		this.link = link;
	}
	
	
}
