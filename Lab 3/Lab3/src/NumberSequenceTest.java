// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import java.util.Arrays;

import static java.lang.System.out;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers =
		    {1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0};
        NumberSequence sequence = null;
        //sequence = new ArrayNumberSequence(realNumbers);
        sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        out.println("length: " + sequence.length());

        out.println("one upper bound: " + sequence.upperBound() );

        out.println("one lower bound: " + sequence.lowerBound());
        out.println();

        out.println("Number at position 4: " + sequence.numberAt(4));

        out.println("Position of 8.0: " + sequence.positionOf(8.0));
        out.println();

        out.println("Is increasing: " + sequence.isIncreasing());

        out.println("Is decreasing: " + sequence.isDecreasing());

        out.println("Contains 21.0: " + sequence.contains(21.0));
        out.println();

        out.println("Add 34.0:");
        sequence.add(34.0);
        out.println(sequence);

        out.println("Insert 0.0 at position 7:");
        sequence.insert(7,0.0);
        out.println(sequence);

        out.println("Remove number at position 7:");
        sequence.removeAt(7);
        out.println(sequence);
        out.println();

        out.println("Corresponding array:");
        out.println(Arrays.toString(sequence.asArray()));
    }
}