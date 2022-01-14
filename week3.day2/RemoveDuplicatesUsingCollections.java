package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesUsingCollections {

	public static void main(String[] args) {

			// Declare String text as input
			String inputString = "We learn java basics as part of java sessions in java week1";

			// Split the String into array and iterate over it
			String[] inputStringArray = inputString.split(" ");

			Set<String> hashSet = new LinkedHashSet<String>();

			for (int i = 0; i < inputStringArray.length; i++) {
				hashSet.add(inputStringArray[i]);
			}

			// Join the hash set elements
			String outputString = String.join(" ", hashSet);

			// Print the output string
			System.out.println(outputString);
		}
	}