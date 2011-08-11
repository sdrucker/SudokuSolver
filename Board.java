
public class Board
{
    private int[][] board = new int[9][9];
    public Board(){}

    public Board(int [][] array)
    {
        board = array;
    }

    /**
     * This method returns the number in a spot.
     * @param x The column / x-coordinate
     * @param y The row / y-coordinate
     * @return the number int the spot
     */
    public int getNumberInSpot(int x, int y)
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
        board[x][y] = num; //board[newX][newY];
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
            if (board[i][y] == num)
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
            if (board[x][i] == num)
                return false;
        }
        return true;
    }

    public int [][] returnBoard()
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
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }
    
    public int [] returnRow(int y)
    {
        int[] row = new int[9];
        for (int i =0;i<9;i++)
        {
            row[i]=board[i][y];
        }
        return row;
    }

    public int [] returnColumn(int x)
    {
        int[] row = new int[9];
        for (int i =0;i<9;i++)
        {
            row[i]=board[x][i];
        }
        return row;
    }

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
    public int getIStarterForSquares(int num)
    {
        
        if (num == 0|| num == 3|| num ==6)
        return 0;
        if (num == 1|| num == 4|| num ==7)
        return 3;
        else
        return 6;
        
    }
    public int getJStarterForSquares(int num)
    {
        if (num < 3)
        return 0;
        else if (num < 6)
        return 3;
        else 
        return 6;
    }
    
    public int [] returnSquare(int squareNum)
    {
        int i = getIStarterForSquares(squareNum);
        int j = getJStarterForSquares(squareNum);
        int iMax = i +3;
        int jMax = j + 3;
        int[] square = new int[9];
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
    
    public boolean checkAll(int x, int y, int num)
    {
        if((checkRow(y,num)==true) && (checkColumn(x, num)==true)&& (checkThreeSquare(x,y,num)==true))
        {
            return true;
        }
        else
            return false;
    }
    
    public int[] getRow(int r) {
        return returnRow(r);
    }
    
    public int[] getColumn(int c) {
        return returnColumn(c);
    }
    
    public int[] getCol(int c) {
        return returnColumn(c);
    }
    
    public int[] getSquare(int s) {
        return returnSquare(s);
    }
}
