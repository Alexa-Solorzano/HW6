
/******************************************************************
 *
 *  Alexa Solorzano COMP 272 001
 *
 *   This java file contains the problem solutions for the methods lastBoulder,
 *   showDuplicates, and pair methods. You should utilize the Java Collection
 *   Framework for these methods.
 *
 ********************************************************************/

import java.util.*;
import java.util.PriorityQueue;

public class ProblemSolutions {

    /**
     * Priority Queue (PQ) Game
     *
     * PQ1 Problem Statement:
     * -----------------------
     *
     * You are given an array of integers of boulders where boulders[i] is the
     * weight of the ith boulder.
     *
     * We are playing a game with the boulders. On each turn, we choose the heaviest
     * two boulders and smash them together. Suppose the heaviest two boulders have
     * weights x and y. The result of this smash is:
     *
     *    If x == y, both boulders are destroyed, and
     *    If x != y, the boulder of weight x is destroyed, and the boulder of
     *               weight y has new weight y - x.
     *
     * At the end of the game, there is at most one boulder left.
     *
     * Return the weight of the last remaining boulder. If there are no boulders
     * left, return 0.
     *
     *
     * Example 1:
     *
     * Input: boulders = [2,7,4,1,8,1]
     * Output: 1
     * Explanation:
     * We combine 7 and 8 to get 1 so the list converts to [2,4,1,1,1] then,
     * we combine 2 and 4 to get 2 so the list converts to [2,1,1,1] then,
     * we combine 2 and 1 to get 1 so the list converts to [1,1,1] then,
     * we combine 1 and 1 to get 0 so the list converts to [1] then that's the
     * value of the last stone.
     *
     * Example 2:
     *
     * Input: boulders = [1]
     * Output: 1
     *
     *
     *
     * RECOMMENDED APPROACH
     *
     * Initializing Priority Queue in reverse order, so that it gives
     * max element at the top. Taking top Elements and performing the
     * given operations in the question as long as 2 or more boulders;
     * returning the 0 if queue is empty else return pq.peek().
     */

  public static int lastBoulder(int[] boulders) {

      //
      // ADD YOUR CODE HERE - DO NOT FORGET TO ADD YOUR NAME / SECTION # ABOVE
      //
      return -1;
  }


    /**
     * Method showDuplicates
     *
     * This method identifies duplicate strings in an array list. The list
     * is passed as an ArrayList<String> and the method returns an ArrayList<String>
     * containing only unique strings that appear more than once in the input list.
     * This returned array list is returned in sorted ascending order. Note that
     * this method should consider case (strings are case-sensitive).
     *
     * For example, if the input list was: "Lion", "Dog", "Cat", "Dog", "Horse", "Lion", "CAT"
     * the method would return an ArrayList<String> containing: "Dog", "Lion"
     *
     * @param  input an ArrayList<String>
     * @return       an ArrayList<String> containing only unique strings that appear
     *               more than once in the input list. They will be in ascending order.
     *
     * In class, we have been talking about how sorting helps in faster searching and retrieval. 
     * There are also some sortinng trade-offs. In this specific situation, we are focused on 1) collecting duplicate values and 2) then sorting in ascending order. 
     * 1) We have talked about how ArrayLists are inefficient for searching. Sets actually provide a efficient implementation for basic operations. Specifically, HashHets is a data structure that would be great in keeping tack of the strings that have already been encountered in the input list.
     * 2) Referencing to the slides, we can see that we can easily sort lists in java by using the sort methods of the collection classes in java.util. This sorting method is a version of quick-sort.
     * 
     * Psuedocode: 
     * Initialize a HashSet to track strings that have already been seen
     * Initialize a new ArrayList to store duplicates
     *
     * Iterate over the input list to find duplicates 
     *    If the string is alrady in seen (so its a duplicate) and not in duplicates, add it to the duplicate ArrayList
     *    Otherwise, the string has not been seen, add it to the seen set
     *
     * Sort the duplicates ArrayList using Collection's built-in sort
     * Return the duplicates ArrayList
     */

