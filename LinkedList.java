public class LinkedList
{

	//Class for each node
	private class ListNode
	{
		public Object value;
		public ListNode next;

		public ListNode( Object value)
		{
			this.value = value;
			next = null;
		}
	}

	//Classfields (only head)
	private ListNode head;

	//default constructor
	public LinkedList()
	{
		head = null;
	}

	//mutator - insert last
	public void insertLast( Object value)
	{
		ListNode newNode = new ListNode( value);
		if( isEmpty())
		{
			head = newNode;
		}
		else
		{
			ListNode currNode = head;
			while( currNode.next != null)
			{
				currNode = currNode.next;
			}
			currNode.next = newNode;
		}
	}

	//accessor peek first element
	public Object peekFirst()
	{
		Object first;
		if( !isEmpty())
		{
			first = head.value;
		}
		else
		{
			throw new IllegalArgumentException("List is empty!");
		}
		return first;
	}

	public boolean isEmpty()
	{
		return (head == null);
	}

}