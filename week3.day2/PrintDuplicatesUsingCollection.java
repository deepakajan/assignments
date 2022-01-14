package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintDuplicatesUsingCollection {

	public static void main(String[] args) 
	{
		//Declare an input Array List
		List<Integer> inputList = new ArrayList<Integer>(Arrays.asList(14,12,13,11,15,14,18,16,17,19,18,17,20));
		
		//Declare an input Array List
		List<Integer> duplicateList = new ArrayList<Integer>();
		
		//Declare Set and add the input elements to check for duplicate
		Set<Integer> inputSet = new HashSet<Integer>();
		
		// Iterate first ArrayList elements and add it in inputSet
		for(Integer i : inputList)
		{
			if(!inputSet.add(i))
				duplicateList.add(i);
		}
		System.out.println("Duplicate Elements in the Input Array List : "+duplicateList);
	}

}