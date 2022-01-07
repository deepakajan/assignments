package week1.day2;

	import java.util.Arrays;

	public class SecondSmallestNum {

		public static void main(String[] args) {
			int[] number= {1,9,6,7,5,10};
			Arrays.sort(number);
			System.out.println("Second smallest number is:"+number[1]);
		}

	}

