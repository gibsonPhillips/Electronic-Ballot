
/**
 * Represents an exception when the candidate that was voted for multiple times
 * @author  Moet O'Donnell and Gibson Phillips
 *
 */

public class DuplicateVotesException extends Exception {

	private String name;
	
	public DuplicateVotesException(String name) {
		this.name = name;
	}

	/*
	 * Gets the name of the duplicated candidate's name
	 */
	public String getName() {
		return this.name;
	}	
	
}
