package com.nagarro.models.queue;

import java.util.ArrayList;
import java.util.Iterator;

public class Queue {
	int maxSize;
	int size=0;
	ArrayList<Integer> list=new ArrayList<>();
	public Queue(int data) {
		maxSize=data;
	}
	public void enqueue(int data) {
		if(list.size()<maxSize) {
			list.add(data);
			size++;
		}else {
			System.out.println("Queue is full, Please remove one or more item");
		}
	} 
	public void dequeue() {
		if(list.size()==0) {
			System.out.println("Queue Under Flow");
		}else {
			System.out.println(list.get(0));
			list.remove(0);
			size--;
		}
	}
	public void peek() {
		if(list.size()==0) {
			System.out.println("Queue Under Flow. Nothing to print.");
		}else {
			System.out.println(list.get(0));
		}
	}
	public boolean contains(int data) {
		return list.contains(data);
	}
	public int size() {
		return size;
	}
	public void reverse() {
		for(int i=0;i<list.size()/2;i++) {
			int temp=list.get(i);
			list.set(i, list.get(size-1-i));
			list.set(size-1-i, temp);
		}
	}
	public void iterate(){
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
            int i = (Integer)itr.next();
            System.out.print(i + " ");
        }
		System.out.println();
	}
	public void traverse() {
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + " ");
        }
		System.out.println();
	}
}
