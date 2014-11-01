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

		public TreeNode( String key, Object value)
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
		Object val = null;

		if( currNode == null)
		{
			throw new NoSuchElementException("Key " + key + " not found");
		}
		else if( key.equals(currNode.key))
		{
			val = currNode.value;
		}
		else if( key.compareTo( currNode.key) < 0)
		{
			val = findRecursive( key, currNode.leftChild);
		}
		else
		{
			val = findRecursive( key, currNode.rightChild);
		}
		return val;
	}

	public void insert( String key, Object value)
	{
		insertRecursive( key, value, root);
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