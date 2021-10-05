package com.nagarro.models.tree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.nagarro.utility.Utility;

public class NthChildTree {
	TreeNode root;//=new TreeNode(0);
	ArrayList<Integer> list;
	
	public void insert() {
		if(root==null) {
			root=takeInput();
		}else {
			nodeNav(root);
		}
	}
	private void nodeNav(TreeNode root) {
		System.out.print("Enter \"y\" to add new child in "+root.data+" or \"n\"go to existing child in "+root.data+" :- ");
		char ch=Utility.sc.next().charAt(0);
		if(ch=='y') {
			System.out.print("Enter the number of child you want to add to current Node  "+root.data+" :- ");
			Utility.x=Utility.sc.nextInt();
			for(int i=0;i<Utility.x;i++) {
				TreeNode child=takeInput();
				root.list.add(child);
			}
		}else {
			for(int i=0;i<root.list.size();i++) {
				nodeNav(root.list.get(i));
			}
		}
		//return root;
	}
	private TreeNode takeInput() {
		try {
			System.out.print("Enter current root data :- ");
			int data=Utility.sc.nextInt();
			TreeNode root=new TreeNode(data);
			System.out.print("Number of children enter in :- ");
			int no_of_children=Utility.sc.nextInt();
			for(int i=0;i<no_of_children;i++) {
				TreeNode Child=takeInput();
				root.list.add(Child);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return root;
	}
	
	public void delete() {
		nodeDel(root);
	}
	private boolean nodeDel(TreeNode root) {
		if(root.list.size()==0) {
			return true;
		}else {
			for(int i=0;i<root.list.size();) {
				boolean bool=nodeDel(root.list.get(i));
				if(bool) {
					root.list.remove(i);
				}else {
					i++;
				}
			}
		}
		return false;
	}
	
	public void contains(int data) {
		System.out.println(valContains(root,data));
	}
	private boolean valContains(TreeNode root, int data) {
		if(root.data==data) {
			return true;
		}else {
			for(int i=0;i<root.list.size();i++) {
				if(valContains(root.list.get(i),data))
					return true;
			}
		}
		return false;
	}
	
	public void getElementsByValue(int data) {
		if(root==null) {
			return;
		}
		Queue<TreeNode> queue =new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int len=queue.size();
			for(int i=0;i<len;i++) {
				TreeNode node=queue.poll();
				if(node.data==data) {
					System.out.println(node.data+"  ");
				}
				queue.peek();
				for(TreeNode item : node.list) {
					queue.add(item);
				}
			}
		}
	}
	
	
	public void getElementsByLevel(int data) {
		if(root==null) {
			return;
		}
		Queue<TreeNode> queue =new LinkedList<>();
		queue.add(root);
		int j=-1;
		while(!queue.isEmpty()) {
			int len=queue.size();
			j++;
			for(int i=0;i<len;i++) {
				if(j<data) {
					TreeNode node=queue.poll();
					queue.peek();
					for(TreeNode item : node.list) {
						queue.add(item);
					}
				}else {
					TreeNode node=queue.poll();
					System.out.print(node.data+"  ");
					queue.peek();
				}
			}
		}
		System.out.println();
	}
	
	public void iteratorBFS() {
		list=new ArrayList<Integer>();
		if(root==null) {
			return;
		}
		Queue<TreeNode> queue =new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int len=queue.size();
			for(int i=0;i<len;i++) {
				TreeNode node=queue.poll();
				list.add(node.data);
				queue.peek();
				for(TreeNode item : node.list) {
					queue.add(item);
				}
			}
		}
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()+"  ");
		}
	}
	
	public void iteratorDFS() {
		list=new ArrayList<>();
		iterateDFS(root);
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()+"  ");
		}
	}
	private void iterateDFS(TreeNode root) {
		list.add(root.data);
		for(int i=0;i<root.list.size();i++) {
			iterateDFS(root.list.get(i));
		}
	}
	
	public void traverseBFS() {
		if(root==null) {
			return;
		}
		Queue<TreeNode> queue =new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int len=queue.size();
			for(int i=0;i<len;i++) {
				TreeNode node=queue.poll();
				System.out.print(node.data+"  ");
				queue.peek();
				for(TreeNode item : node.list) {
					queue.add(item);
				}
			}
			System.out.println();
		}
	}
	
	public void traverseDFS() {
		printDFS(root);
	}
	private void printDFS(TreeNode root) {
		System.out.println(root.data);
		for(int i=0;i<root.list.size();i++) {
			printDFS(root.list.get(i));
		}
	}
}