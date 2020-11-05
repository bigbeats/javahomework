package test;
import java.util.*;
public class ReCourse { 
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Course course = new Course("A");
		System.out.println("输入选择A课的学生个数");
		int number=input.nextInt();
		System.out.println("请输入选了A课的学生姓名，一共"+number+"人");
		for(int i=0;i<number;i++) {
			String studentName=input.next();
			course.addStudent(studentName);
		}
		input.close();
		Course newcourse = new Course("B");
		newcourse = course.studentsClone("B");
		System.out.print("选择B课的同学是\n");
		for(int i=0;i<newcourse.getNumberOfStudents();i++)
			System.out.print(newcourse.getStudents()[i]+"\n");
	}

}
class Course{ // 同书上代码
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;
	public Course(String courseName) {
		this.courseName = courseName;
	}
	public void addStudent(String student) {
		students[numberOfStudents] = student;
		numberOfStudents++;
	}
	public String[] getStudents(){
		return students;
	}
	public int getNumberOfStudents(){
		return numberOfStudents;
	}
	public String getCourseName(){
		return courseName;
	}
	public Course studentsClone(String courseName) {
		Course newcourse=new Course(courseName); // 深度复制
		for(int i=0;i<numberOfStudents;i++) {
			newcourse.addStudent(students[i]);
		}
		return newcourse;
	}
}
