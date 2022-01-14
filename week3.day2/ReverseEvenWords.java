package week3.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		//Build a logic to reverse the even position words (output: I ma a erawtfos tester)
		String text = "I am a software tester"; 
		
		String even = "";
		String evenReverse = "";
		String output = "";
		
		
		
		String [] str = text.split(" ");
		
		for(int i = 0; i < str.length; i++) {
			if(i%2 == 1) {
				even = str[i];
				for(int j = even.length()-1; j >=0; j--) {
					evenReverse = evenReverse + even.charAt(j);
					}
				str[i] = evenReverse;
				
				evenReverse = "";
			}
			
		}
		
		output = String.join(" ", str);
		
		System.out.println("Reversed the even position words " + output);
	}
}
