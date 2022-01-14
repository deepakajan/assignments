package week3.day2;
import java.util.Arrays; 

public class Anagram {

	public static void main(String[] args) {
		/*
		 * Pseudo Code
		  
		 *Declare a String 
			String text1 = "stops";
		 *Declare another String
			String text2 = "potss"; 
		 * a) Check length of the strings are same then (Use A Condition)
		 * b) Convert both Strings in to characters
		 * c) Sort Both the arrays
		 * d) Check both the arrays has same value
		 * 
		 */
		String text1 = "VAAJ";
		String text2 = "JAVA";
		
		if(text1.length() == text2.length()) {
			System.out.println("Length of both texts are equal");
			 			 
			 char[] charArr1 = text1.toCharArray();
			 char[] charArr2 = text2.toCharArray();
			 
			 Arrays.sort(charArr1);
			 Arrays.sort(charArr2);
			 
			 if(Arrays.equals(charArr1, charArr2)) {
				 System.out.println("The two texts are anagram of each other");
			 }
			 else
				System.out.println("The two texts are not anagram");
		 
		}

	}

}
