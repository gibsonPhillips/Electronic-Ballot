
/**
 * Represents a voting machine
 * @author Moet O'Donnell and Gibson Phillips
 *
 */

public class VotingMachine {
	
	ElectionData data;
	
	public VotingMachine(ElectionData data) {
		this.data = data;
	}

	
	/**
	 * Prints out who the candidates are
	 */
	public void printBallot() {
	    System.out.println("The candidates are ");
	    for (String s : this.data.ballot) {
	      System.out.println(s);
	    }
	  }
	
	
	/**
	 * Takes in the votes from user
	 * Try/Catch the process votes (UnknownCandidateException and DuplicateVotesException)
	 */
	public void screen() {
	    this.printBallot();
	    System.out.println("Who do you want to vote for?");
	    System.out.print("First Choice: ");
	    String firstChoice = this.data.keyboard.next();
	    this.data.votes.add(firstChoice);
	   
	    System.out.print("Second Choice: ");
	    String secChoice = this.data.keyboard.next();
	    this.data.votes.add(secChoice);
	    
	    System.out.print("Third Choice: ");
	    String thirdChoice = this.data.keyboard.next();
	    this.data.votes.add(thirdChoice);
	    System.out.println("You voted for " + firstChoice + secChoice + thirdChoice);
	   
	    
	    try {
	    	data.processVote(firstChoice, secChoice, thirdChoice);
	    }
	    catch (UnknownCandidateException e) {
	    	System.out.println("Would you like to add the candidate's name to the ballot?");
	    	String y = this.data.keyboard.next();
	    	if(y.equals("Y") || y.equals("y")) {
	    		String addCandidate = this.data.keyboard.next();
	    		addWriteIn(addCandidate);
	    		this.screen();
	    }
	    	else {
	    		this.screen();
	    	}
	    }
	    
	    catch (DuplicateVotesException e) {
	    	System.out.println("You cannot vote for the same candidate twice");
	    	this.screen();
	    }
	    	
	  }
	
	
	/**
	 * Allows voter to add the candidate's name to the ballot.
	 * @param candidate is the name of the candidate
	 */
	
	public void addWriteIn(String candidate) {
		try {
			data.addCandidate(candidate);
			System.out.println("Candidate was added successfully");
		}
		catch (CandidateExistsException e) {
			System.out.println("Candidate already exists");
		}
	}
	
}
