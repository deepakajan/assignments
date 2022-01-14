package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingElementInCollection {

	public static void main(String[] args) 
	{
		// Here is the input
		List<Integer> inputArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,7,6,8));
		
		//Iterate over the input Array List
		for(int i=1; i<=inputArrayList.size()+1; i++)
		{
			if(!inputArrayList.contains(new Integer(i)))
			{
				System.out.println("Missing element in the input collection is " +i);
			}
		}
	}

}