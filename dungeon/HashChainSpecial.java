package dungeon;

public class HashChainSpecial {
	
	int arraySize;
	int size;
	SinglyLinkedList[] HashTable;
	
	public HashChainSpecial(final int size) {
		this.arraySize = size;
		this.size = 0;
		HashTable = new SinglyLinkedList[size];
		for(int i = 0; i < size; i++)
			HashTable[i] = new SinglyLinkedList();
	}
	
	public int hash(SpecialBehavior sb) {
		return sb.hashCode() % this.arraySize;
	}
	
	public int size() {
		return size;
	}
	
	public SpecialBehavior get(SpecialBehavior sb) {
		Node temp = HashTable[hash(sb)].search(sb);
		if(temp == null) {
			put(sb);
			return get(sb);
		}
		return temp.getSpecialBehavior();
	}

	public void put(SpecialBehavior sb) {
		Node temp = HashTable[hash(sb)].search(sb);
		if(temp == null) {
			HashTable[hash(sb)].addLast(sb);
			size++;
		}
		else {
			temp.setSpecialBehavior(sb);
		}
	}
	
	public class SinglyLinkedList {
		
		private Node head;
		
		public SinglyLinkedList() {
		}
		
		public void addLast(SpecialBehavior sb) {
			if(this.head == null)
				this.head = new Node(sb);
			else {
				Node cur = this.head;
				while (cur.next != null)
					cur = cur.getNext();
				cur.next = new Node(sb);
			}
		}
		
		public Node search(SpecialBehavior sb) {
			Node cur = this.head;
			while(cur != null) {
				if(cur.getSpecialBehavior().specialOption().compareTo(sb.specialOption()) == 0)
					return cur;
				cur = cur.getNext();
			}
			return null;
		}
	}
	public class Node {
		private SpecialBehavior sb;
		private Node next;
		
		public Node(SpecialBehavior sb) {
			this.sb = sb;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(final Node next) {
			this.next = next;
		}
		
		public SpecialBehavior getSpecialBehavior() {
			return this.sb;
		}
		
		public void setSpecialBehavior(SpecialBehavior sb) {
			this.sb = sb;
		}
		
		public boolean equals(final Node other) {
			if(this.sb.specialOption().compareTo(other.sb.specialOption()) != 0)
				return false;
			return true;
		}
	}
}
