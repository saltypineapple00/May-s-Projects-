public class Board
{
    private char [][] twoDArray;

    /**
     * Default constructor
     * @param piece
     */
    Board(char [][] piece)
    {
        twoDArray = piece;
    }

    /**
     * To draw the board
     * @param num
     */
    public void draw(int num)
    {
        System.out.print("  |");
        for (int i = 0; i < num+1; i++)
        {
            System.out.print(" "+i+ " |");
        }
        System.out.println();
        System.out.print("---");
        for (int i = 0; i < num+1; i++)
        {
            System.out.print("----");
        }
        System.out.println();
        for (int i = 0; i < num+1; i++)
        {
            System.out.print(i+" |");
            for (int j = 0; j < num+1; j++)
            {
                if (twoDArray[i][j] == 0)
                {
                    System.out.print("   |");
                }
                else
                {
                    System.out.print(" " + twoDArray[i][j]+" |");
                }
            }
            System.out.println();
            System.out.print("---");
            for (int k = 0; k < num+1; k++)
            {
                System.out.print("----");
            }
            System.out.println();
        }
    }

    /**
     * To replace the space in the board with the player's character/piece
     * @param row
     * @param col
     * @param piece
     */
    public void replace (int row, int col, char piece)
    {
        twoDArray[row][col]=piece;
    }

}
