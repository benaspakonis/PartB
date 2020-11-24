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
		Student student = new Student("Johnny Smith", new DateTime(1999,5,26,0,0));
		
		List<Student> students = new ArrayList<Student>();
		students.add(student);
		
		Module module = new Module("CT401",students);
		
		List<Module> modules = new ArrayList<Module>();
		modules.add(module);
		
		DateTime startDate = new DateTime(2020,9,03,0,0);
		DateTime endDate = new DateTime(2020,12,3,0,0);
		
		Course course = new Course("CSIT",modules,students,startDate,endDate);
		
		student.addModule(module);
		student.addCourse(course);
		
		printStudentInfo(student);
		printModuleInfo(module);
		printCourseInfo(course);
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
