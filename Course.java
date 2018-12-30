public class Course implements Cloneable {
	/**
	 *  Course contains general information such as course name, course code, course section, instructor, etc
	 */
	
	private String course;
	private String department;
	private int code;
	private byte section;
	private String instructor;
	
	public Course() {}
	
	/**
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
	 * @return name of course
	 */
	public String getCourseName() {
		return course;
	}
	
	/**
	 * @param course name of course
	 */
	public void setCourseName(String course) {
		this.course = course;
	}
	
	/**
	 * @return name of department
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * @param department name of department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * @return number for code
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * @param code number for code
	 */
	public void setCode(int code) {
		if (code >= 0) 
			this.code = code;
		else
			System.out.println("Error: input is negative");
	}
	
	/**
	 * @return section number 
	 */
	public byte getSection() {
		return section;
	}
	
	/**
	 * @param section number for section
	 */
	public void setSection(byte section) {
		if (section >= 0)
			this.section = section;
		else
			System.out.println("Error: input is negative");
	}
	
	/**
	 * @return name of instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	
	/**
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
