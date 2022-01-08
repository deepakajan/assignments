package org.system;

public class DesktopSize extends Computer {
	
	public void desktopInformations() {
		String processor = "AMD";
		int ram = 16;
		int storage = 256;
		
		System.out.println("System Processor is " + processor);
		System.out.println("System RAM size is " + ram);
		System.out.println("System storage is " + storage);
	}
	
	public static void main(String[] args) {
		
		DesktopSize desktop = new DesktopSize();
		
		desktop.computerModel();
		desktop.desktopInformations();
		
	}

}
