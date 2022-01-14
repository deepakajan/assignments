package week3.day2;

public class CharOccurance {

	public static void main(String[] args) {
		// Check number of occurrences of a char (eg 'e') in a String
		
					String str = "welcome to chennai";

					// declare and initialize a variable count to store the number of occurrences
					
					// convert the string into char array
					char[] ch = str.toCharArray();
						
					//get the length of the array
					int arrayLength = ch.length;
					
					System.out.println("Length of array is " + arrayLength);
					
					int count = 0;
					
					// Iterate over the character array
					for (int i = 0; i < ch.length; i++) 
					{
						//check for the character and increment the count
						if('e' == ch[i])
							count++;
					}
					
					System.out.println("Number of occurances of 'e' in the given string is "+ count);			
	}

}
