public class Board
{
    private Slot[][] board;
    
    public Board(){
         board = new Slot[9][9];
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
     * @param x The colom / x-coordinate
     * @param num is the number it should set to
     * @return if the col is clear of that number
     */
    public boolean checkColom(int x, int num)
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
        return (checkRow(y,num) && checkColom(x, num) && checkThreeSquare(x,y,num));
    }
}