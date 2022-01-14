package abstraction;

public class Automation extends MultipleLanguage implements Language, TestTool {

	public void selenium() {
		System.out.println("Selenium is web-driver to automate the websites");
		}

	public void java() {
		System.out.println("Java is a high=level programming language");
		
	}

	@Override
	public void ruby() {
			System.out.println("Ruby is also a high-level programming language");
		
	}
	public static void main(String[] args) {
		
		Automation automation = new Automation();
		automation.java();
		automation.python();
		automation.selenium();
		automation.ruby();
		
	}
}
