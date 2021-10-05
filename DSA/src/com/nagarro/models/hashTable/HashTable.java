package com.nagarro.models.hashTable;


public class HashTable {
	HashTableMap[] arr;
	int capacity;
	int size;
	
	public HashTable(int data) {
		capacity=data;
		arr=new HashTableMap[capacity];
		for(int i=0;i<capacity;i++) {
			arr[i]=new HashTableMap();
		}
		
	}
	public void insert(int data) {
		int hashcode=hashCode(data);
		if(arr[hashcode].key==-1) {
			arr[hashcode].key=hashcode;
			size++;
		}
		if(!arr[hashcode].list.contains(data)) {
			arr[hashcode].list.add(data);
		}
	}
	public int hashCode(int data) {
		return data%capacity;
	}
	public void delete(int key) {
		if(key>capacity-1) {
			return ;
		}
		arr[key].key=-1;
		arr[key].list.removeAll(arr[key].list);
		size--;
	}
	public boolean contains(int data) {
		int key=hashCode(data);
		if(arr[key].key>=0) {
			if(arr[key].list.contains(data)) {
				return true;
			}
		}
		return false;
	}
	public String getValueById(int data) {
		if(data<capacity && arr[data].key>=0) {
			return arr[data].list.toString();
		}
		return "";
	}
	public int size() {
		return size;
	}
	public void iterator() {
		for(int i=0;i<capacity;i++) {
			if(arr[i].key>=0) {
				System.out.println("Key = "+ arr[i].key);
				for(int j=0;j<arr[i].list.size();j++) {
					System.out.print(arr[i].list.get(j)+" ");
				}
				System.out.println();
			}
		}
	}
	public void traverse() {
		for(int i=0;i<capacity;i++) {
			if(arr[i].key>=0) {
				System.out.println("Key = "+ arr[i].key);
				System.out.println("Value = "+ arr[i].list.toString());
			}
		}
	}
}
