import java.util.ArrayList;
import java.util.Arrays;
/**
 * This Solver class is supposed to solve Sudoku puzzles.
 * @author Sam Drucker, Dani Dickstein
 * @version 0.1
 */
public class Solver {
    
    private Board board;
    /**
     * This is the constructor for a Sudoku Solver
     */
    public Solver() {
        board = new Board();
        solve();
    }
    
	/**
	 * Actually performs the solving
	 * >> This method is incomplete, and will be developed as the application progresses.
	 */
	public void solve() {
		do {
			for (int c = 0; c < 9; c++) {
				for (int r = 0; r < 9; r++) {
					if (!(board.getSlot(c,r).isSingle()))
						singlify(c,r);
				}
			}
		} while (!singlified());
	}

    /**
     * Checks whether all of the cells that can be evaluated by basic methods have been simplified as much as possible
     */
    public boolean singlified() {
		for (int c = 0; c < 9; c++) {
			for (int r = 0; r < 9; r++) {
				if (!singlify(c,r))
					return false;
			}
		}
		return true;
    }
    
	/**
	 * Simplifies a slot as method, trying to make it "single" if possible
	 * @return Whether any removal of the slot occurred
 	 */
	public boolean singlify(int c, int r) {
		int[] box = board.getSquare(board.getSquareNumber(c,r));
		int[] row = board.getRow(r);
		int[] col = board.getCol(c);
		for (int i=1;i<10;i++) {
			if (contains(row,i) || contains(col,i) || contains(box,i)) {
				boardgetSlot(c,r).remove(i);
			}
		}
	}

	private boolean contains(int[] arr, int key) {
		return Arrays.asList(wrap(arr)).contains((Integer)key);
	}
	
	private Integer[] wrap(int[] arr) {
		Integer[] wrapperArray = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			wrapperArray[i]=(Integer)arr[i];
		}
		return wrapperArray;
	}
	
	private int[] unwrap(Integer[] arr) {
		int[] primitiveArray = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			primitiveArray[i]=(int)arr[i];
		}
		return primitiveArray;
	}
}