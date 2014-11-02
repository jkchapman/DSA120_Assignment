//lecture 8

import java.util.NoSuchElementException;

public class BinarySearchTree
{

	private class TreeNode
	{
		public String key;
		public Object value;
		public TreeNode leftChild;
		public TreeNode rightChild;

		private TreeNode( String key, Object value)
		{
			if( key == null)
			{
				throw new IllegalArgumentException("Key cannot be null!");
			}
			this.key = key;
			this.value = value;
			rightChild = null;
			leftChild = null;
		}
	}

	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public Object find(String key)
	{
		return findRecursive(key, root);
	}

	private Object findRecursive( String key, TreeNode currNode)
	{
		//int ii = 1;
		Object val = null;

		if( currNode == null)
		{
			//System.out.println(ii);
			throw new NoSuchElementException("Key " + key + " not found");
		}
		else if( currNode.key.startsWith(key))
		{
			val = currNode.value;
		}
		else if( key.compareTo( currNode.key) < 0)
		{
			//ii++;
			val = findRecursive( key, currNode.leftChild);
		}
		else
		{
			//ii++;
			val = findRecursive( key, currNode.rightChild);
		}
		return val;
	}

	public void insert( String key, Object value)
	{
		root = insertRecursive( key, value, root);
	}

	private TreeNode insertRecursive( String key, Object value, TreeNode currNode)
	{
		TreeNode upDateNode = currNode;
		if( currNode == null)
		{
			TreeNode newNode = new TreeNode( key, value);
			upDateNode = newNode;
		}
		else if( key.equals(currNode.key))
		{
			throw new IllegalArgumentException("This key already in use!");
		}
		else if( key.compareTo( currNode.key) < 0)
		{
			currNode.leftChild = insertRecursive( key, value, currNode.leftChild);
		}
		else
		{
			currNode.rightChild = insertRecursive( key, value, currNode.rightChild);
		}
		return upDateNode;
	}

}