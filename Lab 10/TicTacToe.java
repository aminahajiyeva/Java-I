import java.util.*;

/**
 * A class modelling a tic-tac-toe (noughts and crosses, Xs and Os) game.
 * 
 * @author Lynn Marshall
 * @version November 8, 2012
 * 
 * @author Amina Hajiyeva 101303729
 */

public class TicTacToe
{
    public static final String PLAYER_X = "X"; // player using "X"
    public static final String PLAYER_O = "O"; // player using "O"
    public static final String EMPTY = " ";  // empty cell
    public static final String TIE = "T"; // game ended in a tie

    private String player;   // current player (PLAYER_X or PLAYER_O)

    private String winner;   // winner: PLAYER_X, PLAYER_O, TIE, EMPTY = in progress

    private int numFreeSquares; // number of squares still free

    private String board[][]; // 3x3 array representing the board

    /** 
     * Constructs a new Tic-Tac-Toe board.
     */
    public TicTacToe()
    {
        board = new String[3][3];
    }

    /**
     * Sets everything up for a new game.  Marks all squares in the Tic Tac Toe board as empty,
     * and indicates no winner yet, 9 free squares and the current player is player X.
     */
    private void clearBoard()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
        winner = EMPTY;
        numFreeSquares = 9;
        player = PLAYER_X;     // Player X always has the first turn.
    }

    /**
     * Plays one game of Tic Tac Toe.
     */

    public void playGame()
    {
        int row, col;
        Scanner sc;

        clearBoard(); // clear the board

        // print starting board
        print();

        // loop until the game ends
        while (winner==EMPTY) { // game still in progress

            // get input (row and column)
            while (true) { // repeat until valid input
                System.out.print("Enter row and column of chosen square (0, 1, 2 for each): ");
                sc = new Scanner(System.in);
                row = sc.nextInt();
                col = sc.nextInt();
                if (row>=0 && row<=2 && col>=0 && col<=2 && board[row][col]==EMPTY) break;
                System.out.println("Invalid selection, try again.");
            }

            board[row][col] = player;        // fill in the square with player
            numFreeSquares--;            // decrement number of free squares

            // see if the game is over
            if (haveWinner(row,col)) 
                winner = player; // must be the player who just went
            else if (numFreeSquares==0) 
                winner = TIE; // board is full so it's a tie

            // print current board
            print();

            // change to other player (this won't do anything if game has ended)
            if (player==PLAYER_X) 
                player=PLAYER_O;
            else 
                player=PLAYER_X;
        }

    } 

    /**
     * Returns true if filling the given square gives us a winner, and false
     * otherwise.
     *
     * @param int row of square just set
     * @param int col of square just set
     * 
     * @return true if we have a winner, false otherwise
     */
    private boolean haveWinner(int row, int col) 
    {
        // unless at least 5 squares have been filled, we don't need to go any further
        // (the earliest we can have a winner is after player X's 3rd move).

        if (numFreeSquares>4) return false;

        // Note: We don't need to check all rows, columns, and diagonals, only those
        // that contain the latest filled square.  We know that we have a winner 
        // if all 3 squares are the same, as they can't all be blank (as the latest
        // filled square is one of them).

        // check row "row"
        if ( board[row][0].equals(board[row][1]) &&
        board[row][0].equals(board[row][2]) ) return true;

        // check column "col"
        if ( board[0][col].equals(board[1][col]) &&
        board[0][col].equals(board[2][col]) ) return true;

        // if row=col check one diagonal
        if (row==col)
            if ( board[0][0].equals(board[1][1]) &&
            board[0][0].equals(board[2][2]) ) return true;

        // if row=2-col check other diagonal
        if (row==2-col)
            if ( board[0][2].equals(board[1][1]) &&
            board[0][2].equals(board[2][0]) ) return true;

        // no winner yet
        return false;
    }

    /**
     * Prints the board to standard out using toString().
     */
    public void print() 
    {
        System.out.println(toString()); // print
    }

    /**
     * Returns a string representing the current state of the game.  This should look like
     * a regular tic tac toe board, and be followed by a message if the game is over that says
     * who won (or indicates a tie).
     *
     * @return String representing the tic tac toe game state
     */
    public String toString() 
    {
        StringBuilder s = new StringBuilder(); // create string builder
        
        for(int i = 0; i < 3; i++) // iterate through 3x3 game
        {
            for(int j = 0; j < 3; j++) // iterate through each column of current row
            {
                s.append(board[i][j]); // add current value to string
                
                if(j != 2) // add character for formatting for each cell
                {
                    s.append("|");
                }
            }
            
            if(i != 2) // add characters for formating after each row
            {
                s.append("\n --------- \n");
            }
        }
        
        if(winner.equals(TIE)) // check game result
        {
            s.append("\n Its a tie"); // print message to user
        }
        else if(!winner.equals(EMPTY)) // check game result
        {
            s.append("\n" +winner + " is the winner"); // print message to user
        }
        
        return s.toString(); // convert string builder to string and return it
    }
}