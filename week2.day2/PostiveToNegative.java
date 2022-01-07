package week1.day2;

public class PostiveToNegative {

	public static void main(String[] args) {
		double n = -350;
		if (n < 0) {
			n *= -1; // n= n*(-1) -350= -350 * -1
			System.out.println("Given number is Negative");
			System.out.println("Given Negative number is converted into positive number" + " " + n);
		}
	}
}
