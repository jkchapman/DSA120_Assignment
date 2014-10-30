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

	public boolean isEmpty()
	{
		return (head == null);
	}

}