// LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.java.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

	public int length () {
		int size = 1;
		Node currentNode = first;
		while (currentNode.next != null){
			currentNode = currentNode.next;
			size ++;
		}
		return size;
	}

	public double upperBound () {
		double max = first.number;
		Node currentNode = first;
		for (int i = 0; i + 1 < length(); i++){
			if (currentNode.next.number > max) {
				max = currentNode.next.number;
			}
		currentNode = currentNode.next;
		}
		return max;
	}

	public double lowerBound () {
		double min = first.number;
		Node currentNode = first;
		for (int i = 0; i + 1 < length(); i++){
			if (currentNode.next.number < min) {
				min = currentNode.next.number;
			}
		currentNode = currentNode.next;
		}
		return min;
	}

	public double numberAt(int position) throws IndexOutOfBoundsException {
		Node currentNode = first;
		int i = 0;
		while (i != position){
			currentNode = currentNode.next;
			i++;
		}
		return currentNode.number;
	}

	public int positionOf(double number) {
		Node currentNode = first;
		for (int i = 0; i < length(); i++){
			if (currentNode.number == number)
				return i;
		currentNode = currentNode.next;
		}
		return -1;
	}

	public boolean isIncreasing () {
		Node currentNode = first;
		//Loop through the sequence and compare each number to the one before it
		for (int i = 0; i + 1 < length(); i++) {
			//If the current number is less than or equal to the next number, the sequence is not increasing.
			if (currentNode.number >= currentNode.next.number) {
				return false;
			}
			currentNode = currentNode.next;
		}
		//If we reached this point, the sequence is increasing
		return true;
	}

	public boolean isDecreasing () {
		Node currentNode = first;
		//Loop through the sequence and compare each number to the one before it
		for (int i = 0; i + 1 < length(); i++) {
			//If the current number is greater than or equal to the next number, the sequence is not increasing.
			if (currentNode.number <= currentNode.next.number) {
				return false;
			}
			currentNode = currentNode.next;
		}
		//If we reached this point, the sequence is decreasing
		return true;
	}

	public boolean contains(double number) {
		Node currentNode = first;
		// Loop through the sequence and check if the specified number is in it
		for (int i = 0; i < length(); i++){
			if (currentNode.number == number){
				return true;
			}
		currentNode = currentNode.next;
		}
		// If the specified number is not in the sequence, return false
		return false;
	}

	public void add (double number) {
		Node currentNode = first;
		// Iterate to the last node
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		// Add the new node
		currentNode.next = new Node(number);
	}

	public void insert (int position, double number) {
		if (position < 0 || position > length()) {
			throw new IndexOutOfBoundsException("Invalid position: " + position);
		}
		Node currentNode = first;
		// Create a new Node with designated number
		Node newNode = new Node(number);
		// If position is 0
		if (position == 0)
			currentNode = newNode;
		// Iterate to the node before the position
		for (int i = 0; i < position - 1; i++) {
			currentNode = currentNode.next;
		}
		// Point the newNode to the next node, then point the current node to the newNode
		if(currentNode.next != null) {
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
	}

	public void removeAt (int position) throws IndexOutOfBoundsException {
		Node currentNode = first;
		if (position < 0 || position >= length()) {
			throw new IndexOutOfBoundsException("Invalid position: " + position);
		}
		if (length() <= 2)
			throw new IllegalStateException("Cannot remove numbers from a sequence with just two numbers");
		// Iterate to the position
		for (int i = 0; i < position -1; i++){
			if (currentNode.next != null){
				currentNode = currentNode.next;
			}
		}
		// "Skip" the node to be removed by pointing to the one after
		currentNode.next = currentNode.next.next;
	}

	public double[] asArray () {
		Node currentNode = first;
		int i = 0;
		// Create new array
		double[] numbersArray = new double[length()];
		// Copy each value from the node to the array
		while (currentNode != null) {
			numbersArray[i] = currentNode.number;
			i++;
			currentNode = currentNode.next;
		}
		return numbersArray;
	}
    // add code here
}