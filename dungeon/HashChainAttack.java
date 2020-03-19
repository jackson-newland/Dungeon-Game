package dungeon;

public class HashChainAttack {
	
	int arraySize;
	int size;
	SinglyLinkedList[] HashTable;
	
	public HashChainAttack(final int size) {
		this.arraySize = size;
		this.size = 0;
		HashTable = new SinglyLinkedList[size];
		for(int i = 0; i < size; i++)
			HashTable[i] = new SinglyLinkedList();
	}
	
	public int hash(AttackBehavior ab) {
		return ab.hashCode() % this.arraySize;
	}
	
	public int size() {
		return size;
	}
	
	public AttackBehavior get(AttackBehavior ab) {
		Node temp = HashTable[hash(ab)].search(ab);
		if(temp == null) {
			put(ab);
			return get(ab);
		}
		return temp.getAttackBehavior();
	}

	public void put(AttackBehavior ab) {
		Node temp = HashTable[hash(ab)].search(ab);
		if(temp == null) {
			HashTable[hash(ab)].addLast(ab);
			size++;
		}
		else {
			temp.setAttackBehavior(ab);
		}
	}
	
	public class SinglyLinkedList {
		
		private Node head;
		
		public SinglyLinkedList() {
		}
		
		public void addLast(AttackBehavior ab) {
			if(this.head == null)
				this.head = new Node(ab);
			else {
				Node cur = this.head;
				while (cur.next != null)
					cur = cur.getNext();
				cur.next = new Node(ab);
			}
		}
		
		public Node search(AttackBehavior ab) {
			Node cur = this.head;
			while(cur != null) {
				if(cur.getAttackBehavior().attackDialogue().compareTo(ab.attackDialogue()) == 0)
					return cur;
				cur = cur.getNext();
			}
			return null;
		}
	}
	public class Node {
		private AttackBehavior ab;
		private Node next;
		
		public Node(AttackBehavior ab) {
			this.ab = ab;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(final Node next) {
			this.next = next;
		}
		
		public AttackBehavior getAttackBehavior() {
			return this.ab;
		}
		
		public void setAttackBehavior(AttackBehavior ab) {
			this.ab = ab;
		}
		
		public boolean equals(final Node other) {
			if(this.ab.attackDialogue().compareTo(other.ab.attackDialogue()) != 0)
				return false;
			return true;
		}
	}
}
