package cg.demo.association.spring12.beans;

import java.util.List;

public class Sbu {
	private int sbuId;
	private String sbuName;
	private String sbuHead;
	private List<Employee> empList;
	public Sbu() {
		
		// TODO Auto-generated constructor stub
	}
	public Sbu(int sbuId, String sbuName, String sbuHead, List<Employee> empList) {
		
		this.sbuId = sbuId;
		this.sbuName = sbuName;
		this.sbuHead = sbuHead;
		this.empList = empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public int getSbuId() {
		return sbuId;
	}
	public void setSbuId(int sbuId) {
		this.sbuId = sbuId;
	}
	public String getSbuName() {
		return sbuName;
	}
	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}
	public String getSbuHead() {
		return sbuHead;
	}
	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}
	@Override
	public String toString() {
		return "Sbu [sbuId=" + sbuId + ", sbuName=" + sbuName + ", sbuHead=" + sbuHead + ", empList=" + empList + "]";
	}

	

}
