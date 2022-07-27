/*Employee details by vector*/

import java.util.*;
 class Employee3 {
	private int EmpId; 
	private String EmpName;
	private String EmpEmail; 
	private char EmpGender;
	private float EmpSalary;
	
	public Employee3() {}

	public Employee3(int empId, String empName, String empEmail, char empGender, float empSalary) {
		
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

 class EmployeeDB3 {
		Vector<Employee3> Dblist = new Vector<>();
		
		public boolean addEmployee(Employee3 e) {
			return Dblist.add(e);
		}
		
		public boolean deleteEmployee(int empId) {
			boolean remove = false;
			
			Iterator<Employee3> it = Dblist.iterator();
			
			while (it.hasNext()) {
				Employee3 emp = it.next();
				if (emp.getEmpId() == empId) {
					remove = true;
					it.remove();
				}
			}
			
			return remove;
		}
		
		public String showPaySlip(int empId) {
			String paySlip = "Invalid employee id";
			
			for (Employee3 e : Dblist) {
				if (e.getEmpId() == empId) {
					paySlip = "Pay slip for employee id " + empId + " is " +
							e.getEmpSalary();
				}
			}

			return paySlip;
		}
		
		public Employee3[] listAll() {
			Employee3[] empArray = new Employee3[Dblist.size()];
			for (int i = 0; i < Dblist.size(); i++)
				empArray[i] = Dblist.get(i);
			return empArray;
		}
		
	}
public class EmployeeMain3{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeDB3 db = new EmployeeDB3();
		
		Employee3 e1 = new Employee3(1,"Amar","Amar@mail",'M',300000.f);
		Employee3 e2 = new Employee3(2,"Birbal","bbb@mail",'F',420000.f);
		Employee3 e3 = new Employee3(3,"Chanakya","carr@mail",'M',700000.f);
		Employee3 e4 = new Employee3(4,"Devi","dev@mail",'F',500300.f);
		Employee3 e5 = new Employee3(5,"Eshwar","ejai@mail",'F',9000000.f);
		
		db.addEmployee(e1);
		db.addEmployee(e2);
		db.addEmployee(e3);
		db.addEmployee(e4);
		db.addEmployee(e5);
		
		for (Employee3 emp : db.listAll())
		{
			System.out.println(emp.GetEmployeeDetails());
		}
		
		System.out.println();
		db.deleteEmployee(2);
		
		for (Employee3 emp : db.listAll())
		{
			System.out.println(emp.GetEmployeeDetails());
		}
		
		System.out.println();
		
		System.out.println(db.showPaySlip(5));


	}

}
