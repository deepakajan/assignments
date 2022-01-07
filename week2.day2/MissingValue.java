package week1.day2;

import java.util.Arrays;

public class MissingValue {

	public static void main(String[] args) {
		int[] num= {1,2,3,5,6,7};
		Arrays.sort(num);
		int arrLength=num.length;		
		for(int i=1;i<arrLength;i++) {
			if(i!=num[i-1]) {
				System.out.println("Missing value is "+i);
				break;
			}
		}

	}

}
