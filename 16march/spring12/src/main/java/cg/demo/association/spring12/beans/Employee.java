package cg.demo.association.spring12.beans;

public class Employee {
	private int employeeId;
	private String employeeName;
	private double salary;
	private String buisnessUnit;
	private int age;
	private Sbu sbu;

	public Employee() {
		
	}
	
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", buisnessUnit=" + buisnessUnit + ", age=" + age + "]";
	}


	public Sbu getSbu() {
		return sbu;
	}
	public void setSbu(Sbu sbu) {
		this.sbu = sbu;
	}
	public Employee(int employeeId, String employeeName, double salary, String buisnessUnit, int age, Sbu sbu) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.buisnessUnit = buisnessUnit;
		this.age = age;
		this.sbu = sbu;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getBuisnessUnit() {
		return buisnessUnit;
	}
	public void setBuisnessUnit(String buisnessUnit) {
		this.buisnessUnit = buisnessUnit;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
