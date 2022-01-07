package week1.day2;

public class EmployeeInfo {

	//Pass name : "Deepak" ; Emp id :"07";
		public void getEmployeeDetails(String name, int empid)
		{
			System.out.println("Employee Id  is "+ empid + " and Employee Name is " + name );
		}
		public void printCompanyAddress() {
			System.out.println("Address of the company is Chennai");
		}
		public String getCompanyAddress() {
			System.out.println("I am giving company address as");
			return "Chennai";
		}
		
		public static void main(String[] args) {
		
			EmployeeInfo eInfo = new EmployeeInfo();
		eInfo.getEmployeeDetails("Deepak", 07);
		eInfo.printCompanyAddress();
				
		//System.out.println(eInfo.getCompanyAddress());
		
		String address = eInfo.getCompanyAddress();
		System.out.println(address);
		}

	}
