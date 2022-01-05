package week1.day2;

public class PrimeNumber {

	public static void main(String[] args) {

		int num = 13;	
		 int flag = 0;
		 for (int i=2; i<=num; i++) {
			 int prime = num%i;
			 if (prime==0) {
				 flag= flag+1;	 
			 }
		 }
		 if(flag==1) {
			 System.out.println("The given number is prime " + num);
		 }
		 else {
			 System.out.println("The given number is not prime " +num);
		 }
	}

}