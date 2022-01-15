package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = ctx.getBean("studentDao",StudentDao.class);
//        Student student = new Student(112,"Poonam","Hindaun");
//        int i= studentDao.insert(student);
//        System.out.println("Student inserted"+i);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean go = true;
        while(go) {
        	System.out.println("Press 1 for add new Student:");
            System.out.println("Press 2 for display all the Student:");
            System.out.println("Press 3 for display single Student:");
            System.out.println("Press 4 for delete the Student:");
            System.out.println("Press 5 for update the Student:");
            System.out.println("Press 6 for Exit:");
            
            try {
            	int input = Integer.parseInt(br.readLine());
//            	if (input == 1) {
//            		// add a student
//            	} else if{
//            		//display all
//            	} else if{
//            		//display single
//            	} else if{
//            		// delete
//            	}
            	switch(input) {
            	case 1:
            		System.out.print("Please enter student id: ");
            		int id = Integer.parseInt(br.readLine());
            		System.out.print("Please enter student Name: ");
            		String name = br.readLine();
            		System.out.print("Please enter student City: ");
            		String city = br.readLine();
            		Student student = new Student(id,name,city);
            		int i= studentDao.insert(student);
            		System.out.println("Student inserted"+i);

            		break;
            	case 2:
            		List<Student> allStudents = studentDao.getAllStudents();
            		for(Student st:allStudents) {
            		System.out.println("Id :"+st.getStudentId());
            		System.out.println("Name :"+st.getStudentName());
            		System.out.println("City :"+st.getStudentCity());
            		}
            		break;
            	case 3:
            		System.out.println("Please enter the Id of student you want to see ");
            		int sId = Integer.parseInt(br.readLine());
            		Student student2 = studentDao.getStudent(sId);
            			System.out.println("Id :"+student2.getStudentId());
                		System.out.println("Name :"+student2.getStudentName());
                		System.out.println("City :"+student2.getStudentCity());
            		
            		break;
            	case 4:
            		System.out.println("Please enter the Id of student you want to see ");
            		int stId = Integer.parseInt(br.readLine());
            		studentDao.deleteStudent(stId);
            		break;
            	case 5:
            		System.out.println("Please enter the Id of student you want to update ");
            		int stdId = Integer.parseInt(br.readLine());
            		System.out.print("Please enter student Name: ");
            		String nm = br.readLine();
            		System.out.print("Please enter student City: ");
            		String cty = br.readLine();
            		Student student5 = new Student(stdId,nm,cty);
            		studentDao.updateStudent(student5);


            		break;
            	case 6:
            		go = false;
            	}
			} catch (Exception e) {
				System.out.println("Invalid option try with another option");
				System.out.println(e.getMessage());
			}
        }
        System.out.println("Thank you for using my program!");
        System.out.println("See you soon.");
                
    }
} 
