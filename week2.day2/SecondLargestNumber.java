package week1.day2;
import java.util.Arrays;

public class SecondLargestNumber {

	public static void main(String[] args) {
		

		int[] data = {3,2,11,4,6,12,15,18,16,7};
		Arrays.sort(data);
		int number = data.length-2;
		System.out.println("Second Largest: "+data[number]);  
		
	}

}