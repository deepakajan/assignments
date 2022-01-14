package week3.day2;

public class FindTypes {

	public static void main(String[] args) {
		// Here is the input
				String text = "$$ Welcome to 2nd Class of Automation $$ ";

				// Here is what the count you need to find
				int  letter = 0, space = 0, num = 0, specialChar = 0;

				// Build the logic to find the count of each
				
				char[] ch = text.toCharArray();
				
				for(int i = 0; i < ch.length; i++) {
		
					if(Character.isLetter(ch[i]))
						letter++;
					else if (Character.isSpaceChar(ch[i]))
						space++;
					else if (Character.isDigit(ch[i]))
						num++;
					else
						specialChar++;
				}

				// Print the count here
				System.out.println("letter: " + letter);
				System.out.println("space: " + space);
				System.out.println("number: " + num);
				System.out.println("specialCharcter: " + specialChar);
		
	}

}
