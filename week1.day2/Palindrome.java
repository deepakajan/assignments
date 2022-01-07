package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		int num = 34343;
		int temp = num;
		int sum = 0;
		while(temp>0) {
		int remainder = temp % 10;
		sum = (sum * 10) +remainder;
		 temp = temp / 10;
		}
		if (num == sum) {
			System.out.println(num+" is palindrome number" );
		}
		else {
			System.out.println(num+" is not palindrome number");
		}
	}

}