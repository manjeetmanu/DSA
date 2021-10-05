package com.nagarro.models.tree;

import java.util.ArrayList;

public class TreeNode {
	int data;
	ArrayList<TreeNode> list;
	
	public TreeNode(int data) {
		this.data=data;
		list=new ArrayList<>();
	}
}
