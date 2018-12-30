/* Vivian Lam
 * ID: 111549991
 * vivian.lam@stonybrook.edu
 * Homework 1
 * CSE214, R11 (Reed Gantz)
 */ 

/**
 * Exception for when Planner is full
 */
public class FullPlannerException extends Exception {
	/**
	 * Constructor for FullPlannerException that takes no parameters
	 */
	public FullPlannerException() {
		super("Planner is full");
	}
	
	/**
	 * @param message 
	 */
	public FullPlannerException(String message) {
		super(message);
		}
}