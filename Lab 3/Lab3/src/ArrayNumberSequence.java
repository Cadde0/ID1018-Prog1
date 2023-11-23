// ArrayNumberSequence.java

import java.util.Arrays;
/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.java.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}


	public int length ()
	{
		return numbers.length;
	}
	public double upperBound ()
	{
		double max = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max)
				max = numbers[i];
		}
		return max;
	}
	public double lowerBound ()
	{
		double min = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < min)
				min = numbers[i];
		}
		return min;
	}
	public double numberAt(int position) throws IndexOutOfBoundsException {
		return numbers[position];
	}

	public int positionOf(double number) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == number) {
				return i;
			}
		}
		return -1;
	}

	public boolean isIncreasing () {
		// Loop through the sequence and compare each number to the one before it
		for (int i = 1; i < numbers.length; i++) {
			// If the current number is less than or equal to the previous number, the sequence is not increasing
			if (numbers[i] <= numbers[i - 1]) {
				return false;
			}
		}
		// If we've reached this point, the sequence is increasing
		return true;
	}

	public boolean isDecreasing () {
		// Loop through the sequence and compare each number to the one before it
		for (int i = 1; i < numbers.length; i++) {
			// If the current number is greater than or equal to the previous number, the sequence is not decreasing
			if (numbers[i] >= numbers[i - 1]) {
				return false;
			}
		}
		// If we've reached this point, the sequence is decreasing
		return true;
	}

	public boolean contains(double number) {
		// Loop through the sequence and check if the specified number is in it
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == number) {
				return true;
			}
		}
		// If the specified number is not in the sequence, return false
		return false;
	}

	public void add (double number) {
		// Create a new array with one extra element
		double[] newNumbers = Arrays.copyOf(numbers, numbers.length + 1);
		// Add the specified number to the end of the new array
		newNumbers[newNumbers.length - 1] = number;
		// Update the original sequence with the new array
		numbers = newNumbers;
	}

	public void insert (int position, double number) {
		if (position < 0 || position > numbers.length) {
			throw new IndexOutOfBoundsException("Invalid position: " + position);
		}
		// Create a new array with one extra element
		double[] newNumbers = new double[numbers.length + 1];
		// Copy the elements from the old array to the new array
		System.arraycopy(numbers, 0, newNumbers, 0, position);
		// Insert the new number at the specified position
		newNumbers[position] = number;
		// Copy the remaining elements from the old array to the new array
		System.arraycopy(numbers, position, newNumbers, position + 1, numbers.length - position);
		// Replace the old array with the new array
		numbers = newNumbers;
	}

	public void removeAt (int position) throws IndexOutOfBoundsException {
		if (position < 0 || position >= numbers.length) {
			throw new IndexOutOfBoundsException("Invalid position: " + position);
		}
		if (numbers.length <= 2) {
			throw new IllegalStateException("Cannot remove numbers from a sequence with just two numbers");
		}
		// Create a new array with one fewer element
		double[] newNumbers = new double[numbers.length - 1];
		// Copy the elements from the old array to the new array
		// up to the specified position
		System.arraycopy(numbers, 0, newNumbers, 0, position);
		// Copy the remaining elements from the old array to the new array
		// starting from the element after the specified position
		System.arraycopy(numbers, position + 1, newNumbers, position, numbers.length - position - 1);
		// Replace the old array with the new array
		numbers = newNumbers;
	}

	public double[] asArray () {
		return numbers;
	}
	// add code here
}