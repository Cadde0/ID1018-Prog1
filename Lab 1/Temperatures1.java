// Temperatures1.java

// processing measurement

import java.util.*; // Scanner, Locale
import static java.lang.System.out;

class Temperatures1 {

	public static void main (String[] args) {
		out.println("TEMPERATURES\n");

		// input tool
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

        // enter the number of weeks and measurements
		out.print("number of weeks: ");
		int nofWeeks = in.nextInt();
		out.print("number of measurements per week: ");
		int nofMeasurementsPerWeek = in.nextInt();

        // storage space for temperature data
        double[][] t = new double[nofWeeks + 1]
                                 [nofMeasurementsPerWeek + 1];

        // read the temperatures
		for (int week = 1; week <= nofWeeks; week++)
		{
			out.println("temperatures - week " + week + ":");
			for (int reading = 1;
				reading <= nofMeasurementsPerWeek; reading++)
				t[week][reading] = in.nextDouble();
		}
		out.println("");

		// show the temperatures
		out.println("the temperatures");
        for (int week = 1; week <= nofWeeks; week++)
        {
			for (int reading = 1;
			    reading <= nofMeasurementsPerWeek; reading++)
			    out.print(t[week][reading] + " ");
		    out.println("");
		}
		out.println("");

		// the least, greatest and average temperatures - weekly
		double[] minT = new double[nofWeeks + 1];
		double[] maxT = new double[nofWeeks + 1];
		double[] sumT = new double[nofWeeks + 1];
		double[] avgT = new double[nofWeeks + 1];

        // sum readings per week
		for (int week = 1; week <= nofWeeks; week++) {
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++){
				sumT[week] += t[week][reading];
			}
		}

		//Average per week
		for (int week = 1; week <= nofWeeks; week++) {
			avgT[week] = sumT[week] / nofMeasurementsPerWeek;
		}
		//Minimum per week
		for (int week = 1; week <= nofWeeks; week++) {
			minT[week] = t[week][1];
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++){
				if (t[week][reading] < minT[week]) {
					minT[week] = t[week][reading];
				}
			}
		}

		//Maximum per week
		for(int week=1; week <= nofWeeks; week++) {
			maxT[week] = t[week][1];
			for (int reading=1; reading <= nofMeasurementsPerWeek; reading ++) {
				if (t[week][reading] > maxT[week]) {
					maxT[week] = t[week][reading];
				}
			}
		}

		// show the least, greatest and average temperatures
		out.println("the least, greatest and average temperatures"
		    + " - weekly");
		for (int week = 1; week <= nofWeeks; week++)
			out.print(minT[week] + " ");
		out.println("");
		for (int week = 1; week <= nofWeeks; week++)
			out.print(maxT[week] + " ");
		out.println("");
		for (int week = 1; week <= nofWeeks; week++)
			out.print(avgT[week] + " ");
		out.println("");
		out.println();

		// the least, greatest and average temperatures - whole period
		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumTemp = sumT[1];
		double avgTemp = 0;

		// sum, whole period
		for (int week = 2; week <= nofWeeks; week++) {
			sumTemp += sumT[week];

		}

		//Average, whole period
		avgTemp = sumTemp / (nofMeasurementsPerWeek * nofWeeks);

		//Minimum, whole period
		for (int week = 2; week <= nofWeeks; week++) {
			if (minT[week] < minTemp) {
				minTemp = minT[week];
			}
		}

		//Maximum, whole period
		for (int week = 2; week <= nofWeeks; week++) {
			if (maxT[week] > maxTemp) {
				maxTemp = maxT[week];
			}
		}

        // show the least, greatest and average temperature for
        // the whole period
		out.println("the least, greatest and average temperature"
		    + " - whole period");
        out.println(minTemp + "\n" + maxTemp + "\n" + avgTemp);
    }
}