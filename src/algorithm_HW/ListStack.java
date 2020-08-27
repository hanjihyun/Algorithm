package algorithm_HW;

public class ListStack {
	private class Node {
		Object data;
		Node prev;
		public Node(Object input) {
			this.data = input;
		}
		public String toString() {
			return data.toString();
		}
	}
	private Node top=null;
	private int size=0;
	public boolean isEmpty() {
		return top == null;
	}
	public void push(Object obj) {
		Node newNode = new Node(obj);
		if(isEmpty()) {
			top = newNode;
		}else {
			newNode.prev = top;
			top = newNode;
		}
		size++;
	}
	public Object pop() {
		if(!isEmpty()) {
			Node temp = top;
			Object data = temp.data;
			top = temp.prev;
			temp = null;
			size--;
			return data;
		}
		throw new RuntimeException("Stack is Empty");
	}
	public Object peek() {
		if(!isEmpty())
			return top.data;
		throw new IndexOutOfBoundsException();
	}
	public int size() {
		return size;
	}
	public void clear() {
		top = null;
	}
	public String toString() {
		StringBuilder strb = new StringBuilder();
		Node temp = top;
		strb.append("[");
		for(int idx=0;idx<size;idx++) {
			strb.append(" ");
			strb.append(temp.data);
			temp = temp.prev;
		}
		strb.append(" ]");
		return strb.toString();
	}
}
