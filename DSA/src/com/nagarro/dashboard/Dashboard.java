package com.nagarro.dashboard;


import com.nagarro.models.hashTable.HashTable;
import com.nagarro.models.linkedList.LinkedList;
import com.nagarro.models.priorityQueue.PriorityQueue;
import com.nagarro.models.queue.Queue;
import com.nagarro.models.stack.Stack;
import com.nagarro.models.tree.NthChildTree;
import com.nagarro.utility.*;

public class Dashboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utility.dataStructureType = dsType();
		dsOperation();

	}

	public static int dsType() {
		System.out.println("1. Linked List");
		System.out.println("2. Stack");
		System.out.println("3. Queue");
		System.out.println("4. Priority Queue");
		System.out.println("5. Nth Child Tree");
		System.out.println("6. Hash Table");
		System.out.print("==> Which Data Structure You want to use :- ");
		try {
			Utility.x = Utility.sc.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		return Utility.x;
	}

	public static void dsOperation() {
		switch (Utility.dataStructureType) {
		// Case statements
		case 1:
			forLinkedList();
			break;
		case 2:
			forStack();
			break;
		case 3:
			forQueue();
			break;
		case 4:
			forPriorityQueue();
			break;
		case 5:
			forNthChildTree();
			break;
		case 6:
			forHashTable();
			break;
		// Default case statement
		default:
			System.out.println("You have not selected proper Data Structure");
		}
	}
	
	private static void forLinkedList() {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		while (Utility.ch == 'y') {
			linkedListOperations();
			System.out.print("Which operation you want to perform :- ");
			try {
				Utility.operationNumber = Utility.sc.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			switch (Utility.operationNumber) {
			case 1:
				// insert at last
				try {
					System.out.print("Enter the data you want to insert in the Linked List :- ");
					Utility.data = Utility.sc.nextInt();
					list.insert(Utility.data);
					list.printLinkedList();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 2:
				// insert at some position
				try {
					System.out.print("Enter the data you want to insert in the Linked List :- ");
					Utility.data = Utility.sc.nextInt();
					System.out.print("Enter the position at which you want to insert in the Linked List :- ");
					Utility.position = Utility.sc.nextInt();
					list.insertAtPosition(Utility.data, Utility.position);
					list.printLinkedList();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 3:
				list.delete();
				list.printLinkedList();
				break;
			case 4:
				try {
					System.out.print("Enter the number of position you want to remove from Linked List :- ");
					Utility.data = Utility.sc.nextInt();
					list.deleteNode(Utility.data);
					list.printLinkedList();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 5:
				list.center();
				break;
			case 6:
				list.reverse();
				list.printLinkedList();
				break;
			case 7:
				System.out.println(list.size());
				break;
			case 8:
				break;
			case 9:
				list.printLinkedList();
				break;
			default:
				System.out.println("Wrong option selected.");
			}

			System.out.print("Want to perform other operation (y/n) :- ");
			Utility.ch = Utility.sc.next().charAt(0);
		}

	}
	private static void linkedListOperations() {
		System.out.println("1. Insert");
		System.out.println("2. Insert at Position");
		System.out.println("3. Delete");
		System.out.println("4. Delete at position");
		System.out.println("5. Center");
		System.out.println("6. Reverse");
		System.out.println("7. Size");
		System.out.println("8. Iterator");
		System.out.println("9. Traverse/Print");
	}

	private static void forStack() {
		// TODO Auto-generated method stub
		System.out.print("Enter the size of Stack :- ");
		try {
			Stack stack = new Stack(Utility.sc.nextInt());
			while (Utility.ch == 'y') {
				StackOperations();
				System.out.print("Which operation you want to perform :- ");
				try {
					System.out.print("Enter the data you want to insert :- ");
					Utility.operationNumber = Utility.sc.nextInt();
				} catch (Exception e) {
					System.out.println(e);
				}
				switch (Utility.operationNumber) {
				case 1:
					try {
						Utility.data=Utility.sc.nextInt();
						stack.push(Utility.data);
					}catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 2:
					try {
						stack.pop();
					}catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 3:
					try {
						System.out.println(stack.peek());
					}catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 4:
					try {
						System.out.print("Enter the element you want to search :- ");
						Utility.data=Utility.sc.nextInt();
						System.out.println(stack.contains(Utility.data));
					}catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 5:
					System.out.println(stack.size());
					break;
				case 6:
					stack.reverse();
					break;
				case 7:
					stack.stackIterator();
					break;
				case 8:
					stack.printStack();
					System.out.println();
					break;
				default:
					System.out.println("Wrong option selected.");
				}

				System.out.print("Want to perform other operation (y/n) :- ");
				Utility.ch = Utility.sc.next().charAt(0);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private static void StackOperations() {
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. Peek");
		System.out.println("4. Contains");
		System.out.println("5. Size");
		System.out.println("6. Reverse");
		System.out.println("7. Iterator");
		System.out.println("8. Traverse/Print");
	}

	private static void forQueue() {
		// TODO Auto-generated method stub
		System.out.print("Enter the Size of Queue :- ");
		try {
			Utility.data=Utility.sc.nextInt();
		}catch(Exception e) {
			System.out.println(e);
		}
		Queue queue=new Queue(Utility.data);
		while (Utility.ch == 'y') {
			QueueOperations();
			System.out.print("Which operation you want to perform :- ");
			try {
				Utility.operationNumber = Utility.sc.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			switch (Utility.operationNumber) {
			case 1:
				try {
					System.out.print("Enter the data you want to insert in Queue :- ");
					Utility.data=Utility.sc.nextInt();
					queue.enqueue(Utility.data);
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 2:
				queue.dequeue();
				//dequeue
				break;
			case 3:
				queue.peek();
				//peek
				break;
			case 4:
				try {
					System.out.print("Enter the data you want to search in Queue :- ");
					Utility.data=Utility.sc.nextInt();
					System.out.println(queue.contains(Utility.data));
				}catch(Exception e) {
					System.out.println(e);
				}
				//contains
				break;
			case 5:
				System.out.println(queue.size());
				//size
				break;
			case 6:
				queue.reverse();
				//reverse
				break;
			case 7:
				queue.iterate();
				//iterator
				break;
			case 8:
				queue.traverse();
				//traverse/print
				break;
			default:
				System.out.println("Wrong option selected.");
			}

			System.out.print("Want to perform other operation (y/n) :- ");
			Utility.ch = Utility.sc.next().charAt(0);
		}
	}
	private static void QueueOperations() {
		System.out.println("1. Enqueue");
		System.out.println("2. Dequeue");
		System.out.println("3. Peek");
		System.out.println("4. Contains");
		System.out.println("5. Size");
		System.out.println("6. Reverse");
		System.out.println("7. Iterator");
		System.out.println("8. Traverse/Print");
	}

	private static void forPriorityQueue() {
		// TODO Auto-generated method stub
		System.out.print("Enter the size of Queue :- ");
		Utility.data=Utility.sc.nextInt();
		PriorityQueue queue=new PriorityQueue(Utility.data);
		while (Utility.ch == 'y') {
			PriorityQueueOperations();
			System.out.print("Which operation you want to perform :- ");
			try {
				Utility.operationNumber = Utility.sc.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			switch (Utility.operationNumber) {
			case 1:
				try {
					System.out.print("Enter the data you want to insert in the Priority Queue :- ");
					Utility.data = Utility.sc.nextInt();
					queue.enqueue(Utility.data);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 2:
				queue.dequeue();
				break;
			case 3:
				System.out.println(queue.peek());
				break;
			case 4:
				try {
					System.out.print("Enter the data you want to search in the Priority Queue :- ");
					Utility.data = Utility.sc.nextInt();
					System.out.println(queue.contains(Utility.data));
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 5:
				System.out.println(queue.size());
				break;
			case 6:
				queue.reverse();
				break;
			case 7:
				queue.traverse();
				break;
			default:
				System.out.println("Wrong option selected.");
			}

			System.out.print("Want to perform other operation (y/n) :- ");
			Utility.ch = Utility.sc.next().charAt(0);
		}

	}
	private static void PriorityQueueOperations() {
		System.out.println("1. Enqueue");
		System.out.println("2. Dequeue (Highest Priority)");
		System.out.println("3. peek Highest Priority");
		System.out.println("4. Contains");
		System.out.println("5. Size");
		System.out.println("6. Reverse");
		System.out.println("7. Traverse/Print");
	}

	private static void forNthChildTree() {
		// TODO Auto-generated method stub
		NthChildTree tree=new NthChildTree();
		while (Utility.ch == 'y') {
			TreeOperations();
			System.out.print("Which operation you want to perform :- ");
			try {
				Utility.operationNumber = Utility.sc.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			switch (Utility.operationNumber) {
			case 1:
				tree.insert();
				//insert
				break;
			case 2:
				tree.delete();
				//delete
				break;
			case 3:
				try {
					System.out.print("Enter the data you want to search :- ");
					Utility.data=Utility.sc.nextInt();
					tree.contains(Utility.data);
				}catch(Exception e) {
					System.out.println(e);
				}
				//contains
				break;
			case 4:
				try {
					System.out.print("Enter data for get element by value :- ");
					Utility.data=Utility.sc.nextInt();
					tree.getElementsByValue(Utility.data);
				}catch(Exception e) {
					System.out.println(e);
				}
				//get element by value
				break;
			case 5:
				try {
					System.out.print("Enter level number :- ");
					Utility.data=Utility.sc.nextInt();
					tree.getElementsByLevel(Utility.data);
				}catch(Exception e) {
					System.out.println(e);
				}
				//get element by level
				break;
			case 6:
				//iterate bfs
				break;
			case 7:
				//iterate dfs
				break;
			case 8:
				tree.traverseBFS();
				//traverse bfs
				break;
			case 9:
				tree.traverseDFS();
				//traverse dfs
				break;
			default:
				System.out.println("Wrong option selected.");
			}

			System.out.print("Want to perform other operation (y/n) :- ");
			Utility.ch = Utility.sc.next().charAt(0);
		}
	}

	private static void TreeOperations() {
		System.out.println("1. Insert");
		System.out.println("2. Delete");
		System.out.println("3. Contains");
		System.out.println("4. Get Element By value");
		System.out.println("5. Get Element By level");
		System.out.println("6. Iterator Breadth First");
		System.out.println("7. Iterator Depth First");
		System.out.println("8. Traverse/Print Breadth First");
		System.out.println("9. Traverse/Print Depth First");
	}

	private static void forHashTable() {
		// TODO Auto-generated method stub
		System.out.print("Enter the size of HashTable :- ");
		try {
			Utility.size=Utility.sc.nextInt();
		}catch(Exception e) {
			System.out.println(e);
		}
		HashTable table=new HashTable(Utility.size);
		while (Utility.ch == 'y') {
			HashTableOperations();
			System.out.print("Which operation you want to perform :- ");
			try {
				Utility.operationNumber = Utility.sc.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			switch (Utility.operationNumber) {
			case 1:
				try {
					System.out.print("Enter the data you want to insert :- ");
					Utility.data=Utility.sc.nextInt();
					table.insert(Utility.data);
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 2:
				try {
					System.out.print("Enter the key you for which you want to remove value :- ");
					Utility.data=Utility.sc.nextInt();
					table.delete(Utility.data);
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 3:
				try {
					System.out.print("Enter the value you want to search :- ");
					Utility.data=Utility.sc.nextInt();
					System.out.println(table.contains(Utility.data));
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 4:
				try {
					System.out.print("Enter the key for which you want to get values :- ");
					Utility.data=Utility.sc.nextInt();
					System.out.println(table.getValueById(Utility.data));
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 5:
				System.out.println(table.size());
				break;
			case 6:
				table.iterator();
				break;
			case 7:
				table.traverse();
				break;
			default:
				System.out.println("Wrong option selected.");
			}

			System.out.print("Want to perform other operation (y/n) :- ");
			Utility.ch = Utility.sc.next().charAt(0);
		}
	}

	private static void HashTableOperations() {
		System.out.println("1. Insert");
		System.out.println("2. Delete");
		System.out.println("3. Contains");
		System.out.println("4. Get Value by key");
		System.out.println("5. Size");
		System.out.println("6. Iterator");
		System.out.println("7. Traverse/Print");
	}
}
