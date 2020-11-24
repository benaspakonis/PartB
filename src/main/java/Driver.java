import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import university.Course;
import university.Student;
import university.Module;

public class Driver {
	
	private static String NAME = "Name";
	private static String AGE = "Age";
	private static String NEW_LINE = "\n";
	private static String COLON = " : ";
	private static String USERNAME = "Username";
	private static String DOB = "Date of Birth";
	private static String COURSES = "Courses";
	private static String MODULES = "Modules";
	private static String TITLE = "Title";
	private static String STUDENTS = "Students";
	private static String OPENING_BRACKET = "[";
	private static String CLOSING_BRACKET = "]";
	private static String START_DATE = "Starting date";
	private static String END_DATE = "Ending date";
	private static String STUDENT_INFO = "STUDENT INFO";
	private static String MODULE_INFO = "MODULE INFO";
	private static String COURSE_INFO = "COURSE INFO";
	private static String LINE_BREAK = "-----------------------------";
	
	public static void main(String args[]) {
		List<Student> allStudents = new ArrayList<Student>();
		List<Module> allModules = new ArrayList<Module>();
		List<Course> allCourses = new ArrayList<Course>();
		
		//CSIT Students
		Student student1 = new Student("Johnny Smith", new DateTime(1999,5,26,0,0));
		Student student2 = new Student("Helen Walsh", new DateTime(1997,8,14,0,0));
		Student student3 = new Student("Jim O'Neil", new DateTime(1998,1,5,0,0));
		
		List<Student> csitStudents = new ArrayList<Student>();
		csitStudents.add(student1);
		csitStudents.add(student2);
		csitStudents.add(student3);
		
		//ECE Students
		Student student4 = new Student("Sarah Philips", new DateTime(1999,6,21,0,0));
		Student student5 = new Student("Amy Robinson", new DateTime(2000,11,25,0,0));
		
		List<Student> eceStudents = new ArrayList<Student>();
		eceStudents.add(student4);
		eceStudents.add(student5);
		
		allStudents.add(student1);
		allStudents.add(student2);
		allStudents.add(student3);
		allStudents.add(student4);
		allStudents.add(student5);
		
		
		Module module1 = new Module("CT401",allStudents);	//CSIT Module
		Module module2 = new Module("CT402",allStudents);	//CSIT & ECE Module
		Module module3 = new Module("CT3001",allStudents);	//ECE Module
		
		//Adding Modules to Students
		//CSIT Students
		student1.addModule(module1);
		student1.addModule(module2);
		student2.addModule(module1);
		student2.addModule(module2);
		student3.addModule(module1);
		student3.addModule(module2);
		
		//ECE Students
		student4.addModule(module2);
		student4.addModule(module3);
		student5.addModule(module2);
		student5.addModule(module3);
		
		allModules.add(module1);
		allModules.add(module2);
		allModules.add(module3);
		
		DateTime startDate = new DateTime(2020,9,03,0,0);
		DateTime endDate = new DateTime(2020,12,3,0,0);
		
		Course course1 = new Course("CSIT",allModules,allStudents,startDate,endDate);
		Course course2 = new Course("ECE",allModules,allStudents,startDate,endDate);
		
		//Adding Modules to Courses
		course1.addModule(module1);
		course1.addModule(module2);
		course2.addModule(module2);
		course2.addModule(module3);
		
		//Adding Students To Courses
		course1.addStudent(student1);
		course1.addStudent(student2);
		course1.addStudent(student3);
		
		course2.addStudent(student4);
		course2.addStudent(student5);
		
		//Adding Courses To Modules
		module1.addCourse(course1);
		module2.addCourse(course1);
		module2.addCourse(course2);
		module3.addCourse(course2);
		
		allCourses.add(course1);
		allCourses.add(course2);
		
		//Adding Course To Students
		student1.addCourse(course1);
		student2.addCourse(course1);
		student3.addCourse(course1);
		student4.addCourse(course2);
		student5.addCourse(course2);
		
		for(int i = 0; i < allStudents.size();i++) {
			printStudentInfo(allStudents.get(i));
		}
		
		for(int i = 0; i < allModules.size();i++) {
			printModuleInfo(allModules.get(i));
		}
		
		for(int i = 0; i < allCourses.size();i++) {
			printCourseInfo(allCourses.get(i));
		}
	
	}
	
	public static void printStudentInfo(Student student) {
		String info = STUDENT_INFO + NEW_LINE + LINE_BREAK + NEW_LINE + NAME + COLON + student.getName() + NEW_LINE + AGE + COLON + student.getAge() +  NEW_LINE + USERNAME + COLON  + student.getUsername() + NEW_LINE + DOB + COLON + student.getDOB() + NEW_LINE + COURSES + COLON + OPENING_BRACKET + NEW_LINE;
			for(int i = 0; i < student.getCourse().size();i++) {
				info = info + student.getCourse().get(i).getName() + NEW_LINE;
			}
		info = info + CLOSING_BRACKET + NEW_LINE + MODULES + COLON + OPENING_BRACKET + NEW_LINE;
			for(int i = 0; i < student.getModules().size();i++) {
				info = info + student.getModules().get(i).getName() + NEW_LINE;
			}
		info = info + CLOSING_BRACKET + NEW_LINE + NEW_LINE;
		System.out.print(info);
	}
	
	public static void printModuleInfo(Module module) {
		String info = MODULE_INFO + NEW_LINE + LINE_BREAK + NEW_LINE + TITLE + COLON + module.getName() + NEW_LINE + COURSES + module.getCourses() + NEW_LINE + STUDENTS + COLON + OPENING_BRACKET + NEW_LINE;
			for(int i = 0; i < module.getStudents().size();i++) {
				info = info + module.getStudents().get(i).getUsername() + NEW_LINE;
			}
		info = info + CLOSING_BRACKET + NEW_LINE + NEW_LINE;
		System.out.print(info);
	}
	
	public static void printCourseInfo(Course course) {
		String info = COURSE_INFO + NEW_LINE + LINE_BREAK + NEW_LINE + NAME + COLON + course.getName() + NEW_LINE + START_DATE + COLON + course.getStartDate() + NEW_LINE + END_DATE + COLON + course.getEndDate() + NEW_LINE + MODULES + COLON + OPENING_BRACKET + NEW_LINE;
			for(int i = 0; i < course.getModules().size();i++) {
				info = info + course.getModules().get(i).getName() + NEW_LINE;
			}
		info = info + CLOSING_BRACKET + NEW_LINE + STUDENTS + COLON + OPENING_BRACKET + NEW_LINE;
			for(int i = 0; i < course.getStudents().size();i++) {
				info = info + course.getStudents().get(i).getUsername() + NEW_LINE;
			}	
		info = info + CLOSING_BRACKET + NEW_LINE + NEW_LINE;
		System.out.print(info);
	}
}
