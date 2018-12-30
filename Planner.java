/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 1
 * CSE214, R11 (Reed Gantz)
 */ 
public class Planner extends Course {
	/**
	 * Planner stores an ordered list of course objects
	 */
	
	public static final int MAX_COURSES = 50;
	public int size;
	public Course[] list;
	
	/**
	 * Constructs an instance of the Planner with no Course objects in it.
	 */
	public Planner() {
		size = 0;
		list = new Course[MAX_COURSES];
	}
	
	/**
	 * Method determines the number of courses currently in the list.
	 * 
	 * @return size of list
	 */
	public int size() {
		return size;
	}
	 
	/**
	 * Method inserts a new course at position
	 * 
	 * @param newCourse the new course to add to the list
	 * @param position the position (preference) of this course on the list
	 * @throws IllegalArgumentException if position is negative 
	 * @throws FullPlannerException when size exceeds maximum size os list
	 */
	public void addCourse(Course newCourse, int position) throws IllegalArgumentException, FullPlannerException { 
		if (position < 0) 
			throw new IllegalArgumentException("Invalid range for position");
		for (int i = size-1; i > position-1; i--) {
				list[i+1] = list[i];
		}
		list[position] = newCourse;
		size++;
		
		if (size > 50)
		throw new FullPlannerException("Planner is full");
	}

	/**
	 * Method inserts new course at end
	 * 
	 * @param newCourse the new course to add to the list
	 * @throws FullPlannerException when size exceeds maximum number of courses
	 */
	public void addCourse(Course newCourse) throws FullPlannerException {
		if (size > MAX_COURSES)
			throw new FullPlannerException("Planner is full");
		else
			list[size++] = newCourse;
	}
	
	/**
	 * Method removes a course at position
	 * 
	 * @param position the position in the Planner where the Course will be removed from.
	 * @throws IllegalArgumentException if position is negative or exceeds maximum size of list
	 * @throws ArrayIndexOutOfBoundsException if position is in an invalid range
	 */
	public void removeCourse(int position) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
		Course[] temp = new Course[size];
		int j = 0;
		for (int i = 0; i <= size; i++) {
			if (i != position)
				temp[j++] = list[i];
		}
		list = temp;
		size--;
	}
	
	/**
	 * Method retrieves a course at position
	 * 
	 * @param position position of the Course to retrieve.
	 * @return the Course at the specified position in this Planner object.
	 * @throws IllegalArgumentException if position is negative 
	 */
	public Course getCourse(int position) throws IllegalArgumentException {
		if (position < 0 | position > MAX_COURSES) 
			throw new IllegalArgumentException("Invalid range for position");
		else if (position >= 1 && position <= size + 1) {
			for (int i = 0; i < size +1; i++)
				if (i == position )
					break;
			return list[position];
		}
		else 
			throw new IllegalArgumentException("Invalid range for position");
	}
	
	/** 
	 * Method prints all Courses that are within the specified department.
	 * 
	 * @param planner the list of courses to search in 
	 * @param department the 3 letter department code for a Course
	 */
	public static void filter(Planner planner, String department) {
		System.out.println("No.\tCourse Name\t\tDepartment\tCode\t   Section\tInstructor");
		System.out.println("-------------------------------------------------------------------------------------");
	
		Course c;
		for (int i = 0; i < planner.size; i++) {
			c = planner.list[i];
			if (c.getDepartment().equals(department))
				System.out.println(String.format("%-8d%-28s%-13s%-15d%-8d%-20s", (i+1), c.getCourseName(), c.getDepartment(), 
						c.getCode(), c.getSection(), c.getInstructor()));
		}
		
	}
	
	/**
	 * Method checks whether a certain Course is already in the list.
	 * 
	 * @param course the Course we are looking for
	 * @return True if the Planner contains this Course, false otherwise.
	 */
	public boolean exists(Course course) {
		for (int i = 0; i < size + 1; i++) {
			if (list[i] == (course))
				return true;
		}
		return false;
	}
	
	/** 
	 * Method creates a copy of this Planner. Subsequent changes to the copy will not affect the original and vice versa.
	 * 
	 * @return a copy (backup) of this Planner object.
	 */
	public Object clone() {
		
		Planner p1 = new Planner();
		try {
			for (int i =0; i < size; i++) {
				Course newc = new Course(list[i].getCourseName(), list[i].getDepartment(), list[i].getCode(),
						list[i].getSection(), list[i].getInstructor());
				p1.addCourse(newc);
			}
		} catch (FullPlannerException ex) {
			System.out.println("Planner is full");
		}
		return p1;
	}
	
	
	/**
	 * Method prints a neatly formatted table of each item in the list with its position number 
	 */
	public void printAllCourses() {
		toString();
	}
	
	/** 
	 * Method gets the String representation of this Planner object, which is a neatly formatted table of each Course in the Planner on its own line with its position number 
	 * 
	 * @return the String representation of this Planner object.
	 */
	public String toString() {
		System.out.println("No.\tCourse Name\t\tDepartment\tCode\t   Section\tInstructor");
		System.out.println("-------------------------------------------------------------------------------------");
		String str = "";
		String s = "";

		for (int i = 0; i < size; i++) {
			str = String.format("%-8d%-28s%-13s%-15d%-8d%-20s", (i+1), list[i].getCourseName(), list[i].getDepartment(), list[i].getCode(), 
					list[i].getSection(), list[i].getInstructor());
			System.out.println(str);
		}
	
		return s;
	}
}
	
