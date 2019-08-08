class CustomLinkedList {

	Node head; // head of list

	// Linked list Node.
	private class Node {
		int data;
		Node next;

		// Constructor
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Method to insert a new node
	private void insert (int data) {
		// Create a new node with given data
		Node newNode = new Node(data);

		// If the Linked List is empty,
		// then make the new node as head
		if (this.head == null) {
			this.head = newNode;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node node = this.head;
			while (node.next != null) {
				node = node.next;
			}

			// Insert the new_node at last node
			node.next = newNode;
		}
	}

	//Method to remove tail node
	private void removeTailNode () {
		Node node = this.head;
		while (node.next.next != null)
			node = node.next;

		// Change next of second last
		node.next = null;
	}

	//Method to remove nodes which are greater then target value
	private void removeGreaterNode (int value) {

		// Condition when list have no elements
		if (this.head == null) return;

		//Condition for list of size 1
		if(this.head.data > value && this.head.next == null) {
			this.head = null;
			return;
		}
		
		Node current = this.head;

		//Finding greater nodes and replacing them with next element
		while (current != null && current.data > value) {
			current = current.next;
		}

		while (current.next != null) {
			if (current.next.data > value) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}

	// Method to print the LinkedList.
	private void printList() {
		Node currentNode = this.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currentNode != null) {
			// Print the data at current node
			System.out.print(currentNode.data + " ");

			// Go to next node
			currentNode = currentNode.next;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		CustomLinkedList list = new CustomLinkedList();

		// Insert the values 
		list.insert(4);
		list.insert(5);
		list.insert(3);
		list.insert(7);
		list.insert(1);
		list.insert(6);

		//Remove tail node
		list.removeTailNode();

		//remove greater nodes
		list.removeGreaterNode(4);

		// Print the LinkedList
		list.printList();
	}
}