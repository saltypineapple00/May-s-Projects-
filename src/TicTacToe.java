import java.util.Scanner;
public class TicTacToe
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int players =0, row =0, col=0, inARow =0;

        //Asking for players and checking out of bounds
        System.out.println("Enter the number of players between 3-10: ");
        do{
            while (!scan.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a number: ");
                scan.nextLine();
            }
            players =  scan.nextInt();

            if(players < 3 || players >10)
            {
                System.out.println("Invalid number of players! Please enter a number: ");
               // scan.nextLine();
            }
            scan.nextLine();
        }while (players < 3 || players >10);

        Player player1=new Player(players);
        player1.charAssign();

        //Asking for pieces in a row to win
        System.out.println("Choose how many pieces in a row it needs to be to win ( between 3 -"+ (players +1)+ " ): ");
        do{
            while (!scan.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a number: ");
                scan.nextLine();
            }
            inARow = scan.nextInt();

            if(inARow < 3 || inARow >(players+1))
            {
                System.out.println("Invalid number of pieces in a row! Please enter a number: ");
                //scan.nextLine();
            }
            scan.nextLine();

        }while (inARow < 3 || inARow >(players+1));

        //Drawing the blank board
        char [][] board = new char[players+1][players+1] ;
        Board b = new Board(board);
        b.draw(players);

        boolean winFound = false;

        //Checking for a winner or a tie
        while (!winFound)
        {
            for (int i = 0; i < players; i++)
            {
                do
                {
                    System.out.println("Enter the row player " + (i+1) + " wants to choose: ");
                    row = scan.nextInt();
                    while (row < 0 || row >players)
                    {
                        System.out.println("Invalid input! Please enter a valid number: ");
                        scan.nextLine();
                        row = scan.nextInt();
                    }

                    System.out.println("Enter the col player " + (i+1) + " wants to choose: ");
                    col = scan.nextInt();
                    while(col < 0 || col >players)
                    {
                        System.out.println("Invalid input! Please enter a valid number: ");
                        scan.nextLine();
                        col = scan.nextInt();
                    }
                    if (board[row][col] != 0)
                    {
                        System.out.println("The position is already taken, choose another position.");
                    }
                }while (board[row][col] != 0);

                b.replace(row,col, player1.getChar(i));
                b.draw(players);

                GameLogic gl = new GameLogic();

                if (gl.isWin(board,inARow,row,col))
                {
                    System.out.println("Player " + (i+1) + " is a winner!");
                    winFound = true;
                    break;
                }
                if(gl.isTie(board))
                {
                    System.out.println("The game is a tie.");
                    winFound = true;
                    break;
                }
            }
        }

    }
}
