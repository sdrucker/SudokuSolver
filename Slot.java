import java.util.ArrayList;
/**
 * This class is used to represent a single slot on the Sudoku board.
 * It holds a list of possibilities, initially at 1-9, and as the solution
 * to the board is computed these possibilities will disappear.
 * 
 * @author Sam Drucker, Dani Dickstein
 * @version 0.1
 */
public class Slot {
    
    private ArrayList<Integer> possibilities;
    
    /**
     * Constructor for a Slot in the Sudoku board.  Generates a new ArrayList of
     * possibilities with Integers from 1-9.
     */
    public Slot() {
        possibilities = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            possibilities.add(i);
        }
    }
    
    /**
     * Constructor for a Slot in the Sudoku board.  The slot is initialized to the given value.
     * @param i The computed answer for this Slot (no other possibilities will exist)
     */
    public Slot(int i) {
        possibilities = new ArrayList<Integer>();
        possibilities.add(i);
    }
    
    /**
     * Find the number of possibilities remaining for this slot.
     * @return Number of remaining possibilities.
     */
    public int numPossibilities() {
        return possibilities.size();
    }
    
    /**
     * Determines whether the slot has only one possibility remaining.
     * @return Whether the slot has a specific answer
     */
    public boolean isSingle() {
        return numPossibilities() == 1;
    }
    
    
    /**
     * If the slot has a specific answer, this method returns the answer.  Otherwise,
     * this method returns -1.
     * @return The computed answer for this slot
     */
    public int getAnswer() {
        if (isSingle())
            return possibilities.get(0);
        else
            return -1;
    }

    /**
     * Regardless of whether this slot has a specific answer or not, this method will
     * return the first possibility of what this slot might contain.
     * @return The first of this slot's possible values
     */
    public int first() {
        return possibilities.get(0);
    }
    
    /**
     * Same as {@link #getAnswer() getAnswer()}
     * @see #getAnswer()
     */
    public int value() {
        return getAnswer();
    }
    
    /**
     * Returns an integer array representing the number of possibilities remaining for this Slot.
     * @return The remaining possibilities.
     */
    public int[] getPossibilities() {
        int[] arr = new int[numPossibilities()];
        for (int i = 0; i < numPossibilities(); i++) {
            arr[i] = (int)possibilities.get(i);
        }
        return arr;
    }
    
    /**
     * Returns whether or not a given possibility is on the possibility list.
     * @param pos The possibility number
     * @return Whether the number isa possibility
     */
    public boolean hasPossibility(int pos){
        return possibilities.contains((Integer)pos);
    }
    
    /**
     * Removes a given integer from the list of remaining possibilities.
     * @param i The integer to remove
     */
    public void remove(int i) {
        possibilities.remove(i);
    }
    
    /**
     * Sets a specific integer as the answer for this slot, removing all possibilities from the
     * list other than itself.
     * @param i The integer to set as the answer
     */
    public void set(int i) {
        possibilities.clear();
        possibilities.add(i);
    }
}