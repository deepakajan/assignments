package week1.day2;

public class Calculator {
	
	public int add (int x, int y) {
			return x+y;
			
		}
		public double sub (double a, double b)
		{
			return a-b;
			
		}
		public double mul (double c, double d)
		{
			return c*d;
		}
		public int div (int s, int t)
		{
			return s/t;
		}
		
		public static void main(String[] args) {
			Calculator calc = new Calculator();
			int result = calc.add(15, 5);
			System.out.println( "Addition is " +result);
			double result1 = calc.sub (1000, 550);
			System.out.println("Subtraction is " +result1);
			double result2 = calc.mul(120, 15);
			System.out.println("Multiplication is " +result2);
			int result3 = calc.div(150, 10);
			System.out.println("Division is " +result3);
			
		}

	}