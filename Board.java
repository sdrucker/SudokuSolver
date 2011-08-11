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

    /*
     * Sam - sometimes it's easier to follow condensed code, and often many lines are unnecessary.
     * The first way I condensed this method was by eliminating the "==true" parts of the conditions.
     * Saying if(a==true) is the same as saying if(a).  Next you said if (condition) return true else
     * return false.  That can be condensed to simply return (condition), which will return true if
     * the condition evaluates to true, and false otherwise.  As a general rule if you can condense your
     * code without making it impossibly complicated to read, you should. 
     */
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

    /*
     * Sam - when you have a matrix mat[a][b] and you want all of the elements in a single a
     * strip, you can just use mat[a] and it will return the array you want.  However, if you
     * want all the elements in a single b strip, you need to iterate through the matrix like
     * you did in the returnRow method.
     */
    public Slot[] returnColumn(int x)
    {
        return board[x];
    }

    /*
     * Comment this method - also use internal comments here on the logic of the if
     * statements so it's easier to follow.  If you ever write a method that is intricate
     * enough that you think that if you come back in a week you might not remember how it
     * works or be able to debug it, you should use internal comments.  If you think
     * you will still understand it because it's written clearly / is obvious,
     * you don't necessarily need the internal notes, but you should still have JavaDoc.
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

    /*
     * Comment this method - not sure what it does.
     * NOTE: If this is just a method that you use internally in one of your
     * other methods but I'm not supposed to invoke it outside of this class,
     * make it "private" instead of public and put it at the bottom of the class.
     */
    public int getIStarterForSquares(int num)
    {

        if (num == 0|| num == 3|| num ==6)
            return 0;
        if (num == 1|| num == 4|| num ==7)
            return 3;
        else
            return 6;

    }

    /*
     * Comment this method - not sure what it does.
     * NOTE: If this is just a method that you use internally in one of your
     * other methods but I'm not supposed to invoke it outside of this class,
     * make it "private" instead of public and put it at the bottom of the class.
     */
    public int getJStarterForSquares(int num)
    {
        if (num < 3)
            return 0;
        else if (num < 6)
            return 3;
        else 
            return 6;
    }

    public Slot[] returnSquare(int squareNum)
    {
        int i = getIStarterForSquares(squareNum);
        int j = getJStarterForSquares(squareNum);
        int iMax = i +3;
        int jMax = j + 3;
        Slot[] square = new Slot[9];
        int count = 0;
        for (; i < iMax; i ++)
        {
            for (; j < jMax; j++)
            {
                square[count]= board[i][j];
                count++;
            }
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
}