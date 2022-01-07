package week1.day2;

public class SumOfDigit {

	public static void main(String[] args) {
		int n = 246; //2+4+6 ->12
		
		int sum = 0; // in addition - initial value should be 0
		
		while (n > 0) {
			int rem = n % 10;
			sum = sum + rem; // 0+6+4 
			n = n/10; //  246/10 ->24
		}
		System.out.println(sum);
	}

}