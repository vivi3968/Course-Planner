/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 1
 * CSE214, R11 (Reed Gantz)
 */ 

public class Course implements Cloneable {
	/**
	 *  Course contains general information such as course name, course code, course section, instructor, etc.
	 *  Accessor and mutator methods have been provided.
	 */
	
	private String course;
	private String department;
	private int code;
	private byte section;
	private String instructor;
	
	/**
	 * Constructor for course
	 */
	public Course() {}
	
	/**
	 * Constructor for course with parameters
	 * 
	 * @param course name of course
	 * @param department name of department
	 * @param code number for code
	 * @param section number of section 
	 * @param instructor name of instructor
	 */
	public Course(String course, String department, int code, byte section, String instructor) {
		this.course = course;
		this.department = department;
		this.code = code;
		this.section = section;
		this.instructor = instructor;	
	}
	
	/**
	 * Accessor method for course name
	 * 
	 * @return name of course
	 */
	public String getCourseName() {
		return course;
	}
	
	/**
	 * Mutator method for course name
	 * 
	 * @param course name of course
	 */
	public void setCourseName(String course) {
		this.course = course;
	}
	
	/**
	 * Accessor method for department
	 * 
	 * @return name of department
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * Mutator method for department
	 * 
	 * @param department name of department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * Accessor method for code
	 * 
	 * @return number for code
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * Mutator method for code
	 * 
	 * @param code number for code
	 */
	public void setCode(int code) {
		if (code >= 0) 
			this.code = code;
		else
			System.out.println("Error: input is negative");
	}
	
	/**
	 * Accessor method for section 
	 * 
	 * @return section number 
	 */
	public byte getSection() {
		return section;
	}
	
	/**
	 * Mutator method for section
	 * 
	 * @param section number for section
	 */
	public void setSection(byte section) {
		if (section >= 0)
			this.section = section;
		else
			System.out.println("Error: input is negative");
	}
	
	/**
	 * Accessor method for instructor
	 * 
	 * @return name of instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	
	/**
	 * Mutator method for instructor
	 * 
	 * @param instructor name of instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/** 
	 * Method indicates whether or not obj has the same attributes as this Course
	 * 
	 * @param obj Object
	 * @return value of true indicates that obj refers to a Course object with the same attributes as this Course. Otherwise, return is false
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Course) {
			return course == ((Course) obj).course && department == ((Course) obj).department && 
					code == ((Course) obj).code && section == ((Course) obj).section && instructor == ((Course) obj).instructor;
		}
		return false;
	}
	
	/** 
	 * Method makes a copy of this course
	 * 
	 * @return copy of this course
	 */
	public Object clone() { 
		try {
			Course c = (Course)(super.clone());
		return c;
		} catch (CloneNotSupportedException ex) {
			return null;
		}
		
	}
	

}
