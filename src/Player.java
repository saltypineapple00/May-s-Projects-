import java.util.Scanner;
public class Player
{
    private char [] array1;

    /**
     * Default constructor to initialize array
     * @param i
     */
    Player(int i)
    {
        array1=new char[i];
    }

    /**
     * To keep the players' characters in an array
     */
    public void charAssign ()
    {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < array1.length; i++)
        {
            System.out.println("Enter the characters player " +  (i+1) + " wants to use (choose only one character): ");
            char c =  scan.next().charAt(0);
            while (isFound(c))
            {
                System.out.println("You cannot use the same character. Please pick another piece: ");
                scan.nextLine();
                c=scan.next().charAt(0);
            }
            array1[i] = c;
        }
    }

    /**
     * To get the char/piece at that index
     * @param index
     * @return
     */
    public char getChar (int index)
    {
        return array1[index];
    }

    /**
     * To check if the character already exists in an array. Helper make sure no same character is picked.
     * @param piece
     * @return
     */
    public boolean isFound (char piece)
    {
        for (int i = 0; i < array1.length; i++)
        {
            if (piece == array1[i])
            {
                return true;
            }
        }
        return false;
    }

}