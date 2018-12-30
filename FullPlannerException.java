/**
 * Exception for when Planner is full
 */
public class FullPlannerException extends Exception {
	
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
