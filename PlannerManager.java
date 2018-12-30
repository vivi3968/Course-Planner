/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 1
 * CSE214, R11 (Reed Gantz)
 */ 

import java.util.Scanner;

public class PlannerManager {
	
	/**
	 * Method prints the menu given to user
	 */
	public static void menu() {
		System.out.println("(A) Add Course");
		System.out.println("(G) Get Course");
		System.out.println("(R) Remove Course");
		System.out.println("(P) Print Courses in Planner");
		System.out.println("(F) Filter by Department Code");
		System.out.println("(L) Look for Course");
		System.out.println("(S) Size");
		System.out.println("(B) Backup");
		System.out.println("(PB) Print Courses in Backup");
		System.out.println("(RB) Revert to Backup");
		System.out.println("(Q) Quit");
		System.out.println();
		System.out.print("Enter a selection: ");
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);

		Course course;
		Planner p = new Planner();
		Planner p1 = (Planner) p.clone();
		String letter;
		
		do {
			input = new Scanner(System.in);

			menu();
			
			letter = input.nextLine();
			letter = letter.toUpperCase();
			
			if (letter.equals("A")) {
				
				System.out.print("Enter course name: ");
				String course1 = input.nextLine();
				System.out.print("Enter department: ");
				String department = input.nextLine();
				System.out.print("Enter course code: ");
				int code = input.nextInt();
				System.out.print("Enter course section: ");
				byte section = input.nextByte();
				System.out.print("Enter instructor: ");
				String ins = in.nextLine();
				System.out.print("Enter position: ");
				int pos = input.nextInt();
				System.out.println();
				
				course = new Course(course1, department, code, section, ins);
				try {
					p.addCourse(course, pos - 1);
				} catch (IllegalArgumentException | NullPointerException | FullPlannerException ex) {
					System.out.println("Invalid range for position");
				}
				
				if (p.exists(course) && (pos >= 1 && pos <= p.size)) 
					System.out.println(department + " " + code + ".0" + section + " successfully added to planner");
				System.out.println();
	
			}
			
			else if (letter.equals("G")) {
				System.out.print("Enter position: ");
				int pos = input.nextInt();
				
				try {
					if (pos == 1) {
						System.out.println();
						System.out.println("No.\tCourse Name\t\tDepartment\tCode\t   Section\tInstructor");
						System.out.println("-------------------------------------------------------------------------------------");
						String str = String.format("%-8d%-28s%-13s%-15d%-8d%-20s", (pos), p.list[0].getCourseName(), p.list[0].getDepartment(), 
								p.list[0].getCode(), p.list[0].getSection(), p.list[0].getInstructor());
						System.out.println(str);
						System.out.println();
					}
					else {
					Course a = (p.getCourse(pos-1));
					System.out.println("No.\tCourse Name\t\tDepartment\tCode\t   Section\tInstructor");
					System.out.println("-------------------------------------------------------------------------------------");
					String str = String.format("%-8d%-28s%-13s%-15d%-8d%-20s", (pos), a.getCourseName(), a.getDepartment(), 
							a.getCode(), a.getSection(), a.getInstructor());
					System.out.println(str);
					System.out.println();
					}
				} catch (IllegalArgumentException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
					System.out.println();
					System.out.println("Invalid range for position");
					System.out.println();
				}
			}
			
			else if (letter.equals("R")) {
				System.out.print("Enter position: ");
				int pos = input.nextInt();
				System.out.println();
				try {
					if (p.size == 1) {
						String s = (p.list[0].getDepartment() + " " + p.list[0].getCode() + 
								".0" + p.list[0].getSection() + " has been successfully removed from planner.");
						p.list[0] = null;
						p.size--;
						System.out.println(s);
					}
					else {
						String s = (p.list[pos-1].getDepartment() + " " + p.list[pos-1].getCode() + 
								".0" + p.list[pos-1].getSection() + " has been successfully removed from planner.");
					p.removeCourse(pos-1);
					System.out.println(s);
					System.out.println();
					}
							
				} catch (IllegalArgumentException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
					System.out.println();
					System.out.println("Invalid range for position");
					System.out.println();
				}
			}
			
			else if (letter.equals("P")) {
				System.out.println();
				System.out.println("Planner: ");
				p.toString();
				System.out.println();
			}
						
			else if (letter.equals("F")) {
				p1 = (Planner) p.clone();
				System.out.print("Enter department code: ");
				String department = input.next();
				System.out.println();
				p1.filter(p, department);
				System.out.println();
			}
			
			
			else if (letter.equals("L")) {
				
				System.out.print("Enter course name: ");
				String course1 = input.nextLine();
				System.out.print("Enter department: ");
				String department = input.nextLine();
				System.out.print("Enter course code: ");
				int code = input.nextInt();
				System.out.print("Enter course section: ");
				byte section = input.nextByte();
				System.out.print("Enter instructor: ");
				String ins = in.nextLine();
				
				Course jk = new Course(course1, department, code, section, ins);
				System.out.println();
				
				for (int i = 0; i < p.size; i++) {
					if (p.list[i].getCourseName().equals(jk.getCourseName())) {
						if (p.list[i].getDepartment().equals(jk.getDepartment())) {
							System.out.println("i");
							if (p.list[i].getCode() == (jk.getCode())) {
								if (p.list[i].getSection() == (jk.getSection())) {
									if (p.list[i].getInstructor().equals(jk.getInstructor())) {
										System.out.println(department + " " + code + ".0" + section + " is found at position " + (i+1));
										System.out.println();

									}
								}
							}
						}
					}
				}
			}
				
			
			else if (letter.equals("S")) {
				System.out.println();
				if (p.size == 1)
					System.out.println("There is " + p.size + " course in the planner.");
				else 
					System.out.println("There are " + p.size + " courses in the planner.");

				System.out.println();
			}
			
			else if (letter.equals("B")) {
				System.out.println();
				p1 = (Planner) p.clone();				
				System.out.println("Created a backup of of the current planner");
				System.out.println();
				
			}
			
			else if (letter.equals("PB")) {
				System.out.println();
				System.out.println("Planner (Backup): ");
				p1.printAllCourses();	
				System.out.println();

			}
		
			else if (letter.equals("RB")) {
				System.out.println();
				p = p1;
				System.out.println("Planner successfully reverted to the backup copy.");
				System.out.println();
			}
			
			else if (letter.equals("Q")) {
				System.out.println();
				System.out.println("Program terminating successfully...");
				System.exit(0);
			}
			
			else {
				System.out.println();
				System.out.println("Incorrect input. Try again.");
				System.out.println();
			}

		} while (letter != ("Q"));
			
		}
	
}
	
	