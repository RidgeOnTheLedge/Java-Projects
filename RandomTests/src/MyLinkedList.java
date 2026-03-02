
public class MyLinkedList<E>
{
	
	private Node head;
	private Node tail;
	private int size;
	
	private class Node
	{
		public Node prev;
		public Node next;
		public E data;
		
		public Node(E data)
		{
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{	
		return size == 0;
	}
	
	
	public void clear()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public void add(E e)
	{
		Node newNode = new Node(e);
		Node oldNode = tail;
		if(isEmpty())
		{
			head = newNode;
			tail = newNode;
		}
		else
		{	
			newNode.next = null;
			newNode.prev = oldNode;
			oldNode.next = newNode;
			tail = newNode;
		}
		
		size++;
	}
	
	private Node getNode(int index)
	{
		if(index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException("Index: " + index + " Size:" + size);
		}
		
		Node node = head;
		for(int i = 0; i < index; i++)
		{
			node = node.next;
		}
		return node;
	}
	
	public E get(int index)
	{
		return getNode(index).data;
	}
	
	public E remove(int index)
	{
		E data = get(index);
		if(index == 0)
		{
			if(head == tail)
			{	
				tail = null;
			}
			head = head.next;
			if(head != null)
			{
				head.prev = null;
			}
		}
		else
		{
			Node prevNode = getNode(index - 1);
			prevNode.next = prevNode.next.next;
			if(prevNode.next != null)
			{
				prevNode.next.prev = prevNode;
			}
			else
			{
				tail = prevNode;
			}
		}
		
		size--;
		return data;	
	}
}
