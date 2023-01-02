
/**
 * Represents an exception when the candidate that was voted is not on the ballot
 * @author  Moet O'Donnell and Gibson Phillips
 *
 */

public class UnknownCandidateException extends Exception {
	
	private String name;
	
	public UnknownCandidateException(String name) {
		this.name = name;
	}
	
	/*
	 * Gets the name of the unknown candidate's name
	 */
	public String getName() {
		return this.name;
	}	
}
