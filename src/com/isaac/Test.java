package com.isaac;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
		/*
		 * int status=dao.saveEmployee(new Employee(102,"Amit",35000));
		 * System.out.println(status);
		 */
		/*int status=dao.updateEmployee(new Employee(102,"Sonoo",15000));
		System.out.println(status);
		*/
		
		/*Employee e=new Employee();
		e.setId(102);
		int status=dao.deleteEmployee(e);
		System.out.println(status);*/
		
		//EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
		/*
		 * dao.saveEmployeeByPreparedStatement(new Employee(120,"bill",375000));
		 */
		
		 List<Employee> list=dao.getAllEmployees();  
         
		    for(Employee e:list)  
		        System.out.println(e);  
	}

}
