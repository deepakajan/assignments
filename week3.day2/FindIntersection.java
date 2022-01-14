package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindIntersection {
	
		public static void main(String[] args) {

			// Declare an ArrayList for {3,2,11,4,6,7};
			List<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(3, 2, 11, 4, 6, 7));

			// Declare another ArrayList for {1,2,8,4,9,7};
			List<Integer> arrayList2 = new ArrayList<Integer>(Arrays.asList(1, 2, 8, 4, 9, 7));

			Set<Integer> inputSet1 = new HashSet<Integer>();

			// Declare another ArrayList for storing resultset
			List<Integer> resultArrayList = new ArrayList<Integer>();

			System.out.println("The intersection of two input arrays is : ");

			// Iterate first ArrayList elements and add it in inputSet
			for (Integer i : arrayList1)
				inputSet1.add(i);

			/*
			 * Iterate second ArrayList elements and check if it is matching with input set,
			 * if yes add the element in resultArrayList
			 */
			for (Integer i : arrayList2) {
				if (inputSet1.contains(i))
					resultArrayList.add(i);
			}

			// Print the matching element in both the arrays
			System.out.println(resultArrayList);
		}

	}