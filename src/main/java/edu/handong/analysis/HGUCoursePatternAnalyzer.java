package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents=0;
	int numOfCourses=0;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		//임시로 받을 스트링 값 tempString
		String tempString[];
		tempString = new String[3];
		//임시로 저장할 tempStudent
		Student tempStudent;
		//return해주기 위한 임시 temp
		Student[] temp;
		temp = new Student[numOfStudents];
		for(int i=0;i<numOfStudents;i++)
			temp[i] = new Student("");
			
		//어레이안에 index를 위한 변수 i
		int i=0;
		for(String line : lines) {
			tempString = line.split(",");
			tempStudent = new Student(tempString[1].trim());
			if(studentExist(temp, tempStudent) == false) {
				temp[i] = tempStudent;
				i++;
				if(i == numOfStudents)
					break;
			}
		}
		return temp;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		//students array안에 아무것도 없을때
	      if(students[0] == null) 
	         return false;

	      for(Student exitStudent : students) {
	         if(exitStudent == null)
	            return true;
	         
	         if(exitStudent.getName().equals(student.getName()))
	            return true;
	      }
	      return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		String tempString[];
		tempString = new String[3];
		//임시로 저장할 tempStudent
		Course tempCourse;
		//return해주기 위한 임시 temp
		Course[] temp;
		temp = new Course[numOfCourses];
		for(int i=0;i<numOfCourses;i++)
			temp[i] = new Course("");
			
		//어레이안에 index를 위한 변수 i
		int i=0;
		for(String line : lines) {
			tempString = line.split(",");
			tempCourse = new Course(tempString[2].trim());
			if(courseExist(temp, tempCourse) == false) {
				temp[i] = tempCourse;
				i++;
				if(i == numOfCourses)
					break;
			}
		}
		return temp;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		//students array안에 아무것도 없을때
	      if(courses[0] == null) 
	         return false;

	      for(Course exitCourse : courses) {
	         if(exitCourse == null)
	            return true;
	         
	         if(exitCourse.getCourseName().equals(course.getCourseName()))
	            return true;
	      }
	      return false;
	}
}
