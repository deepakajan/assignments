package week3.day2;

public class Palindrome {

	public static void main(String[] args) {
	//Build a logic to find the given string is palindrome or not
	    //) Declare A String value as"madam" 
		String input = "madam";
		
		//b) Declare another String rev value as ""
		String revinput = "";
		
		//c) Iterate over the String in reverse order
		 for (int i = input.length() - 1; i >= 0; i--) {
	            System.out.print(input.charAt(i));
	            
	          //d) Add the char into rev
	            //revinput = revinput + input.charAt(i);
	            revinput = revinput + input.charAt(i);
	        }
			 
		 //e) Compare the original String with the reversed String, if it is same then print palinDrome 
		 if(input.equals(revinput))
				System.out.println(" - the given string is a palindrome");
			else
				System.out.println("- the given string is not a palindrome");

	}

}
