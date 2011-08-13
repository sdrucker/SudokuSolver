import java.util.Arrays;
public class Board
{
    private Slot[][] board;

    public Board(){
        board = new Slot[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new Slot();
            }
        }
    }

    public Board(Slot[][] array)
    {
        board = array;
    }

    /**
     * This method returns the number in a spot.
     * @param x The column / x-coordinate
     * @param y The row / y-coordinate
     * @return the slot object for the spot
     */
    public Slot getSlot(int x, int y)
    {
        return board[x][y];
    }

    /**
     * This method sets the number in a spot.
     * @param x The column / x-coordinate
     * @param y The row / y-coordinate
     * @param num is the number it should set to
     */
    public void setNumberInSpot(int x, int y, int num)
    {
        board[x][y].set(num);
    }

    /**
     * This method checks if a given value is in the row
     * @param y The row / y-coordinate
     * @param num is the number it should set to
     * @return if the row is clear of that number
     */
    public boolean checkRow(int y, int num)
    {
        for (int i = 0; i < 9; i++)
        {
            if (board[i][y].value() == num)
                return false;
        }
        return true;
    }

    /**
     * This method checks if a given value is in the col
     * @param x The column / x-coordinate
     * @param num is the number it should set to
     * @return if the col is clear of that number
     */
    public boolean checkColumn(int x, int num)
    {
        for (int i = 0; i < 9; i++)
        {
            if (board[x][i].value() == num)
                return false;
        }
        return true;
    }

    public Slot[][] returnBoard()
    {
        return board;
    }

    /**
     * This method checks a box to see if a given number is present.
     * @param x The column / x-coordinate
     * @param y The row / y-coordinate
     * @param num The number you are checking
     * @return Whether the number is present in the box
     */
    public boolean checkThreeSquare(int x, int y, int num)
    {
        int i,j,iTop, jTop;
        if (x < 2)
            i = 0;
        else if (x<5)
            i = 3;
        else
            i = 6;
        if (x < 2)
            j = 0;
        else if (x<5)
            j = 3;
        else
            j = 6;
        iTop = i + 3;
        jTop = j + 3;   
        for (;i < iTop;i++)
        {
            for (;j< jTop; j++)
            {
                if (board[i][j].value() == num)
                    return false;
            }
        }

        return true;
    }

    public boolean checkAll(int x, int y, int num)
    {
        return (checkRow(y,num) && checkColumn(x, num) && checkThreeSquare(x,y,num));
    }

    public Slot[] returnRow(int y)
    {
        Slot[] row = new Slot[9];
        for (int i =0;i<9;i++)
        {
            row[i]=board[i][y];
        }
        return row;
    }

    public Slot[] returnColumn(int x)
    {
        Slot[] col = new Slot[9];
        for (int i =0;i<9;i++)
        {
            col[i]=board[x][i];
        }
        return col;
    }

    public boolean checkIfRowIsComplet(int y)
    {
        Slot [] checkArray = new Slot [9];
        checkArray = returnRow(y);
        int [] sortArray = new int [9];
        for (int i = 0; i < 9; i++)
        {
            sortArray [i] = checkArray[i].value(); 
        }
        Arrays.sort(sortArray);
        for (int i = 0; i < 9; i++)
        {
            if (sortArray[i] !=i)
            return false;
        }
        return true;
    }
    
    public boolean checkIfColIsComplete(int x)
    {
        Slot [] checkArray = new Slot [9];
        checkArray = returnColumn(x);
        int [] sortArray = new int [9];
        for (int i = 0; i < 9; i++)
        {
            sortArray [i] = checkArray[i].value(); 
        }
        Arrays.sort(sortArray);
        for (int i = 0; i < 9; i++)
        {
            if (sortArray[i] !=i)
            return false;
        }
        return true;
    }
    
    public boolean checkIfSquareIsComplete(int squareNum)
    {
        Slot [] checkArray = new Slot [9];
        checkArray = returnSquare(squareNum);
        int [] sortArray = new int [9];
        for (int i = 0; i < 9; i++)
        {
            sortArray [i] = checkArray[i].value(); 
        }
        Arrays.sort(sortArray);
        for (int i = 0; i < 9; i++)
        {
            if (sortArray[i] !=i)
            return false;
        }
        return true;
    }
    /**
     * This method finds the box number 0-8.
     * @param x The column / x-coordinate
     * @param y The row / y-coordinate
     * @return box num
     */
    public int getSquareNumber(int x, int y)
    {

        if (x < 2 && y < 2)
            return 0;
        else if(y < 2 && x < 5)
            return 1;
        else if(y < 2)
            return 2;
        else if (y < 5 && x < 2)
            return 3;
        else if (y < 5 && x < 5)
            return 4;
        else if (y < 5)
            return 5;
        else if (x < 2)
            return 6;
        else if (x < 5)
            return 7;
        else
            return 8;
    }

    public Slot[] returnSquare(int squareNum)
    {
        int i = getIStarterForSquares(squareNum);
        int j = getJStarterForSquares(squareNum);
        int iMax = i +3;
        int jMax = j + 3;
        Slot[] square = new Slot[9];
        int count = 0;

        for (; j < jMax; j++)
        {
            square[count]= board[i][j];
            count++;
        }
        j = jMax- 3;
        i++;
        for (; j < jMax; j++)
        {
            square[count]= board[i][j];
            count++;
        }
        i++;
        j = jMax- 3;
        for (; j < jMax; j++)
        {
            square[count]= board[i][j];
            count++;
        }
        return square;
    }
    
    public Slot get(int c, int r) {
        return getSlot(c,r);
    }

    public Slot[] getRow(int r) {
        return returnRow(r);
    }

    public Slot[] getColumn(int c) {
        return returnColumn(c);
    }

    public Slot[] getCol(int c) {
        return returnColumn(c);
    }

    public Slot[] getSquare(int s) {
        return returnSquare(s);
    }

    private int getIStarterForSquares(int num)
    {
        if (num == 0|| num == 3|| num ==6)
            return 0;
        if (num == 1|| num == 4|| num ==7)
            return 3;
        else
            return 6;
    }

    private int getJStarterForSquares(int num)
    {
        if (num < 3)
            return 0;
        else if (num < 6)
            return 3;
        else 
            return 6;
    }
}