    public static ArrayList<String> showDuplicates(ArrayList<String> input) {
        HashSet<String> seen = new HashSet<>();
        ArrayList<String> duplicates = new ArrayList<>();
        //Iterate over the input list
        for(int i = 0; i < input.size(); i++){
            String str = input.get(i); //Access each string in the input list

            //If the sttring has already been seen and is not in duplicates, add it to duplicates
            if(seen.contains(str)){
                if(!duplicates.contains(str)){
                    duplicates.add(str);
                }
            } else {
                //If the string hasn't been seen yet, add it to the 'seen' set
                seen.add(str);
            }
        }

        Collections.sort(duplicates);
            
        return duplicates;

    }


    /**
     * Finds pairs in the input array that add up to k.
     *
     * @param input   Array of integers
     * @param k       The sum to find pairs for

     * @return an ArrayList<String> containing a list of strings. The ArrayList
     *        of strings needs to be ordered both within a pair, and
     *        between pairs in ascending order. E.g.,
     *
     *         - Ordering within a pair:
     *            A string is a pair in the format "(a, b)", where a and b are
     *            ordered lowest to highest, e.g., if a pair was the numbers
     *            6 and 3, then the string would be "(3, 6)", and NOT "(6, 3)".
     *         - Ordering between pairs:
     *            The ordering of strings of pairs should be sorted in lowest to
     *            highest pairs. E.g., if the following two string pairs within
     *            the returned ArraryList, "(3, 6)" and "(2, 7), they should be
     *            ordered in the ArrayList returned as "(2, 7)" and "(3, 6 )".
     *
     *         Example output:
     *         If the input array list was {2, 3, 3, 4, 5, 6, 7}, then the
     *         returned ArrayList<String> would be {"(2, 7)", "(3, 6)", "(4, 5)"}
     *
     *  HINT: Considering using any Java Collection Framework ADT that we have used
     *  to date, though HashSet. Consider using Java's "Collections.sort()" for final
     *  sort of ArrayList before returning so consistent answer. Utilize Oracle's
     *  Java Framework documentation in its use.
     *
     * So not only do the instructions require to find a pair of numbers in the given array that add up to K, they should also be returned in a sorted list of formatted strings. Each pair has to be in ascending order.
     * Just like the previous method, the logic is very similar. It makes sense to utilize HashSets in this method as well. 
     * The 'seen' HashSet will help store the numbers we've already encountered. The way this problem diverges from the prev. method is that we need a second HashSet. One that ensures that we don't add duplicate pairs to the final list. We are returning a list of pairs. 
     * 
     * Initialize a HashSet to track integers that have already been seen
     * Initialize a HashSet to track string pairs to ensure there are no duplicates
     * Initialize a ArrayList to store our final output strings 
     * 
     * for(the length of the array)
     *    initialize variable to represent a number in the array according to the i 
     *    initialize variable to represent its required pair number that will result in k
     *    if(the complement already exists in seen, then we have found a valid pair) --> however, we need to take the added step of ensuring the string is formatted correctly. For example, 6,3 will be resorted to 3,6
     *        initialize int variable that will represent the larger number in the pair     
     *        initialize int variable that will represent the smaller number in the pair  
     *        initialize string variable that will represent the correct ordered pair (small first)
     *
     *        if(the pair is NOT already added in the HashSet that ensures to avoid duplicates, that means it is a new pair and it should be added to the ArrayList)
     *            add the pair to the HashSet that holds duplicates so that it cannot be added again to the ArrayList
     *            add the pair to the ArrayList
     *         
     *    add the number in seen so future #'s can check against it
     * 
     * After all that, 
     * sort the list of pairs 
     */

    public static ArrayList<String> pair(int[] input, int k) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> foundPairs = new HashSet<>();
        ArrayList<String> newList = new ArrayList<>();
        //Iterate over the input list 
        for(int i = 0; i < input.length; i++){
            int num = input[i];
            int complement = k - num; //Find the required pair number

            if(seen.contains(complement)){
                int large = Math.max(num, complement);
                int small = Math.min(num, complement);
                String finalizedPair = "(" + small + ", " + large + ")";

                if(!foundPairs.contains(finalizedPair)){
                    foundPairs.add(finalizedPair);
                    newList.add(finalizedPair);
                }
            }
            
            seen.add(num); //Add the current number to the seen set
        }

        //Sort the final list of pairs
        Collections.sort(finalizedPair);

        return finalizedPair;
    }
}
