public class LinkedList
{

	//Class for each node
	private class ListNode
	{
		public Student student;
		public ListNode next;

		public ListNode( Student student)
		{
			this.student = student;
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
	public void insertLast( Student student)
	{
		ListNode newNode = new ListNode( student);
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
	public Student peekFirst()
	{
		Student first;
		if( !isEmpty())
		{
			first = head.student;
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