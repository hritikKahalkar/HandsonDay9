/*Employee details by linked list*/

import java.util.*;
 class Employee2 {
	private int EmpId; 
	private String EmpName;
	private String EmpEmail; 
	private char EmpGender;
	private float EmpSalary;
	
	public Employee2() {}

	public Employee2(int empId, String empName, String empEmail, char empGender, float empSalary) {
		EmpId = empId;
		EmpName = empName;
		EmpEmail = empEmail;
		EmpGender = empGender;
		EmpSalary = empSalary;
	}

	public String GetEmployeeDetails() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpEmail=" + EmpEmail 
				+ ", EmpGender=" + EmpGender + ", EmpSalary=" + EmpSalary + "]";
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpEmail() {
		return EmpEmail;
	}

	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}

	public char getEmpGender() {
		return EmpGender;
	}

	public void setEmpGender(char empGender) {
		EmpGender = empGender;
	}

	public float getEmpSalary() {
		return EmpSalary;
	}

	public void setEmpSalary(float empSalary) {
		EmpSalary = empSalary;
	}
	
	
}

 class EmployeeDB2 {
		LinkedList<Employee2> Dblist = new LinkedList<>();
		
		public boolean addEmployee(Employee2 e) {
			return Dblist.add(e);
		}
		
		public boolean deleteEmployee(int empId) {
			boolean remove = false;
			
			Iterator<Employee2> it = Dblist.iterator();
			
			while (it.hasNext()) {
				Employee2 emp = it.next();
				if (emp.getEmpId() == empId) {
					remove = true;
					it.remove();
				}
			}
			
			return remove;
		}
		
		public String showPaySlip(int empId) {
			String paySlip = "Invalid employee id";
			
			for (Employee2 e : Dblist) {
				if (e.getEmpId() == empId) {
					paySlip = "Pay slip for employee id " + empId + " is " +
							e.getEmpSalary();
				}
			}

			return paySlip;
		}
		
		public Employee2[] listAll() {
			Employee2[] empArray = new Employee2[Dblist.size()];
			for (int i = 0; i < Dblist.size(); i++)
				empArray[i] = Dblist.get(i);
			return empArray;
		}
		
	}
public class EmployeeMain2{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeDB2 db = new EmployeeDB2();
		
		Employee2 e1 = new Employee2(1,"Amar","Amar@mail",'M',300000.f);
		Employee2 e2 = new Employee2(2,"Birbal","bbb@mail",'F',420000.f);
		Employee2 e3 = new Employee2(3,"Chanakya","carr@mail",'M',700000.f);
		Employee2 e4 = new Employee2(4,"Devi","dev@mail",'F',500300.f);
		Employee2 e5 = new Employee2(5,"Eshwar","ejai@mail",'F',9000000.f);
		
		db.addEmployee(e1);
		db.addEmployee(e2);
		db.addEmployee(e3);
		db.addEmployee(e4);
		db.addEmployee(e5);
		
		for (Employee2 emp : db.listAll())
		{
			System.out.println(emp.GetEmployeeDetails());
		}
		
		System.out.println();
		db.deleteEmployee(2);
		
		for (Employee2 emp : db.listAll())
		{
			System.out.println(emp.GetEmployeeDetails());
		}
		
		System.out.println();
		
		System.out.println(db.showPaySlip(4));


	}

}
