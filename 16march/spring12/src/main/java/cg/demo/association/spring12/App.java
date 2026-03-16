package cg.demo.association.spring12;
import cg.demo.association.spring12.beans.Employee;
import cg.demo.association.spring12.beans.Sbu;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ApplicationContext ac = new ClassPathXmlApplicationContext("springconfig1.xml");
        Employee emp = (Employee) ac.getBean("emp1");
        Sbu e = (Sbu) ac.getBean("sbu");
        List<Employee> c = e.getEmpList();
        int size = c.size();
        for (int i = 0; i < size; i++) {
        	if(c.get(i).getEmployeeId()==101) {
				System.out.println(c.get(i));
			}
			
        }
        
        
        System.out.println(e.getEmpList());
    }
   
}
