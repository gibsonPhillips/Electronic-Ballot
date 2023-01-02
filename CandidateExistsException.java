
/**
 * Represents an exception when a candidate already exists in the ballot
 * @author  Moet O'Donnell and Gibson Phillips
 *
 */

public class CandidateExistsException extends Exception{

	private String name;
	
	public CandidateExistsException(String name) {
		this.name = name;
	}

	/*
	 * Gets the name of the candidate's name that already exists
	 */
	public String getName() {
		return name;
	}

	
}
