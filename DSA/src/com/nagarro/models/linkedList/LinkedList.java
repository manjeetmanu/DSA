package com.nagarro.models.linkedList;

public class LinkedList {
	
	private int length=0;
	private Node head=new Node();
	
	public LinkedList() {
		this.length=0;
	}
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}
	public void insert(int data){
		Node current = head;
        while (current.next != null) {
            current = current.next; // we'll loop until current.next is null
        }
        Node newNode = new Node();
        newNode.data=data;
        current.next = newNode;
        length++;
    }
	
	public int insertAtPosition(int data, int position){

        if (position > length + 1){
            return -1;
        }

        Node currentNode = head;

        for(int i = 1; i <= position - 2; i++){
            currentNode = currentNode.next;
        }

        Node node = new Node();
        node.data=data;

        if (currentNode.next != null){
            node.next=currentNode.next;
        }
        currentNode.next=node;
        length++;

        return 1;
	}
	
	public void deleteNode(int position)
    {
        // If linked list is empty
        if (head == null)
            return;
        // Store head node
        Node node = head;
        // If head needs to be removed
        if (position == 0)
        {
            head = node.next;   // Change head
            return;
        }
        for (int i=0; node!=null && i<position-1; i++)
            node = node.next;
 
        if (node == null || node.next == null)
            return;
 
        Node next = node.next.next;
        node.next = next;  // Unlink the deleted node from list
    }
	
	public void delete()
    {
        if (head == null)
            return ;
 
        if (head.next == null) {
            return ;
        }
        // Find the second last node
        Node node = head;
        while (node.next.next != null)
            node = node.next;
 
        // Change next of second last
        node.next = null;
 
    }
	
	public void center() {
		Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null)
        {
            while (fast_ptr != null && fast_ptr.next != null)
            {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                                slow_ptr.data + "] \n");
        }
	}
	
	public void reverse()
    {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        //return head;
    }
	
	public void printLinkedList() {
        System.out.println("Printing LinkedList (head --> last) ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" => ");
            current = current.next;
        }
        System.out.println();
    }
}
