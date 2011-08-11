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
        //limit();
        //solve();
        //printFirstPossible();
        for (int i = 1; i < 10; i++) {
            Slot[] arr = board.getSquare(i);
            System.out.print(i+": ");
            for (Slot elem : arr) {
                System.out.print(elem.value()+" ");
            }
            System.out.println();
        }
    }

    /**
     * Place limiters on the board based on input from this particular Sudoku puzzle.
     */
    public void limit() {
        boolean exit = false;
        SuperScanner input = new SuperScanner(System.in);
        do {
            System.out.print("\fEnter row: ");
            int r = input.nextInt();
            System.out.print("Enter col: ");
            int c = input.nextInt();
            System.out.print("Enter num: ");
            int n = input.nextInt();
            System.out.print("Are you sure everything you entered was correct? ");
            if (input.confirm())
                board.getSlot(c,r).set(n);
            else
                continue;
            System.out.print("Do you have more values to enter? ");
            if (!input.confirm())
                exit = true;
        } while (!exit);
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
     * Prints the first possible board based on the current slots.
     */
    public void printFirstPossible() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(board.getSlot(c,r).first()+" ");
            }
            System.out.println();
        }
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
        Slot[] Sbox = board.getSquare(board.getSquareNumber(c,r));
        Slot[] Srow = board.getRow(r);
        Slot[] Scol = board.getCol(c);
        int[] box = new int[9];
        int[] row = new int[9];
        int[] col = new int[9];
        for (int i = 0; i < 9; i++) {
            box[i] = Sbox[i].value();
            row[i] = Srow[i].value();
            col[i] = Scol[i].value();
        }
        
        for (int i=1;i<10;i++) {
            if (contains(row,i) || contains(col,i) || contains(box,i)) {
                board.getSlot(c,r).remove(i);
                return true;
            }
        }
        return false;
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