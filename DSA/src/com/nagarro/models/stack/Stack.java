package com.nagarro.models.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack {
	int size;
	int arr[];
	int top;

	public Stack(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}
	public int size() {
		return top+1;
	}
	public void push(int pushedElement) {
		if (!isFull()) {
			top++;
			arr[top] = pushedElement;
			//System.out.println("Pushed element:" + pushedElement);
		} else {
			System.out.println("Stack is full !");
		}
	}

	public int pop() {
		if (!isEmpty()) {
			int returnedTop = top;
			top--;
			//System.out.println("Popped element :" + arr[returnedTop]);
			return arr[returnedTop];

		} else {
			System.out.println("Stack is empty !");
			return -1;
		}
	}

	public int peek() {
		if (!this.isEmpty())
			return arr[top];
		else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (size - 1 == top);
	}
	
	public boolean contains(int data) {
		for(int i=top;i>=0;i++) {
			if(arr[i]==data) {
				return true;
			}
		}
		return false;
	}
	
	public void stackIterator() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<=top;i++) {
			list.add(arr[i]);
		}
		Iterator<Integer> itr = list.iterator();
		
        while (itr.hasNext()) {
            int i = (Integer)itr.next();
            System.out.print(i + " ");
        }
		System.out.println();
	}
	
	public void printStack()
	{
	    if (isEmpty())
	        return;
	    int x = peek();
	    pop();
	    System.out.print(x + " ");
	    printStack();
	    push(x);
	}
	
	void insert_at_bottom(int x)
    {
 
        if(isEmpty())
            push(x);
 
        else
        {
            int a = peek();
            pop();
            insert_at_bottom(x);
 
            push(a);
        }
    }
     
    public void reverse()
    {
        if(size() > 0)
        {
            int x = peek();
            pop();
            reverse();
             
            insert_at_bottom(x);
        }
    }
}
