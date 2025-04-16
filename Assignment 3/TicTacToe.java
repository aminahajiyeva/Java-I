import javax.swing.*;
import java.util.*;

/**
 * A class modelling a tic-tac-toe (noughts and crosses, Xs and Os) game.
 *
 * @author Lynn Marshall
 * @version November 8, 2012
 *
 * @author Amina Hajiyeva 101303729
 * @version April 2025
 */

public class TicTacToe 
{
    public static final String PLAYER_X = "X"; // the player that is using "X"
    public static final String PLAYER_O = "O"; // the player that is using "O"
    public static final String EMPTY = " ";  // the cell that is empty
    public static final String TIE = "T"; // in the event a gmae ends in a tie

    private String player;   // stores the current player (X or O)

    protected String winner;   // stores winner of game, or tie, or in progress

    protected int numFreeSquares; // free squares remaning

    protected JButton[][] board = new JButton[3][3]; // buttons

    private int row, col;

    /**
     * Constructs a new Tic-Tac-Toe board.
     */
    public TicTacToe() 
    {
        winner = EMPTY;
        clearBoard();
    }

    /**
     * Sets everything up for a new game.  Marks all squares in the Tic Tac Toe board as empty,
     * and indicates no winner yet, 9 free squares and the current player is player X.
     */
    public void clearBoard() 
    {   
        winner = EMPTY;
        numFreeSquares = 9;
        player = PLAYER_X;     // first turn
    }

    /**
     * Change the current player to the next.
     */
    public void updateGame()
    {
        // change to the other player
        if (player == PLAYER_X)
            player = PLAYER_O;
        else
            player = PLAYER_X;
    }

    /**
     * Updates winner field.
     */
    public void playGame(int row, int col) 
    {
        if (haveWinner(row, col))
        {
            winner = player; // player who just went
        }
        else if (numFreeSquares == 0)
        {
            winner = TIE; // tie since full board
        }
    }

    /**
     * Returns true if filling the given square gives us a winner, and false
     * otherwise. Uses the text on the button to check.
     *
     * @param row row of square just set
     * @param col col of square just set
     * @return true if we have a winner, false otherwise
     */
    public boolean haveWinner(int row, int col) 
    {
        // if 5 squares filled, dont need to proceed
        if (numFreeSquares > 4) 
        {
            return false;
        }

        if (board[row][0].getText().equals(board[row][1].getText()) &&
        board[row][0].getText().equals(board[row][2].getText())) 
        {    
            return true; // check row
        }

        if (board[0][col].getText().equals(board[1][col].getText()) &&
        board[0][col].getText().equals(board[2][col].getText())) 
        {
            return true; // check column
        }

        if (row == col)
        {
            if (board[0][0].getText().equals(board[1][1].getText()) &&
            board[0][0].getText().equals(board[2][2].getText())) 
            {
                return true; // check diagonal (row = col)
            }
        }

        if (row == 2 - col)
        {
            if (board[0][2].getText().equals(board[1][1].getText()) &&
            board[0][2].getText().equals(board[2][0].getText())) 
            {
                return true; // check other diagonal (row = 2-col)
            }
        }
        
        return false; // winner not yet determined
    }

    /**
     * Returns a string containing the current player's symbol (X or O)
     *
     * @return a string containing the current player's symbol (X or O)
     */
    public String print_text()
    {
        return player; // current player
    }
}
