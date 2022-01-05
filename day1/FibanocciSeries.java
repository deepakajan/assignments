package week1.day1;

//Goal: To find Fibonacci Series for a given range
//input(range): 8 output: 0, 1, 1, 2, 3, 5, 8, 13

public class FibanocciSeries {

	public static void main(String[] args) {
		
		// initialize 3 int variables (Tip: range = 8, firstNum = 0, secNum = 1, sum in the series)
		int range = 8;
		int firstNum = 0;
		int secNum = 1;
		
		// Print first number
		System.out.println("Fibanocci series "+ firstNum);
				
		// Iterate from 1 to the range
		for(int i=1; i<=8; i++) {
						
		// add first and second number assign to sum
		 int sum = firstNum + secNum;

		// Assign second number to the first number
		 secNum = firstNum;

		// Assign sum to the second number
		 firstNum = sum;
		 
		// print sum 
		 System.out.println(sum);
		}		
	}

}
