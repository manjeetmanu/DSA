package com.nagarro.models.priorityQueue;

import java.util.ArrayList;

public class PriorityQueue {
	private ArrayList<Integer> list=new ArrayList<>();
	private int queueMaxSize;
	private int size;
	
	public PriorityQueue(int size){
		queueMaxSize=size;
		this.size=0;
	}
	public void enqueue(int data) {
		if(size<queueMaxSize) {
			list.add(data);
			size++;
			int child=list.size()-1;
			int parent=list.size()/2-1;
			if(size!=1 && list.get(child)>list.get(parent)) {
				heapArrangememt(child, parent);
			}
		}else {
			System.out.println("Queue is at its max position.");
		}
	}
	private void heapArrangememt(int child,int parent) {
		int temp=list.get(child);
		list.set(child, list.get(parent));
		list.set(parent , temp);
		child=parent;
		parent =((child+1)/2)-1;
		if(parent>=0 && list.get(child)>list.get(parent)) {
			heapArrangememt(child, parent);
		}
	}
	public void dequeue() {
		if(list.size()==0) {
			return;
		}
		System.out.println("Dequeued :- "+ list.get(0));
		list.set(0,list.get(list.size()-1));
		list.remove(size-1);
		size--;
		heapify(0);
	}
	private void heapify(int idx) {
		int leftChild = ((idx+1)*2)-1;
		int rightChild= ((idx+1)*2);
		if(leftChild<list.size() && rightChild<list.size()) {
			if(list.get(leftChild)>list.get(rightChild)) {
				if(list.get(leftChild)>list.get(idx)) {
					int temp=list.get(leftChild);
					list.set(leftChild, list.get(idx));
					list.set(idx, temp);
					heapify(leftChild);
				}
			}else {
				int temp=list.get(rightChild);
				list.set(rightChild, list.get(idx));
				list.set(idx, temp);
				heapify(rightChild);
			}
			
		}else if(leftChild<list.size()) {
			if(list.get(leftChild)>list.get(idx)) {
				int temp=list.get(leftChild);
				list.set(leftChild, list.get(idx));
				list.set(idx, temp);
				heapify(leftChild);
			}
		}else {
			return;
		}
	}
	public int peek() {
		return list.get(0);
	}
	public boolean contains(int data) {
		boolean bool=false;
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==data) {
				return true;
			}
		}
		return bool;
	}
	public int size() {
		return list.size();
	}
	public void reverse() {
		int[] arr=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			arr[i]=list.get(i);
		}
		int i = (arr.length - 2) / 2;
        while (i >= 0) {
            maxToMin(arr, i--, arr.length);
        }
        for(i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+" ");
        }
        System.out.println();
	}
	private static void maxToMin(int[] arr, int i, int size)
    {
        int left = 2*i+1;
        int right = 2*i+2;
 
        int smallest = i;
 
        if (left < size && arr[left] < arr[i]) {
            smallest = left;
        }
 
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i)
        {
        	int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            maxToMin(arr, smallest, size);
        }
    }
	public void traverse() {
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}
}
