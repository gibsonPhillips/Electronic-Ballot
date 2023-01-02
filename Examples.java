import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Moet O'Donnell and Gibson Phillips
 *
 */

public class Examples {

	// method to set up a ballot and cast votes

	  ElectionData Setup1 () {

	    ElectionData ED = new ElectionData();
	  
	    // put candidates on the ballot
	    try {

	       ED.addCandidate("gompei");
	       ED.addCandidate("husky");
	       ED.addCandidate("ziggy");

	    } catch (Exception e) {}

	    // cast votes

	    try {

	      ED.processVote("gompei", "husky", "ziggy");
	      ED.processVote("gompei", "ziggy", "husky");
	      ED.processVote("husky", "gompei", "ziggy");

	    } catch (Exception e) {}

	    return(ED);
	  }
	  
	  ElectionData Setup2 () {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");

		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("gompei", "husky", "ziggy");
		      ED.processVote("gompei", "ziggy", "husky");
		      ED.processVote("husky", "gompei", "ziggy");
		      ED.processVote("husky", "gompei", "ziggy");

		    } catch (Exception e) {}

		    return(ED);
		  }
	  
	  ElectionData Setup3 () {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");


		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("gompei", "husky", "ziggy");
		      ED.processVote("ziggy", "gompei", "husky");
		      ED.processVote("husky", "gompei", "ziggy");
		     

		    } catch (Exception e) {}

		    return(ED);
		  }
	  
	  ElectionData Setup4 () {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");


		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("gompei", "husky", "ziggy");
		      ED.processVote("ziggy", "ziggy", "husky");
		      ED.processVote("husky", "gompei", "ziggy");
		     

		    } catch (Exception e) {}

		    return(ED);
		   
		  }
	  
	  ElectionData SetupTiePoints () {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");


		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("gompei", "husky", "ziggy");
		      ED.processVote("husky", "gompei", "ziggy");
		     

		    } catch (Exception e) {}

		   // VotingMachine VM = new VotingMachine(ED);
		    return(ED);
		   
		  }

	  // now run a test on a specific election
	  @Test
	  public void testMostFirstWinner () {
	    assertEquals ("gompei", Setup1().findWinnerMostFirstVotes());
	  }
	  
	  @Test
	  public void testMostFirstWinnerWhenThereIsTie () {
	    assertEquals ("gompei", Setup2().findWinnerMostFirstVotes());
	  }
	  
	  @Test
	  public void testMostFirstWinnerWhenNoMoreThan50Percent () {
	    assertEquals ("Runoff Required", Setup3().findWinnerMostFirstVotes());
	  }
	  
	  
	  @Test(expected=DuplicateVotesException.class)
	  public void testDuplicateVotesException() throws DuplicateVotesException
	  {
			try {
				Setup4().processVote("ziggy", "ziggy", "husky");
			} catch (UnknownCandidateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  
	  @Test(expected=UnknownCandidateException.class)
	  public void testUnknownCandidateException() throws UnknownCandidateException
	  {
			try {
				Setup4().processVote("ziggy", "zig", "husky");
			} catch (DuplicateVotesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  
	  @Test(expected=CandidateExistsException.class)
	  public void testCandidateExistsException() throws CandidateExistsException
	  {
		Setup4().addCandidate("ziggy");
	}
	  
	  @Test
	  public void testMostFirstWinnerMostPoints () {
	    assertEquals ("gompei", Setup1().findWinnerMostPoints());
	  }
	  
	  @Test
	  public void testMostFirstWinnerMostPointsTie () {
	    assertEquals ("gompei", SetupTiePoints().findWinnerMostPoints());
	  }

}
	  

