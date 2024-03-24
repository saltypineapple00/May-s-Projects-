public class GameLogic
{
    private boolean win;
    private boolean tie;

    /**
     * default constructor
     */
    GameLogic()
    { }

    /**
     * To check if there is a winner
     * @param array
     * @param input
     * @param row
     * @param col
     * @return
     */
    public boolean isWin(char [][] array, int input, int row, int col)
    {
        //checking horizontal pieces -
        for (int i = 0; i <array.length; i++)
        {
            for (int j = 0; j <= array.length-input; j++)
            {
                int repeat = 0;
                for (int k = 0; k < input; k++)
                {
                    if (array[i][j+k] == array[i][j] && array[i][j] != 0)
                    {
                        repeat++;
                    }
                }
                if (repeat==input)
                {
                    return true;
                }
            }
        }

        //checking vertical pieces |
        for (int i = 0; i <=array.length-input; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                int repeat = 0;
                for (int k = 0; k < input; k++)
                {
                    if (array[i+k][j] == array[i][j]  && array[i][j] != 0)
                    {
                        repeat++;
                    }
                }
                if (repeat==input)
                {
                    return true;
                }
            }
        }

        //checking right diagonal pieces \
        for (int i = 0; i <=array.length-input; i++)
        {
            for (int j = 0; j <= array.length-input; j++)
            {
                int repeat = 0;
                for (int k = 0; k < input; k++)
                {
                    if (array[i+k][j+k] == array[i][j]  && array[i][j] != 0)
                    {
                        repeat++;
                    }
                }
                if (repeat==input)
                {
                    return true;
                }
            }
        }

        //checking left diagonal pieces /

        for (int i = 0; i <= array.length-input; i++)
        {
            for (int j = array.length - 1; j >= input - 1; j--)
            {
                int repeat = 0;
                for (int k = 0; k < input; k++)
                {
                    if (array[i][j] == array[i+k][j-k] && array[i][j] != 0)
                    {
                        repeat++;
                    }
                }
                if (repeat == input)
                    return true;
            }
        }
        return false;
    }

    /**
     * checking to see if there is a tie after the board is filled
     * @param array
     * @return
     */
    public boolean isTie (char [][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                if(array[i][j] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
