import java.util.ArrayList;
/**
 * This Solver class is supposed to solve Sudoku puzzles.
 * @author Sam Drucker, Dani Dickstein
 * @version 0.1
 */
public class Solver {
    
    private ArrayList<Board> boards;
    /**
     * This is the constructor for a Sudoku Solver
     */
    public Solver() {
        boards = new ArrayList<Board>();
        generateAllSolutions();
    }
    
    /**
     * Generates all possible valid sudoku solutions and stores them in the Solver
     */
    public void generateAllSolutions() {
        
    }
    
    /**
     * Removes all boards that contain a certain number at a certain position.
     * @param x The column / x-coordinate
     * @param y The row / y-coordinate
     * @param n The number to check
     */
    public void removeInvalid(int x, int y, int n) {
        
    }
}