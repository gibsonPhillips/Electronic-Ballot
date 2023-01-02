import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Represents an Election 
 * @author Moet O'Donnell and Gibson Phillips
 *
 */

class ElectionData {
  LinkedList<String> ballot = new LinkedList<String>();
  LinkedList<String> votes = new LinkedList<String>();
  Scanner keyboard = new Scanner(System.in);
  
  HashMap<String, Integer > firstPlace = new HashMap<String, Integer>();
  HashMap<String, Integer > secPlace = new HashMap<String, Integer>();
  HashMap<String, Integer > thirdPlace = new HashMap<String, Integer>();
  
  ElectionData() {
    
  }
 
  /**
   * Stores a single voter's choices in the HashMap
   * @param firstCandi is the name of the first choice candidate
   * @param secCandi is the name of the second choice candidate
   * @param thirdCandi is the name of the third choice candidate
   * @throws DuplicateVotesException when the candidate that was voted for multiple times
   * @throws UnknownCandidateException when the candidate that was voted is not on the ballot
   */
  public void processVote(String firstCandi, String secCandi, String thirdCandi) throws DuplicateVotesException, UnknownCandidateException {
	if(!ballot.contains(firstCandi)) {
		throw new UnknownCandidateException(firstCandi);
	}
	if(!ballot.contains(secCandi)) {
		throw new UnknownCandidateException(secCandi);
	}
	if(!ballot.contains(thirdCandi)) {
		throw new UnknownCandidateException(thirdCandi);
	}
	if(firstCandi.equals(secCandi) || firstCandi.equals(thirdCandi)) {
		throw new DuplicateVotesException(firstCandi);
	}
	if(secCandi.equals(thirdCandi)) {
		throw new DuplicateVotesException(secCandi);
	}
		int votes1 = firstPlace.get(firstCandi) + 1;
		firstPlace.put(firstCandi, votes1);

		int votes2 = secPlace.get(secCandi) + 1;
		secPlace.put(secCandi, votes2);

		int votes3 = thirdPlace.get(thirdCandi) + 1;
		thirdPlace.put(thirdCandi, votes3);

  }
  
  
  /**
   * Adds a candidate to the ballot
   * @param candidate is the name of the candidate
   * @throws CandidateExistsException when a candidate already exists in the ballot
   */
  public void addCandidate(String candidate) throws CandidateExistsException {
	  if(ballot.contains(candidate)) {
	  throw new CandidateExistsException(candidate);
	  }
	  else {
		ballot.add(candidate);
		firstPlace.put(candidate, 0);
		secPlace.put(candidate, 0);
		thirdPlace.put(candidate, 0);
		}
	  }
  
  /**
   * Finds the winner with most first votes
   * @return the name of the candidate with more than 50% of first place votes.
   */
  
  public String findWinnerMostFirstVotes() {
	  int max = 0;
	  int total = 0;
	  String winner = "";
	  for(String v : ballot) {
		  total++;
		  if(firstPlace.get(v) > max) {
			  max=firstPlace.get(v);
			  winner = v;
			  }
		  }
	  if((double)max/total > 0.5) {
		  return winner;
		  }
	  else {
		  return "Runoff Required";
		  }
	  }
	  
  
  /**
   * Finds the winner which is the candidate with the most points (1st place 3pts, 2nd place 2pts, 3rd place 1pt)
   * @return the winner with the most points
   */
  public String findWinnerMostPoints() {
	  int max = 0;
	  String winner = "";
	  for(String v: ballot) {
		  int points = (firstPlace.get(v) * 3) + (secPlace.get(v) * 2) + (thirdPlace.get(v) * 1);
		  if(points > max) {
			  max = points;
			  winner = v;
			  }
		  }
	  return winner;
	  }
  }

