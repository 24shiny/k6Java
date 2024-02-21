package Ch8;

public class MyLinkedList {
	
	private Node head = null; //head is a reference
	
	//innerClass
	private class Node{
		private String data;
		private Node link;
		
		public Node(String data) { //Node class' constructor
			this.data = data;
		}
	}
	
	//method1
	public void add(String data) {
		Node newNode = new Node(data);
		if(head==null) {
			head = newNode;
		}
		else
		{
			Node next = head;
			while(next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		}
		

	}
	
	//method2
	public void print() {
		if(head==null) {
			System.out.println("no data");
		}
		else
		{
			System.out.println("here are data");
			Node next = head; //new reference gets the not-null reference of head
			while(next != null) {
				System.out.println(next.data);
				next = next.link;
			}
			
		}
	}
}